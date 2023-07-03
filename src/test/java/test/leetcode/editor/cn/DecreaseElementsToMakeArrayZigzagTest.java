package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecreaseElementsToMakeArrayZigzagTest {
    DecreaseElementsToMakeArrayZigzag.Solution solution = new DecreaseElementsToMakeArrayZigzag.Solution();

    @Test
    void should_return_2() {
        Assertions.assertEquals(2, solution.movesToMakeZigzag(new int[]{1, 2, 3}));
    }

    @Test
    void should_return_4() {
        Assertions.assertEquals(4, solution.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    @Test
    void should_return_0_when_one() {
        Assertions.assertEquals(0, solution.movesToMakeZigzag(new int[]{9}));
    }

    @Test
    void should_return_0_when_two() {
        Assertions.assertEquals(0, solution.movesToMakeZigzag(new int[]{9, 8}));
    }

    @Test
    void should_return_0_when_have_equal() {
        Assertions.assertEquals(13, solution.movesToMakeZigzag(new int[]{10, 4, 4, 10, 10, 6, 2, 3}));
    }
}