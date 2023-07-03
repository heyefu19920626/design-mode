package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author he
 * @since 2023-03.18-10:42
 */
class SplitTwoStringsToMakePalindromeTest {
    SplitTwoStringsToMakePalindrome.Solution solution = new SplitTwoStringsToMakePalindrome.Solution();

    @Test
    void should_return_true() {
        Assertions.assertTrue(solution.checkPalindromeFormation("x", "y"));
    }

    @Test
    void should_return_true_1() {
        Assertions.assertTrue(solution.checkPalindromeFormation("fecab", "abdef"));
    }

    @Test
    void should_return_true_2() {
        Assertions.assertTrue(solution.checkPalindromeFormation("ulacfd", "jizalu"));
    }

    @Test
    void should_return_true_3() {
        Assertions.assertTrue(solution.checkPalindromeFormation(
            "pvhmupgqeltozftlmfjjde",
            "yjgpzbezspnnpszebzmhvp"));
    }

    @Test
    void should_return_false() {
        Assertions.assertFalse(solution.checkPalindromeFormation("ulbcfd", "jizalu"));
    }

    @Test
    void should_return_false_1() {
        Assertions.assertFalse(solution.checkPalindromeFormation("abda", "acmc"));
    }
}