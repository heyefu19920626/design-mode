//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
//两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
//length 。 
//
// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
//
// 你所设计的解决方案必须只使用常量级的额外空间。 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
//
// Related Topics 数组 双指针 二分查找 👍 1061 👎 0

package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumIiInputArrayIsSorted {
    Solution solution = new Solution();

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 从左往右遍历数组，设当前位的值为x，若target-x不等于x并且target-x在numbers中，获取target-x的下标加1即可
         * <p>
         * 1. 暴力解法(二分法可以优化)
         * 2. 双指针
         *
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum(int[] numbers, int target) {
            // return doublePointer(numbers, target);
            return force(numbers, target);
        }

        private int[] doublePointer(int[] numbers, int target) {
            int start = 0;
            int end = numbers.length - 1;
            while (start < end) {
                int cur = numbers[start] + numbers[end];
                if (cur < target) {
                    start++;
                } else if (cur > target) {
                    end--;
                } else {
                    break;
                }
            }
            return new int[]{start + 1, end + 1};
        }

        private int[] force(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int need = target - numbers[i];
                int left = i + 1;
                int right = numbers.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (numbers[mid] == need) {
                        return new int[]{i + 1, mid + 1};
                    } else if (numbers[mid] > need) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return new int[]{0, 0};
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    @Test
    void should_return_1_2() {
        Assertions.assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void should_return_1_3() {
        Assertions.assertArrayEquals(new int[]{1, 3}, solution.twoSum(new int[]{2, 3, 4}, 6));
    }

    @Test
    void should_return_1_2_when_input_1() {
        Assertions.assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{-1, 0}, -1));
    }

    @Test
    void should_return_1_2_when_input_0() {
        Assertions.assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{0, 0, 3, 4}, 0));
    }
}