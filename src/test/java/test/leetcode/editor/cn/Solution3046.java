package test.leetcode.editor.cn;
// 给你一个长度为 偶数 的整数数组 nums 。你需要将这个数组分割成 nums1 和 nums2 两部分，要求：
//
// 
// nums1.length == nums2.length == nums.length / 2 。 
// nums1 应包含 互不相同 的元素。 
// nums2也应包含 互不相同 的元素。 
// 
//
// 如果能够分割数组就返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,2,2,3,4]
// 输出：true
// 解释：分割 nums 的可行方案之一是 nums1 = [1,2,3] 和 nums2 = [1,2,4] 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,1,1,1]
// 输出：false
// 解释：分割 nums 的唯一可行方案是 nums1 = [1,1] 和 nums2 = [1,1] 。但 nums1 和 nums2 都不是由互不相同的元素
// 构成。因此，返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// nums.length % 2 == 0 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 哈希表 计数 👍 16 👎 0

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution3046 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertTrue(solution.isPossibleToSplit(new int[]{1, 1, 2, 2, 3, 4}));
        Assertions.assertFalse(solution.isPossibleToSplit(new int[]{1, 1, 1, 1}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1、如果nums的长度为奇数，肯定不行(排除)
         * 2、先对nums进行排序
         * 3、准备两个列表a，b，将nums依次放入两个列表中的最短的一个，如果要将nums[i]放入a
         * 1、判断a，b中最短的，假如为a，判断nums[i],是否等于a的最后一位
         * 2、如果等于，继续判断b，如果都等于，直接返回false
         * 3、否则，等到全部放完，看a，b长度是否相等
         *
         * @param nums
         * @return
         */
        public boolean isPossibleToSplit(int[] nums) {
            Arrays.sort(nums);
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            a.add(nums[0]);
            b.add(nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int cur = nums[i];
                if (a.size() <= b.size()) {
                    if (isLegal(a, b, cur)) {
                        return false;
                    }
                } else {
                    if (isLegal(b, a, cur)) {
                        return false;
                    }
                }
            }
            return a.size() == b.size();
        }

        private boolean isLegal(List<Integer> first, List<Integer> two, int value) {
            if (first.getLast() != value) {
                first.add(value);
                return false;
            } else if (two.getLast() != value) {
                two.add(value);
                return false;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}

