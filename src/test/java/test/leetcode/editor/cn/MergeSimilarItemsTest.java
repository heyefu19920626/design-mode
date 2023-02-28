package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSimilarItemsTest {
    MergeSimilarItems.Solution solution = new MergeSimilarItems.Solution();

    @Test
    void should_return_xx() {
        Assertions.assertEquals("[[1, 6], [3, 9], [4, 5]]",
            solution.mergeSimilarItems(new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}}).toString());
    }

    @Test
    void should_return_xxx() {
        Assertions.assertEquals("[[1, 4], [2, 4], [3, 4]]",
            solution.mergeSimilarItems(new int[][]{{1, 1}, {3, 2}, {2, 3}}, new int[][]{{2, 1}, {3, 2}, {1, 3}})
                .toString());
    }

    @Test
    void should_return_xxxx() {
        Assertions.assertEquals("[[1, 7], [2, 4], [7, 1]]",
            solution.mergeSimilarItems(new int[][]{{1, 3}, {2, 2}}, new int[][]{{7, 1}, {2, 2}, {1, 4}}).toString());
    }

    @Test
    void should_return_xxxxx() {
        Assertions.assertEquals(
            "[[2, 10], [3, 6], [8, 6], [11, 3], [12, 8], [15, 10], [18, 4], [21, 10], [22, 4], [27, 5], [28, 2], [29, 10]]",
            solution.mergeSimilarItems(
                new int[][]{{12, 8}, {22, 4}, {27, 5}, {18, 4}, {3, 6}, {29, 10}, {28, 2}, {2, 10}},
                new int[][]{{15, 10}, {8, 6}, {21, 10}, {11, 3}}).toString());
    }
}