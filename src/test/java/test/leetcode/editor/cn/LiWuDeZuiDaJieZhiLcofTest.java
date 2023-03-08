package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LiWuDeZuiDaJieZhiLcofTest {
    LiWuDeZuiDaJieZhiLcof.Solution solution = new LiWuDeZuiDaJieZhiLcof.Solution();

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.maxValue(new int[][]{{1}}));
    }

    @Test
    void should_return_6() {
        Assertions.assertEquals(6, solution.maxValue(new int[][]{{1, 2, 3}}));
    }

    @Test
    void should_return_7() {
        Assertions.assertEquals(7, solution.maxValue(new int[][]{{1}, {2}, {4}}));
    }

    @Test
    void should_return_12() {
        Assertions.assertEquals(12, solution.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    @Test
    void should_return_11() {
        Assertions.assertEquals(9, solution.maxValue(new int[][]{{1, 2, 1}, {1, 1, 1}, {4, 2, 1}}));
    }
}