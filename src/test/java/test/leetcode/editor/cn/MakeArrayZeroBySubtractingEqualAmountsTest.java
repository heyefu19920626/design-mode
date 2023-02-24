package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakeArrayZeroBySubtractingEqualAmountsTest {
    MakeArrayZeroBySubtractingEqualAmounts.Solution solution = new MakeArrayZeroBySubtractingEqualAmounts.Solution();

    @Test
    void should_return_0() {
        Assertions.assertEquals(0, solution.minimumOperations(new int[]{0}));
    }

    @Test
    void should_return_3() {
        Assertions.assertEquals(3, solution.minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }
}