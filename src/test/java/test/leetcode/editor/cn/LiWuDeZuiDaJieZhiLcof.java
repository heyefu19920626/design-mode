//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 👍 421 👎 0

package test.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LiWuDeZuiDaJieZhiLcof {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用动态规划
         * <p>
         * f(m,n) = grid[m][n] + max(f(m-1,n), f(m, n-1))
         * <p>
         * f(1,0) = grid[1][0] + f(0,0)
         * f(0,0) = grid[0][0]
         *
         * @param grid
         * @return
         */
        public int maxValue(int[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int up = temp[0][j];
                    if (i > 0) {
                        up = temp[i - 1][j];
                    }
                    int left = temp[i][0];
                    if (j > 0) {
                        left = temp[i][j - 1];
                    }
                    temp[i][j] = grid[i][j] + Math.max(up, left);
                }
            }
            return temp[m - 1][n - 1];
            // Map<String, Integer> map = new HashMap<>();
            // return maxValue(grid, grid.length - 1, grid[0].length - 1, map);
        }

        private int maxValue(int[][] grid, int m, int n, Map<String, Integer> map) {
            if (m < 0 || n < 0) {
                return 0;
            }
            String key = m + "," + n;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            int res = grid[m][n] + Math.max(maxValue(grid, m - 1, n, map), maxValue(grid, m, n - 1, map));
            map.put(key, res);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}