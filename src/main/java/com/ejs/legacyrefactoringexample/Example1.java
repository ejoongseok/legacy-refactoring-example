package com.ejs.legacyrefactoringexample;

import java.util.HashMap;
import java.util.Map;

/*
기존: 멕시코이면 key가 remark이고 값이 개인통관번호,
프랑스이면 key가 vatcode이고 값이 부가세등록번호
추가 요구사항:
| 국가              | 키           | 값         |
|---------------------|-------------|----------------|
| 멕시코, 인도네시아      | `remark`  | 개인통관번호      |
| 프랑스, 영국         | `vatcode` | 부가세등록번호     |
| 그외 국가            | `vatcode` | 개인통관번호      |
 */

public class Example1 {


    public void example1(final Delivery delivery) {
        // 200 line...

        final Map<String, String> request = new HashMap<>();

        String vatCode = delivery.vatCode().trim();
        if (!vatCode.isEmpty()) {
            if ("FR".equals(delivery.countryId().trim())) {
                vatCode = "FR" + vatCode;
            }

        }
        if (vatCode.startsWith("FR")) {
            final String key = "vatcode";
            final String value = vatCode;
            request.put(key, value);
        } else if ("MX".equals(delivery.countryId())) {
            final String key = "remark";
            final String value = delivery.passNo();
            request.put(key, value);
        }

        // 200 line...
    }

    private record Delivery(
            String countryId,
            String passNo,
            String vatCode
            // 30 fields...
    ) {
    }
}
