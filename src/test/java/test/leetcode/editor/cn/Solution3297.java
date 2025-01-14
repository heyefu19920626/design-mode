package test.leetcode.editor.cn;
// 给你两个字符串 word1 和 word2 。
//
// 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀 ，那么我们称字符串 x 是 合法的 。 
//
// 请你返回 word1 中 合法 子字符串 的数目。 
//
// 
//
// 示例 1： 
//
// 
// 输入：word1 = "bcca", word2 = "abc" 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一合法的子字符串是 "bcca" ，可以重新排列得到 "abcc" ，"abc" 是它的前缀。 
//
// 示例 2： 
//
// 
// 输入：word1 = "abcabc", word2 = "abc" 
// 
//
// 输出：10 
//
// 解释： 
//
// 除了长度为 1 和 2 的所有子字符串都是合法的。 
//
// 示例 3： 
//
// 
// 输入：word1 = "abcabc", word2 = "aaabc" 
// 
//
// 输出：0 
//
// 
//
// 解释： 
//
// 
// 1 <= word1.length <= 10⁵ 
// 1 <= word2.length <= 10⁴ 
// word1 和 word2 都只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 22 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution3297 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(1, solution.validSubstringCount("bcca", "abc"));
        Assertions.assertEquals(10, solution.validSubstringCount("abcabc", "abc"));
        Assertions.assertEquals(18, solution.validSubstringCount("dcbdcdccb", "cdd"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * word1的长度为n,则字符串的数量为(1+n)*n/2
         * <p>
         * word1的合法子字符串son，必须满足:
         * 1、son的长度大于等于word2
         * 2、son中每个字母数量必须大于等于word2中对应字母的数
         * <p>
         * 所以：
         * 1、计算word2中每个字符的数目
         * 2、遍历word1中长度大于word2的子字符串, 是否满足上面的条件2(超时)
         *
         * @param word1
         * @param word2
         * @return
         */
        public long validSubstringCount(String word1, String word2) {
            long res = 0;
            if (word1.length() < word2.length()) {
                return res;
            }
            int[] word2Char = charNum(word2);
            // 从i开始，遍历word1的子字符串, 子字符串长度为startLen
            // 如果当前子字符串合法，则以i开头的，长度大于当前子字符串的也必然可以  --- 思路1
            // 记录下当前子字符串的各个字母出现的次数，每移动一位，只需要变更改变的位数字母数量即可  --- 思路2, 滑动窗口
            // 组合两种方法
            // 继续优化, 有两种方式，
            // 1、减少判断的时间，当前每次判断要遍历26个字母
            // 2、减少掉复制的时间, 右指针到刚好OK的时候，移动左指针，只需要判断减少的这以为即可
            // 先固定i，遍历所有以i开头的子字符串
            int left = 0;
            int right = word2.length() - 1;
            int[] initNums = charNum(word1.substring(left, right + 1));
            while (right < word1.length()) {
                // 如果当前满足,移动左指针
                // 否则，移动右指针
                if (isCan(word2Char, initNums)) {
                    res += word1.length() - right;
                    int pre = word1.charAt(left) - 97;
                    // 左指针右移一位
                    initNums[pre]--;
                    left++;
                } else {
                    right++;
                    if (right < word1.length()) {
                        int next = word1.charAt(right) - 97;
                        initNums[next]++;
                    }
                }
            }
            for (int i = left + 1; i < word1.length() - word2.length(); i++) {
                int pre = word1.charAt(i) - 97;
                initNums[pre]--;
                if (isCan(word2Char, initNums)) {
                    res++;
                }
            }
            return res;
        }

        private boolean isCan(int[] word2Char, int[] nums) {
            for (int j = 0; j < word2Char.length; j++) {
                if (word2Char[j] > nums[j]) {
                    return false;
                }
            }
            return true;
        }

        private int[] charNum(String word) {
            int[] res = new int[26];
            for (int i = 0; i < word.length(); i++) {
                res[word.charAt(i) - 97]++;
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

