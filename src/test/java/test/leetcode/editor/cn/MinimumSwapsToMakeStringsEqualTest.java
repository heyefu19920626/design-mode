package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumSwapsToMakeStringsEqualTest {
    MinimumSwapsToMakeStringsEqual.Solution solution = new MinimumSwapsToMakeStringsEqual.Solution();

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.minimumSwap("xx", "yy"));
    }

    @Test
    void should_return_2() {
        Assertions.assertEquals(2, solution.minimumSwap("xy", "yx"));
    }

    @Test
    void should_return__1() {
        Assertions.assertEquals(-1, solution.minimumSwap("xx", "xy"));
    }

    @Test
    void should_return_4() {
        Assertions.assertEquals(4, solution.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}