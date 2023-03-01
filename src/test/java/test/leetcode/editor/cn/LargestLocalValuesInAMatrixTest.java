package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LargestLocalValuesInAMatrixTest {
    LargestLocalValuesInAMatrix.Solution solution = new LargestLocalValuesInAMatrix.Solution();

    @Test
    void should_return_9986() {
        Assertions.assertEquals("[[9,9],[8,6]]",
            Arrays.deepToString(solution.largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2,
                2}})).replace(" ", ""));
    }

    @Test
    void should_return_222222() {
        Assertions.assertEquals("[[2,2,2],[2,2,2],[2,2,2]]", Arrays.deepToString(solution.largestLocal(
                new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}))
            .replace(" ", ""));
    }

    @Test
    void should_return_2() {
        Assertions.assertEquals("[[2]]", Arrays.deepToString(solution.largestLocal(
                new int[][]{{1, 1, 2}, {1, 1, 1}, {1, 1, 2}}))
            .replace(" ", ""));
    }
}