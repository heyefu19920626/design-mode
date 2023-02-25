package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BrickWallTest {
    BrickWall.Solution solution = new BrickWall.Solution();

    @Test
    void should_return_3() {
        Assertions.assertEquals(3, solution.leastBricks(convert(new int[][]{{1}, {1}, {1}})));
    }

    @Test
    void should_return_2() {
        Assertions.assertEquals(2,
            solution.leastBricks(convert(new int[][]{{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}
                , {1, 3, 1, 1}})));
    }

    List<List<Integer>> convert(int[][] array) {
        List<List<Integer>> input = new ArrayList<>();
        for (int[] ints : array) {
            List<Integer> cur = new ArrayList<>();
            for (int anInt : ints) {
                cur.add(anInt);
            }
            input.add(cur);
        }
        return input;
    }
}