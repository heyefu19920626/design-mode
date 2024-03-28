package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/description">统计将重叠区间合并成组的方案数</a>
 *
 * @since 2024/3/27
 **/
public class Solution2580Test {
    @Test
    void should_return_4() {
        Assertions.assertEquals(4, countWays(new int[][] {{1, 3}, {10, 20}, {2, 5}, {4, 8}}));
    }

    @Test
    void should_return_2() {
        Assertions.assertEquals(2, countWays(new int[][] {{6, 10}, {5, 15}}));
    }

    @Test
    void should_return_16() {
        Assertions.assertEquals(16, countWays(new int[][] {{0, 0}, {8, 9}, {12, 13}, {1, 3}}));
    }

    @Test
    void should_return_2_2() {
        Assertions.assertEquals(2,
            countWays(new int[][] {{34, 56}, {28, 29}, {12, 16}, {11, 48}, {28, 54}, {22, 55}, {28, 41}, {41, 44}}));
    }

    @Test
    void should_return_32768() {
        Assertions.assertEquals(32768, countWays(new int[][] {
            {1, 15}, {20, 34}, {36, 44}, {52, 55}, {75, 83}, {87, 99}, {110, 117}, {120, 125}, {148, 148}, {155, 157},
            {181, 186}, {187, 189}, {210, 213}, {230, 232}, {240, 254}, {13, 15}
        }));
    }

    /**
     * 规定了相交的区间必须在相同的组中，因此，可以先将区间相交的组进行合并，假设合并后有n个区间
     * <p>
     * 因为对于第一个区间而言，既可以加入第一个组，也可以加入第二个组, 有两种放置方式
     * <p>
     * 对于第二个、第三个区间也是一样，因此结果为2^n
     *
     * @param ranges 给出的数组
     * @return 结果
     */
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        List<int[]> datas = new ArrayList<>();
        datas.add(ranges[0]);
        long res = 2;
        long remainder = 1000000007L;
        for (int i = 1; i < ranges.length; i++) {
            int[] range = ranges[i];
            int[] last = datas.getLast();
            // 需要合并
            if (range[0] <= last[1]) {
                last[1] = Math.max(range[1], last[1]);
            } else {
                datas.add(range);
                res *= 2;
                if (res >= remainder) {
                    res = res % remainder;
                }
            }
        }
        return (int) res;
    }
}