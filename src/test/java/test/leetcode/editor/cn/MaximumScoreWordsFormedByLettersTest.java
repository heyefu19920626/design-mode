package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author he
 * @since 2023-02.26-22:44
 */
class MaximumScoreWordsFormedByLettersTest {
    MaximumScoreWordsFormedByLetters.Solution solution = new MaximumScoreWordsFormedByLetters.Solution();

    @Test
    void should_return_0() {
        Assertions.assertEquals(0, solution.maxScoreWords(new String[]{"leetcode"},new char[]{'l','e','t','c','o',
            'd'}, new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0}));
    }

    @Test
    void should_return_23() {
        Assertions.assertEquals(23, solution.maxScoreWords(new String[]{"dog","cat","dad","good"},
            new char[]{'a','a','c','d','d','d','g','o','o'}, new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}));
    }

    @Test
    void should_return_27() {
        Assertions.assertEquals(27, solution.maxScoreWords(new String[]{"xxxz","ax","bx","cx"},
            new char[]{'z','a','b','c','x','x','x'}, new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10}));
    }
}