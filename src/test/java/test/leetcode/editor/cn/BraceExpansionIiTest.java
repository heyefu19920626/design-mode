package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author he
 * @since 2023-03.07-21:55
 */
class BraceExpansionIiTest {
    BraceExpansionIi.Solution solution = new BraceExpansionIi.Solution();

    @Test
    void should_return_xx() {
        Assertions.assertEquals(Arrays.asList("ac", "ad", "ae", "bc", "bd", "be"),
            solution.braceExpansionII("{a,b}{c,{d,e}}"));
    }

    @Test
    void should_return_xxx() {
        Assertions.assertEquals(Arrays.asList("a", "ab", "ac", "z"),
            solution.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }
}