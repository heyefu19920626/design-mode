package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MakeSumDivisibleByPTest {
    MakeSumDivisibleByP.Solution solution = new MakeSumDivisibleByP.Solution();

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.minSubarray(new int[]{3, 1, 4, 2}, 6));
    }

    @Test
    void should_return_2() {
        Assertions.assertEquals(2, solution.minSubarray(new int[]{6, 3, 5, 2}, 9));
    }

    @Test
    void should_return_0() {
        Assertions.assertEquals(0, solution.minSubarray(new int[]{1, 2, 3}, 3));
    }

    @Test
    void should_return__1() {
        Assertions.assertEquals(-1, solution.minSubarray(new int[]{1, 2, 3}, 7));
    }

    @Test
    void should_return_0_() {
        Assertions.assertEquals(0, solution.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3));
    }
}