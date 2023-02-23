package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RomanToIntegerTest {
    RomanToInteger.Solution solution = new RomanToInteger.Solution();

    @Test
    void should_return_3() {
        Assertions.assertEquals(3, solution.romanToInt("III"));
    }

    @Test
    void should_return_4() {
        Assertions.assertEquals(4, solution.romanToInt("IV"));
    }

    @Test
    void should_return_58() {
        Assertions.assertEquals(58, solution.romanToInt("LVIII"));
    }

    @Test
    void should_return_1994() {
        Assertions.assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }
}