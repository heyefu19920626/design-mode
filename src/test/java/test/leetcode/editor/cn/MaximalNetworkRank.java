//n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有
//一条双向道路。 
//
// 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。 
//
// 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。 
//
// 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
//输出：4
//解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
//输出：5
//解释：共有 5 条道路与城市 1 或 2 相连。
// 
//
// 示例 3： 
//
// 
//输入：n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
//输出：5
//解释：2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 0 <= roads.length <= n * (n - 1) / 2 
// roads[i].length == 2 
// 0 <= ai, bi <= n-1 
// ai != bi 
// 每对城市之间 最多只有一条 道路相连 
// 
// Related Topics 图 👍 88 👎 0

package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class MaximalNetworkRank {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 统计从0到n-1每个节点的道路数, 结果应该为最大的几个值中的两个,如果最大的两个值中间有路，则减一
         *
         * @param n
         * @param roads
         * @return
         */
        public int maximalNetworkRank(int n, int[][] roads) {
            // 存储每个城市的路的数量
            int[] nums = new int[n];
            List<String> list = new ArrayList<>();
            for (int[] road : roads) {
                nums[road[0]]++;
                nums[road[1]]++;
                list.add(road[0] + "," + road[1]);
            }
            // 优先级队列，存储数组下标,即城市序号
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
            for (int i = 0; i < nums.length; i++) {
                queue.add(i);
            }
            Integer maxIndex = queue.poll();
            Integer secondIndex = queue.poll();
            // 如果两个城市不相邻，直接返回即可
            if (!list.contains(maxIndex + "," + secondIndex) && !list.contains(secondIndex + "," + maxIndex)) {
                return nums[maxIndex] + nums[secondIndex];
            }
            // 最大值大于第二大的值的时候：如果第二大的值不跟最大值相邻，则返回相加的值，如果相邻，要减去一
            if (nums[maxIndex] > nums[secondIndex]) {
                while (!queue.isEmpty() && nums[queue.peek()] == nums[secondIndex]) {
                    secondIndex = queue.poll();
                    if (!list.contains(maxIndex + "," + secondIndex) && !list.contains(secondIndex + "," + maxIndex)) {
                        return nums[maxIndex] + nums[secondIndex];
                    }
                }
                return nums[maxIndex] + nums[secondIndex] - 1;
            }
            // 最大值与第二大值相等
            List<Integer> numsEqual = new ArrayList<>();
            numsEqual.add(maxIndex);
            numsEqual.add(secondIndex);
            // 把所有相等的最大值拿出来
            while (!queue.isEmpty() && nums[queue.peek()] == nums[secondIndex]) {
                numsEqual.add(queue.poll());
            }
            for (int i = 0; i < numsEqual.size(); i++) {
                Integer a = numsEqual.get(i);
                for (int j = i + 1; j < numsEqual.size(); j++) {
                    Integer b = numsEqual.get(j);
                    // 如果两个节点不相邻，返回该最大值
                    if (!list.contains(a + "," + b) && !list.contains(b + "," + a)) {
                        return nums[a] + nums[b];
                    }
                }
            }
            return nums[maxIndex] + nums[secondIndex] - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}