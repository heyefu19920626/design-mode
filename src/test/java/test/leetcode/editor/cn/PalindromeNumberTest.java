package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeNumberTest {
    PalindromeNumber.Solution solution = new PalindromeNumber.Solution();

    @Test
    void should_return_true_when_input_one() {
        Assertions.assertTrue(solution.isPalindrome(1));
    }

    @Test
    void should_return_true_when_input_three() {
        Assertions.assertTrue(solution.isPalindrome(121));
    }

    @Test
    void should_return_true_when_input_four() {
        Assertions.assertTrue(solution.isPalindrome(1221));
    }

    @Test
    void should_return_false_when_input_four() {
        Assertions.assertFalse(solution.isPalindrome(1211));
    }

    @Test
    void should_return_false_when_input_three() {
        Assertions.assertFalse(solution.isPalindrome(123));
    }
}