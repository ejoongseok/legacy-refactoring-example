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
        if (vatCode.startsWith("FR") || "GB".equals(countryId)) {
            return vatCode;
        } else if ("MX".equals(countryId) || "ID".equals(countryId)) {
            return passNo;
        }
        return passNo;
    }

    String getKey() {
        if (vatCode.startsWith("FR") || "GB".equals(countryId)) {
            return "vatcode";
        } else if ("MX".equals(countryId) || "ID".equals(countryId)) {
            return "remark";
        }
        return "vatcode";
    }
}