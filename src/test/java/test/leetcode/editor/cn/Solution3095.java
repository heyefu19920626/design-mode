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
// 注意，[2] 也是一个特别子数组。 
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
// 1 <= nums.length <= 50 
// 0 <= nums[i] <= 50 
// 0 <= k < 64 
// 
//
// Related Topics 位运算 数组 滑动窗口 👍 15 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution3095 {
    Solution solution = new Solution();

    @Test
    public void test1() {
        System.out.println(1 | 2);
        System.out.println(3);
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, solution.minimumSubarrayLength(new int[]{1, 2, 11, 15, 13, 32}, 34));
        Assertions.assertEquals(2, solution.minimumSubarrayLength(new int[]{16, 1, 2, 20, 32}, 45));
        Assertions.assertEquals(-1, solution.minimumSubarrayLength(new int[]{2, 15, 32, 1}, 50));
        Assertions.assertEquals(1, solution.minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        Assertions.assertEquals(3, solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        Assertions.assertEquals(1, solution.minimumSubarrayLength(new int[]{1, 2}, 0));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 异或与或不能为反操作
         * <p>
         * 2, 15, 32, 1
         * 100000
         * 1111
         * 10
         * 1
         * 要求按位或的值不小于k，则参与按位或的数字相加，需要不小于k
         * <p>
         * 滑动窗口,暴力
         * 从左到右遍历nums，左右指针都从0开始，右指针向右移动，直到左右指针之间的数字之后，大于等于k，
         * 记录此时和为sum，最小数组长度为right-left+1, 再次右移左指针，sum-=左指针的值，
         * 如果此时sum仍然大于等于k，更新最小数组长度，直到sum小于k，再次移动右指针，
         * 如果没有右指针直到遍历完成，sum仍然小于k，则返回-1
         *
         * @param nums
         * @param k
         * @return
         */
        public int minimumSubarrayLength(int[] nums, int k) {
            int res = nums.length + 1, left = 0, right = 0, sum = nums[0];
            while (left <= right && right < nums.length) {
                if (sum >= k) {
                    res = Math.min(right - left + 1, res);
                    sum ^= nums[left];
                    left++;
                } else {
                    if (right < nums.length - 1) {
                        right++;
                        sum |= nums[right];
                    } else {
                        left++;
                        if (left < nums.length) {
                            sum ^= nums[left];
                        }
                    }
                }
            }
            return res <= nums.length ? res : -1;
            // return enumerate(nums, k);
        }

        private int enumerate(int[] nums, int k) {
            int res = Integer.MAX_VALUE, sum;
            for (int i = 0; i < nums.length; i++) {
                sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum |= nums[j];
                    if (sum >= k) {
                        res = Math.min(j - i + 1, res);
                        break;
                    }
                }
            }
            if (res <= nums.length) {
                return res;
            }
            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

