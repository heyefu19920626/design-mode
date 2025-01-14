package test.leetcode.editor.cn;
// 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
//
// 
// 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。 
// 同样，对 nums = [7] 而言，按位与等于 7 。 
// 
//
// 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。 
//
// 返回按位与结果大于 0 的 最长 组合的长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入：candidates = [16,17,71,62,12,24,14]
// 输出：4
// 解释：组合 [16,17,62,24] 的按位与结果是 16 & 17 & 62 & 24 = 16 > 0 。
// 组合长度是 4 。
// 可以证明不存在按位与结果大于 0 且长度大于 4 的组合。
// 注意，符合长度最大的组合可能不止一种。
// 例如，组合 [62,12,24,14] 的按位与结果是 62 & 12 & 24 & 14 = 8 > 0 。
// 
//
// 示例 2： 
//
// 
// 输入：candidates = [8,8]
// 输出：2
// 解释：最长组合是 [8,8] ，按位与结果 8 & 8 = 8 > 0 。
// 组合长度是 2 ，所以返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 10⁵ 
// 1 <= candidates[i] <= 10⁷ 
// 
//
// Related Topics 位运算 数组 哈希表 计数 👍 78 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution2275 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(4, solution.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
        Assertions.assertEquals(2, solution.largestCombination(new int[]{8, 8}));
        Assertions.assertEquals(1, solution.largestCombination(new int[]{7}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 解法一：暴力
         * 从长到短，遍历candidates的子字符串
         * <p>
         * 解法二：
         * 12 14 16 17 24 62 71
         * 71：1000111
         * 62： 111110
         * 24：  11000
         * 17：  10001
         * 16：  10000
         * 14：   1110
         * 12：   1100
         * 遍历candidates，计算candidates[i]的二进制，int最大为32位，设置res[32]来保存每一位出现过1的次数
         * 最后取res[32]中的最大值
         *
         * @param candidates
         * @return
         */
        public int largestCombination(int[] candidates) {
            int[] res = new int[32];
            for (int i = 0; i < candidates.length; i++) {
                int cur = candidates[i];
                int index = 0;
                while (cur > 0) {
                    if (cur % 2 != 0) {
                        res[index]++;
                    }
                    cur = cur >> 1;
                    index++;
                }
            }
            int result = 0;
            for (int re : res) {
                result = Math.max(re, result);
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

