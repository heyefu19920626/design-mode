//给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。 
//
// 如果符合下列情况之一，则数组 A 就是 锯齿数组： 
//
// 
// 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ... 
// 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ... 
// 
//
// 返回将数组 nums 转换为锯齿数组所需的最小操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3]
//输出：2
//解释：我们可以把 2 递减到 0，或把 3 递减到 1。
// 
//
// 示例 2： 
//
// 输入：nums = [9,6,1,6,2]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 👍 73 👎 0

package test.leetcode.editor.cn;

public class DecreaseElementsToMakeArrayZigzag {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 可以分为两种情况：
         * 1.偶数序列都比奇数序列大，这时候只需要减小奇数序列就行
         *
         * @param nums
         * @return
         */
        public int movesToMakeZigzag(int[] nums) {
            int even = computeTimes(nums, 0);
            int odd = computeTimes(nums, 1);
            return Math.min(even, odd);
        }

        private int computeTimes(int[] nums, int start) {
            int result = 0;
            // i就是需要减小的数
            for (int i = start; i < nums.length; i += 2) {
                int left = 0;
                if (i > 0 && nums[i] >= nums[i - 1]) {
                    left = nums[i] + 1 - nums[i - 1];
                }
                int right = 0;
                if (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                    right = nums[i] + 1 - nums[i + 1];
                }
                result += Math.max(left, right);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}