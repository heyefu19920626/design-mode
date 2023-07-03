//给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。 
//
// 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。 
//
// 子数组 定义为原数组中连续的一组元素。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,4,2], p = 6
//输出：1
//解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [6,3,5,2], p = 9
//输出：2
//解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3], p = 3
//输出：0
//解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3], p = 7
//输出：-1
//解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
// 
//
// 示例 5： 
//
// 输入：nums = [1000000000,1000000000,1000000000], p = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= p <= 10⁹ 
// 
// Related Topics 数组 哈希表 前缀和 👍 114 👎 0

package test.leetcode.editor.cn;

public class MakeSumDivisibleByP {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 统计nums的和total与其子集的和
         * 1. total能被p整除，返回0
         * 2. 如果有子集能被p整除，记录p的长度
         * 3. 取第二步中最短的长度
         * <p>
         * 求所有子集的和,可以使用前缀和与后缀和优化效率
         *
         * @param nums
         * @param p
         * @return
         */
        public int minSubarray(int[] nums, int p) {
            int res = nums.length;
            long[] preSum = new long[res];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = nums[i] + preSum[i - 1];
            }
            long[] sufSum = new long[res];
            sufSum[res - 1] = nums[res - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                sufSum[i] = nums[i] + sufSum[i + 1];
            }
            if (sufSum[0] % p == 0) {
                return 0;
            }
            for (int i = 0; i < nums.length; i++) {
                long left = i == 0 ? 0 : preSum[i - 1];
                for (int j = i; j < nums.length; j++) {
                    long right = j == nums.length - 1 ? 0 : sufSum[j + 1];
                    if ((left + right) % p == 0) {
                        res = Math.min(res, j + 1 - i);
                    }
                }
            }
            return res == nums.length ? -1 : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}