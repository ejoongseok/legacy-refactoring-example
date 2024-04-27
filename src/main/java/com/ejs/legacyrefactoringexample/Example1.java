package com.ejs.legacyrefactoringexample;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        final CustomsCode customsCode = new CustomsCode(vatCode, delivery.countryId(), delivery.passNo());
        final String key = getKey(vatCode, delivery.countryId());
        final String value = customsCode.getValue();
        putIfNotNull(request, key, value);

        // 200 line...
    }

    private String getKey(final String vatCode, final String countryId) {
        if (vatCode.startsWith("FR")) {
            return "vatcode";
        } else if ("MX".equals(countryId)) {
            return "remark";
        }
        return null;
    }

    private void putIfNotNull(final Map<String, String> request, final String key, final String value) {
        if (Objects.nonNull(key) && Objects.nonNull(value)) {
            request.put(key, value);
        }
    }

    private record Delivery(
            String countryId,
            String passNo,
            String vatCode
            // 30 fields...
    ) {
    }
}
