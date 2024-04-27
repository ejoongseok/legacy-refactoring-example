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

    public String vatCode() {return vatCode;}

    public String countryId() {return countryId;}

    public String passNo() {return passNo;}

}