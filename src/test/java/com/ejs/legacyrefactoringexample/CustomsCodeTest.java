package com.ejs.legacyrefactoringexample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    @DisplayName("배송국가가 멕시코, 프랑스가 아니면 key는 null이다.")
    void testOtherCountry() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "US", "123456");

        // when
        final String key = customsCode.getKey();

        // then
        assertNull(key);
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
    @DisplayName("배송국가가 멕시코, 프랑스가 아니면 value는 null이다.")
    void testOtherCountryValue() {
        // given
        final CustomsCode customsCode = new CustomsCode("1234", "US", "123456");

        // when
        final String value = customsCode.getValue();

        // then
        assertNull(value);
    }


}