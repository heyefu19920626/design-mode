//给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。 
//
// 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。 
//
// 注意： 
//
// 
// 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
//
// 
// 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。 
// 
// 
// 子数组是数组中的一个连续部分。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,4,5], k = 4
//输出：3
//解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,1], k = 3
//输出：1
//解释：[3] 是唯一一个中位数等于 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i], k <= n 
// nums 中的整数互不相同 
// 
// Related Topics 数组 哈希表 前缀和 👍 79 👎 0

package test.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithMedianK {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 数组转换，前缀和，子数组遍历, 哈希表
         * <p>
         * 数组转换，大于k的转为1，小于k的转为0
         * <p>
         * 因为子数组必须包含k，且k为中位数，所以，子数组的右边界必须大于等于kIndex
         * 设转换后的前缀和sum，子数组的左边界为i，右边界为j，则i,j需要满足：
         * sum[j] - sum[i] = 0 或者sum[j]- sum[i] = 1
         * 所以，从左往右遍历，在kIndex之前，统计每个前缀和出现的次数，在kIndex之后，寻找满足以上的条件的i的个数，相加即可
         *
         * @param nums
         * @param k
         * @return
         */
        public int countSubarrays(int[] nums, int k) {
            int len = nums.length;
            int[] sums = new int[len];
            sums[0] = computeCurAdd(nums, k, 0);
            int kIndex = 0;
            for (int i = 1; i < len; i++) {
                // 数组转换，计算转换后的前缀和
                int cur = computeCurAdd(nums, k, i);
                sums[i] = sums[i - 1] + cur;
                if (cur == 0) {
                    kIndex = i;
                }
            }
            int res = 0;
            Map<Integer, Integer> sumNum = new HashMap<>();
            sumNum.put(0, 1);
            for (int i = 0; i < len; i++) {
                if (i < kIndex) {
                    sumNum.put(sums[i], sumNum.getOrDefault(sums[i], 0) + 1);
                } else {
                    res += sumNum.getOrDefault(sums[i], 0);
                    res += sumNum.getOrDefault(sums[i] - 1, 0);
                }
            }
            return res;
        }

        private int computeCurAdd(int[] nums, int k, int i) {
            if (nums[i] > k) {
                return 1;
            } else if (nums[i] < k) {
                return -1;
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}