package com.ejs.legacyrefactoringexample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomsCodeTest {

    @Test
    @DisplayName("배송국가가 멕시코이면 key는 remark이다.")
    void testMexicanCountry() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "MX", "123456");

        // when
        final String key = customsCode.getKey();

        // then
        assertEquals("remark", key);
    }

    @Test
    @DisplayName("배송국가가 프랑스이면 key는 vatcode이다.")
    void testFrenchCountry() {
        // given
        final CustomsCode customsCode = new CustomsCode("FR1234", "FR", "123");

        // when
        final String key = customsCode.getKey();

        // then
        assertEquals("vatcode", key);
    }

    @Test
    @DisplayName("배송국가가 멕시코이면 value는 개인통관번호이다.")
    void testMexicanCountryValue() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "MX", "123456");

        // when
        final String value = customsCode.getValue();

        // then
        assertEquals("123456", value);
    }

    @Test
    @DisplayName("배송국가가 프랑스이면 value는 vatcode이다.")
    void testFrenchCountryValue() {
        // given
        final CustomsCode customsCode = new CustomsCode("FR1234", "FR", "123");

        // when
        final String value = customsCode.getValue();

        // then
        assertEquals("FR1234", value);
    }

    @Test
    @DisplayName("배송국가가 인도네시아이면 key는 remark이다.")
    void testIndonesianCountry() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "ID", "123456");

        // when
        final String key = customsCode.getKey();

        // then
        assertEquals("remark", key);
    }

    @Test
    @DisplayName("배송국가가 인도네시아이면 value는 개인통관번호이다.")
    void testIndonesianCountryValue() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "ID", "123456");

        // when
        final String value = customsCode.getValue();

        // then
        assertEquals("123456", value);
    }

    @Test
    @DisplayName("배송국가가 영국이면 key는 vatcode이다.")
    void testBritishCountry() {
        // given
        final CustomsCode customsCode = new CustomsCode("GB1234", "GB", "123");

        // when
        final String key = customsCode.getKey();

        // then
        assertEquals("vatcode", key);
    }

    @Test
    @DisplayName("배송국가가 영국이면 value는 vatcode이다.")
    void testBritishCountryValue() {
        // given
        final CustomsCode customsCode = new CustomsCode("GB1234", "GB", "123");

        // when
        final String value = customsCode.getValue();

        // then
        assertEquals("GB1234", value);
    }

    @Test
    @DisplayName("배송국가가 멕시코, 인도네시아, 프랑스, 영국이 아니면 key는 vatcode이다.")
    void testOtherCountryKey() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "US", "123456");

        // when
        final String key = customsCode.getKey();

        // then
        assertEquals("vatcode", key);
    }

    @Test
    @DisplayName("배송국가가 멕시코, 인도네시아, 프랑스, 영국이 아니면 value는 개인통관번호이다.")
    void testOtherCountryValue() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "US", "123456");

        // when
        final String value = customsCode.getValue();

        // then
        assertEquals("123456", value);
    }
}