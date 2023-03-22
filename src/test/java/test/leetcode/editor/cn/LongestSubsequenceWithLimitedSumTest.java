package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubsequenceWithLimitedSumTest {
    LongestSubsequenceWithLimitedSum.Solution solution = new LongestSubsequenceWithLimitedSum.Solution();

    @Test
    void should_return_x() {
        Assertions.assertArrayEquals(new int[]{2, 3, 4},
            solution.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}));
    }

    @Test
    void should_return_xx() {
        Assertions.assertArrayEquals(new int[]{0},
            solution.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1}));
    }
}