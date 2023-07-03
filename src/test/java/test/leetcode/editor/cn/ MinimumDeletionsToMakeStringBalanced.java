package test.leetcode.editor.cn;

/**
 * //给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。
 * //
 * // 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a'
 * //，此时认为 s 是 平衡 的。
 * //
 * // 请你返回使 s 平衡 的 最少 删除次数。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：s = "aababbab"
 * //输出：2
 * //解释：你可以选择以下任意一种方案：
 * //下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * //下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：s = "bbaaaaabb"
 * //输出：2
 * //解释：唯一的最优解是删除最前面两个字符。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= s.length <= 10⁵
 * // s[i] 要么是 'a' 要么是 'b' 。
 * //
 * //
 * // Related Topics 栈 字符串 动态规划 👍 148 👎 0
 */
class MinimumDeletionsToMakeStringBalanced {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 在两个字符中划一条线，把左侧的b全部删除，右侧的a全部删除，就为最小次数,枚举所有结果
         *
         * @param s
         * @return
         */
        public int minimumDeletions(String s) {
            int len = s.length();
            int[] rightANum = new int[len];
            int right = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) == 'a') {
                    right++;
                }
                rightANum[i] = right;
            }
            int[] leftBNum = new int[len];
            int left = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == 'b') {
                    left++;
                }
                leftBNum[i] = left;
            }
            int result = len;
            for (int i = 0; i < len; i++) {
                // 这个计算的结果将划线的字符串也计算进去了
                result = Math.min(rightANum[i] + leftBNum[i], result);
            }
            // 划线的字符串不用删除
            return result - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}