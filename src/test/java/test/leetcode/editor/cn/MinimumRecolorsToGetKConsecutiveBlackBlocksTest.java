package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MinimumRecolorsToGetKConsecutiveBlackBlocksTest {
    MinimumRecolorsToGetKConsecutiveBlackBlocks.Solution solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks.Solution();


    @Test
    void should_return_3() {
        Assertions.assertEquals(3, solution.minimumRecolors("WBBWWBBWBW", 7));
    }

    @Test
    void should_return_0() {
        Assertions.assertEquals(0, solution.minimumRecolors("WBBWWBBWBW", 2));
    }

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.minimumRecolors("W", 1));
    }

    @Test
    void should_return_6() {
        Assertions.assertEquals(6, solution.minimumRecolors("WWBBBWBBBBBWWBWWWB", 16));
    }
}