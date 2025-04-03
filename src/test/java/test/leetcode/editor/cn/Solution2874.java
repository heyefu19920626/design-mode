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
// 3 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 👍 44 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2874 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(14, solution.maximumTripletValue(new int[]{10, 13, 6, 2}));
        Assertions.assertEquals(0, solution.maximumTripletValue(new int[]{2, 3, 1}));
        Assertions.assertEquals(266,
                                solution.maximumTripletValue(new int[]{8, 6, 3, 13, 2, 12, 19, 5, 19, 6, 10, 11, 9}));
        Assertions.assertEquals(77, solution.maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        Assertions.assertEquals(133, solution.maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        Assertions.assertEquals(0, solution.maximumTripletValue(new int[]{1, 2, 3}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心+前后缀
         * <p>
         * 要使(nums[i] - nums[j]) * nums[k]值最大, 假设j固定，则需要找出j左侧的最大值与右侧的最大值
         * <p>
         * 因此，可以使用两次遍历，先从左往右，遍历出左侧的最大值使用left存储数组存储,
         * 再从右往左，遍历出右侧的最大值，使用rightMax数组存储,
         * 最后，(nums[i] - nums[j]) * nums[k]计算即可
         *
         * @param nums
         * @return
         */
        public long maximumTripletValue(int[] nums) {
            long res = 0;
            int[] leftMax = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                // 判断i左侧最大值, 不能包含当前位置
                leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            }
            int[] rightMax = new int[nums.length];
            for (int i = nums.length - 2; i >= 0; i--) {
                // 判断i右侧最大值, 不能包含当前位置
                rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
            }
            for (int i = 1; i < nums.length - 1; i++) {
                res = Math.max(res, (long) (leftMax[i] - nums[i]) * rightMax[i]);
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

