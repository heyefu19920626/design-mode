//你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。 
//
// 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没
//有穿过一块砖的。 
//
// 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的
//砖块数量最少 ，并且返回 穿过的砖块数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：wall = [[1],[1],[1]]
//输出：3
// 
// 
//
// 提示： 
//
// 
// n == wall.length 
// 1 <= n <= 10⁴ 
// 1 <= wall[i].length <= 10⁴ 
// 1 <= sum(wall[i].length) <= 2 * 10⁴ 
// 对于每一行 i ，sum(wall[i]) 是相同的 
// 1 <= wall[i][j] <= 2³¹ - 1 
// 
// Related Topics 数组 哈希表 👍 307 👎 0

package test.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 首先计算每一行的前缀和,获得新多维数组
         * <p>
         * 假设多维数组长度为height
         * 在新的多维数组中寻找除了总宽度，出现最多次的数字次数x, 如果没有，则结果为多维数组的长度height，否则，结果为height-x
         *
         * @param wall
         * @return
         */
        public int leastBricks(List<List<Integer>> wall) {
            int height = wall.size();
            for (List<Integer> line : wall) {
                for (int i = 0; i < line.size(); i++) {
                    if (i > 0) {
                        line.set(i, line.get(i - 1) + line.get(i));
                    }
                }
            }
            int width = wall.get(0).get(wall.get(0).size() - 1);
            Map<Integer, Integer> nums = new HashMap<>();
            for (List<Integer> line : wall) {
                for (Integer cur : line) {
                    if (nums.containsKey(cur)) {
                        nums.put(cur, nums.get(cur) + 1);
                    } else {
                        nums.put(cur, 1);
                    }
                }
            }
            nums.remove(width);
            return nums.values().stream().max(Comparator.comparingInt(o -> o)).map(integer -> height - integer)
                .orElse(height);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}