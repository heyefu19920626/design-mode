//给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质： 
//
// 
// items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
// 
// items 中每件物品的价值都是 唯一的 。 
// 
//
// 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 
//。 
//
// 注意：ret 应该按价值 升序 排序后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
//输出：[[1,6],[3,9],[4,5]]
//解释：
//value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 5 ，总重量为 1 + 5 = 6 。
//value = 3 的物品再 items1 中 weight = 8 ，在 items2 中 weight = 1 ，总重量为 8 + 1 = 9 。
//value = 4 的物品在 items1 中 weight = 5 ，总重量为 5 。
//所以，我们返回 [[1,6],[3,9],[4,5]] 。
// 
//
// 示例 2： 
//
// 
//输入：items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
//输出：[[1,4],[2,4],[3,4]]
//解释：
//value = 1 的物品在 items1 中 weight = 1 ，在 items2 中 weight = 3 ，总重量为 1 + 3 = 4 。
//value = 2 的物品在 items1 中 weight = 3 ，在 items2 中 weight = 1 ，总重量为 3 + 1 = 4 。
//value = 3 的物品在 items1 中 weight = 2 ，在 items2 中 weight = 2 ，总重量为 2 + 2 = 4 。
//所以，我们返回 [[1,4],[2,4],[3,4]] 。 
//
// 示例 3： 
//
// 
//输入：items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]
//输出：[[1,7],[2,4],[7,1]]
//解释：
//value = 1 的物品在 items1 中 weight = 3 ，在 items2 中 weight = 4 ，总重量为 3 + 4 = 7 。
//value = 2 的物品在 items1 中 weight = 2 ，在 items2 中 weight = 2 ，总重量为 2 + 2 = 4 。
//value = 7 的物品在 items2 中 weight = 1 ，总重量为 1 。
//所以，我们返回 [[1,7],[2,4],[7,1]] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= items1.length, items2.length <= 1000 
// items1[i].length == items2[i].length == 2 
// 1 <= valuei, weighti <= 1000 
// items1 中每个 valuei 都是 唯一的 。 
// items2 中每个 valuei 都是 唯一的 。 
// 
// Related Topics 数组 哈希表 有序集合 排序 👍 28 👎 0

package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSimilarItems {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. 分别对items1与items2排序，按照价值从低到高进行排序
         * 2. 使用优先级队列，合并两个数组
         * <p>
         * 1. 优先级队列使用时注意：1. 内存中的是没有排序的 2. 传统的list遍历方式不行，要使用pool或者peek弹出
         *
         * @param items1 入参1
         * @param items2 入参2
         * @return 合并后的结果
         */
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<int[]> item1Queue = new PriorityQueue<>(items1.length, Comparator.comparingInt(o -> o[0]));
            item1Queue.addAll(Arrays.asList(items1));
            Queue<int[]> item2Queue = new PriorityQueue<>(items2.length, Comparator.comparingInt(o -> o[0]));
            item2Queue.addAll(Arrays.asList(items2));
            while (!item1Queue.isEmpty() && !item2Queue.isEmpty()) {
                if (item1Queue.peek()[0] > item2Queue.peek()[0]) {
                    int[] poll = item2Queue.poll();
                    result.add(Arrays.asList(poll[0], poll[1]));
                } else if (item1Queue.peek()[0] < item2Queue.peek()[0]) {
                    int[] poll = item1Queue.poll();
                    result.add(Arrays.asList(poll[0], poll[1]));
                } else {
                    int[] item1 = item1Queue.poll();
                    int[] item2 = item2Queue.poll();
                    result.add(Arrays.asList(item1[0], item1[1] + item2[1]));
                }
            }
            while (!item1Queue.isEmpty()) {
                int[] item = item1Queue.poll();
                result.add(Arrays.asList(item[0], item[1]));
            }
            while (!item2Queue.isEmpty()) {
                int[] item = item2Queue.poll();
                result.add(Arrays.asList(item[0], item[1]));
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}