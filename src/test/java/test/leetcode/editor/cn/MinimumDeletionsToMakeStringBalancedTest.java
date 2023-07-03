package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author he
 * @since 2023-03.06-22:07
 */
class MinimumDeletionsToMakeStringBalancedTest {
    MinimumDeletionsToMakeStringBalanced.Solution solution = new MinimumDeletionsToMakeStringBalanced.Solution();

    @Test
    void should_return_2() {
        Assertions.assertEquals(2, solution.minimumDeletions("aababbab"));
    }

    @Test
    void should_return_2_() {
        Assertions.assertEquals(2, solution.minimumDeletions("bbaaaaabb"));
    }

    @Test
    void should_return_0_() {
        Assertions.assertEquals(0, solution.minimumDeletions("aaaaabb"));
    }
}