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
        return isFranceOrGb() ? vatCode : passNo;
    }

    private boolean isMexicoOrIndonesia() {
        return "MX".equals(countryId) || "ID".equals(countryId);
    }

    private boolean isFranceOrGb() {
        return vatCode.startsWith("FR") || "GB".equals(countryId);
    }

    String getKey() {
        return isMexicoOrIndonesia() ? "remark" : "vatcode";
    }
}