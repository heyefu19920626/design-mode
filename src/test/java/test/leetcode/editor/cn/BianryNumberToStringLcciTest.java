package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BianryNumberToStringLcciTest {
    BianryNumberToStringLcci.Solution solution = new BianryNumberToStringLcci.Solution();

    @Test
    void should_return_string() {
        Assertions.assertEquals("0.101", solution.printBin(0.625));
    }

    @Test
    void should_return_error() {
        Assertions.assertEquals("ERROR", solution.printBin(0.1));
    }
}