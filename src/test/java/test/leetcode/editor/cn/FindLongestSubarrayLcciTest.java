package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindLongestSubarrayLcciTest {
    FindLongestSubarrayLcci.Solution solution = new FindLongestSubarrayLcci.Solution();

    @Test
    void should_return_x() {
        Assertions.assertArrayEquals(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7"},
            solution.findLongestSubarray(
                new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"}));
    }

    @Test
    void should_return_xx() {
        Assertions.assertArrayEquals(new String[]{}, solution.findLongestSubarray(new String[]{"A", "A"}));
    }
}