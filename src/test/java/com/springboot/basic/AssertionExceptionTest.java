package com.springboot.basic;

import com.springboot.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertionExceptionTest {

    @DisplayName("throws NullPointerException when map.get()")
    @Test
    public void assertionThrowExceptionTest() {
      //  assertThrows(NullPointerException.class, () -> getCryptoCurrency("XRP"));

        Throwable actualException = assertThrows(NullPointerException.class, () -> getCryptoCurrency("XRP"));
        assertThat(actualException.getClass(), is(NullPointerException.class));
    }

    @DisplayName("does not throw any Exception when map.get()")
    @Test
    public void assertionDoesNotThrowExceptionTest() {
        assertDoesNotThrow(() -> getCryptoCurrency("BTC"));
    }


    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit).toUpperCase();
    }
}
