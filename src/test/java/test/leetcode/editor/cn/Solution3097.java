package test.leetcode.editor.cn;
// 给你一个 非负 整数数组 nums 和一个整数 k 。
//
// 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。 
//
// 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3], k = 2 
// 
//
// 输出：1 
//
// 解释： 
//
// 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。 
//
// 示例 2： 
//
// 
// 输入：nums = [2,1,8], k = 10 
// 
//
// 输出：3 
//
// 解释： 
//
// 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,2], k = 0 
// 
//
// 输出：1 
//
// 解释： 
//
// 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 109 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 位运算 数组 滑动窗口 👍 30 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution3097 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(3, solution.minimumSubarrayLength(new int[]{1, 2, 65, 34, 32, 19, 76}, 100));
        Assertions.assertEquals(2, solution.minimumSubarrayLength(new int[]{1, 2, 11, 15, 13, 32}, 34));
        System.out.println(1);
        Assertions.assertEquals(2, solution.minimumSubarrayLength(new int[]{16, 1, 2, 20, 32}, 45));
        System.out.println(2);
        Assertions.assertEquals(-1, solution.minimumSubarrayLength(new int[]{2, 15, 32, 1}, 50));
        System.out.println(3);
        Assertions.assertEquals(1, solution.minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(4);
        Assertions.assertEquals(3, solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(5);
        Assertions.assertEquals(1, solution.minimumSubarrayLength(new int[]{1, 2}, 0));
        System.out.println(6);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 滑动窗口，十进制与二进制转换
         * <p>
         * 十进制x转二进制
         * <p>
         * x对2取余(与1)，可以确定x的末位是0还是1, 通过将x不断右移来获取最末位为0还是1
         * <p>
         * 滑动窗口
         * <p>
         * left，right从0开始，right不断右移，直到与的结果大于k，计算此时的答案res=right-left+1,
         * 此时将left右移，直到left与right之间的与结果刚好小于k
         * <p>
         * 使用一个数组来保存left指针与right指针之间（包含）中每一位1的出现次数，这样就能快速计算与的结果
         *
         * @param nums
         * @param k
         * @return
         */
        public int minimumSubarrayLength(int[] nums, int k) {
            int res = nums.length + 1;
            int left = 0, right = 0;
            int[] temp = new int[32];
            while (right < nums.length) {
                for (int i = 0; i < 32; i++) {
                    temp[i] += (nums[right] >> i) & 1;
                }
                while (compute(temp) >= k && left <= right) {
                    res = Math.min(res, right - left + 1);
                    for (int i = 0; i < 32; i++) {
                        temp[i] -= (nums[left] >> i) & 1;
                    }
                    left++;
                }
                right++;
            }
            return res <= nums.length ? res : -1;
        }

        private int compute(int[] two) {
            int sum = 0;
            for (int i = 0; i < two.length; i++) {
                if (two[i] > 0) {
                    sum += 1 << i;
                }
            }
            return sum;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

