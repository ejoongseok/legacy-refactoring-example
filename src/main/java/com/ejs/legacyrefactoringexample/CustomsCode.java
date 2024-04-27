package com.ejs.legacyrefactoringexample;

public class CustomsCode {
    private final String vatCode;
    private final String countryId;
    private final String passNo;

    public CustomsCode(String vatCode, String countryId, String passNo) {
        this.vatCode = vatCode;
        this.countryId = countryId;
        this.passNo = passNo;
    }

    String getValue() {
        if (vatCode.startsWith("FR")) {
            return vatCode;
        } else if ("MX".equals(countryId)) {
            return passNo;
        }
        return null;
    }

    String getKey() {
        if (vatCode.startsWith("FR")) {
            return "vatcode";
        } else if ("MX".equals(countryId)) {
            return "remark";
        }
        return null;
    }
}