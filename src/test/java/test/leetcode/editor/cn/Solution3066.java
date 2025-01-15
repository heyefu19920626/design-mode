package test.leetcode.editor.cn;
// 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
//
// 一次操作中，你将执行： 
//
// 
// 选择 nums 中最小的两个整数 x 和 y 。 
// 将 x 和 y 从 nums 中删除。 
// 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。 
// 
//
// 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。 
//
// 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,11,10,1,3], k = 10
// 输出：2
// 解释：第一次操作中，我们删除元素 1 和 2 ，然后添加 1 * 2 + 2 到 nums 中，nums 变为 [4, 11, 10, 3] 。
// 第二次操作中，我们删除元素 3 和 4 ，然后添加 3 * 2 + 4 到 nums 中，nums 变为 [10, 11, 10] 。
// 此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
// 使数组中所有元素都大于等于 10 需要的最少操作次数为 2 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,1,2,4,9], k = 20
// 输出：4
// 解释：第一次操作后，nums 变为 [2, 4, 9, 3] 。
// 第二次操作后，nums 变为 [7, 4, 9] 。
// 第三次操作后，nums 变为 [15, 9] 。
// 第四次操作后，nums 变为 [33] 。
// 此时，数组中的所有元素都大于等于 20 ，所以我们停止操作。
// 使数组中所有元素都大于等于 20 需要的最少操作次数为 4 。
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 输入保证答案一定存在，也就是说一定存在一个操作序列使数组中所有元素都大于等于 k 。 
// 
//
// Related Topics 数组 模拟 堆（优先队列） 👍 10 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution3066 {
    Solution solution = new Solution();

    @Test
    public void test() {
        // System.out.println(Integer.MAX_VALUE);
        Assertions.assertEquals(2, solution.minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        Assertions.assertEquals(4, solution.minOperations(new int[]{1, 1, 2, 4, 9}, 20));
        Assertions.assertEquals(7, solution.minOperations(new int[]{61, 81, 12, 29, 3, 96, 96, 28, 38, 71}, 97));
        Assertions.assertEquals(2, solution.minOperations(
            new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999}, 1000000000));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 先对nums进行排序
         * 1、然后从小到大遍历nums, 取出最小的两个数x,y，计算新的数
         * 2、如果该数大于等于k，丢弃，否则，将其存入新的列表temp的最后(因为按照从小到大的顺序，所有新的2*x+y必定大于旧的)
         * 3、继续遍历，如果temp不为空，判断nums与temp谁更小，x,y就取谁
         * 4、新的结果继续执行步骤2
         *
         * @param nums
         * @param k
         * @return
         */
        public int minOperations(int[] nums, int k) {
            PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o));
            for (int num : nums) {
                queue.add((long) num);
            }
            int res = 0;
            while (queue.peek() < k) {
                queue.add(2 * queue.poll() + queue.poll());
                res++;
            }
            // return useQueue(nums, k);
            return res;
        }

        private int useQueue(int[] nums, int k) {
            int res = 0;
            Arrays.sort(nums);
            if (nums[0] >= k) {
                return res;
            }
            long x = nums[0], y = nums[1];
            List<Long> temp = new ArrayList<>();
            temp.addLast((long) (2 * x + y));
            res++;
            int i = 2;
            while (temp.getFirst() < k || (i < nums.length && nums[i] < k)) {
                if (i < nums.length && nums[i] < temp.getFirst()) {
                    x = nums[i++];
                } else {
                    x = temp.removeFirst();
                }
                if (temp.isEmpty() || (i < nums.length && nums[i] < temp.getFirst())) {
                    y = nums[i++];
                } else {
                    y = temp.removeFirst();
                }
                long figure = 2 * x + y;
                res++;
                temp.addLast(figure);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

