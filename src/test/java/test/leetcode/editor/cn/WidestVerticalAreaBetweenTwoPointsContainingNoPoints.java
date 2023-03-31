//给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。 
//
// 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。 
//
// 请注意，垂直区域 边上 的点 不在 区域内。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[8,7],[9,9],[7,4],[9,7]]
//输出：1
//解释：红色区域和蓝色区域都是最优区域。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 2 <= n <= 10⁵ 
// points[i].length == 2 
// 0 <= xi, yi <= 10⁹ 
// 
// Related Topics 数组 排序 👍 33 👎 0

package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    WidestVerticalAreaBetweenTwoPointsContainingNoPoints.Solution solution = new Solution();

    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 先对x轴进行排序，然后遍历，找出相邻点的最宽长度
         *
         * @param points
         * @return
         */
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
            int res = 0;
            for (int i = 1; i < points.length; i++) {
                res = Math.max(res, points[i][0] - points[i - 1][0]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    @Test
    void should_return_1() {
        Assertions.assertEquals(1, solution.maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
    }

    @Test
    void should_return_3() {
        Assertions.assertEquals(3,
            solution.maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }
}