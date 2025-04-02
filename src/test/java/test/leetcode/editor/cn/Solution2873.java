package test.leetcode.editor.cn;
// 给你一个下标从 0 开始的整数数组 nums 。
//
// 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 
//。 
//
// 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [12,6,1,2,7]
// 输出：77
// 解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
// 可以证明不存在值大于 77 的有序下标三元组。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,10,3,4,19]
// 输出：133
// 解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。
// 可以证明不存在值大于 133 的有序下标三元组。
// 
//
// 示例 3： 
//
// 
// 输入：nums = [1,2,3]
// 输出：0
// 解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 👍 32 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2873 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(266,
                                solution.maximumTripletValue(new int[]{8, 6, 3, 13, 2, 12, 19, 5, 19, 6, 10, 11, 9}));
        Assertions.assertEquals(77, solution.maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        Assertions.assertEquals(133, solution.maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        Assertions.assertEquals(0, solution.maximumTripletValue(new int[]{1, 2, 3}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力或者贪心
         *
         * @param nums
         * @return
         */
        public long maximumTripletValue(int[] nums) {
            long res = 0;
            // 固定k的情况下，当nums[i]-nums[j]为最大值时，结果最大
            // 因此，要使用lmaxi保存i的最大值，因为j比i大，遍历k的同时，计算lmaxi-nums[k]即为nums[i]-nums[j]的最大值
            long lmaxi = 0, maxij = 0;
            for (int k = 0; k < nums.length; k++) {
                res = Math.max(res, maxij * nums[k]);
                lmaxi = Math.max(lmaxi, nums[k]);
                maxij = Math.max(maxij, lmaxi - nums[k]);
            }
            return res;
            // return violence(nums);
        }

        private long violence(int[] nums) {
            long res = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    long temp = nums[i] - nums[j];
                    for (int k = j + 1; k < nums.length; k++) {
                        res = Math.max(res, temp * nums[k]);
                    }
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

