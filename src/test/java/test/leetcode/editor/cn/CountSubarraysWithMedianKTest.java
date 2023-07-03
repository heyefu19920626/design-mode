package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CountSubarraysWithMedianKTest {
    CountSubarraysWithMedianK.Solution solution = new CountSubarraysWithMedianK.Solution();

    @Test
    void should_return_3() {
        Assertions.assertEquals(3, solution.countSubarrays(new int[]{3, 2, 1, 4, 5}, 4));
    }

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.countSubarrays(new int[]{2, 3, 1}, 3));
    }

    @Test
    void should_return_1_() {
        Assertions.assertEquals(1, solution.countSubarrays(new int[]{1}, 1));
    }
}