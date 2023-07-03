//给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 
//恰好 只有一个字符不同的子字符串对的数目。 
//
// 比方说， "computer" and "computation" 只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。 
//
// 请你返回满足上述条件的不同子字符串对数目。 
//
// 一个 子字符串 是一个字符串中连续的字符。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba", t = "baba"
//输出：6
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//示例 2：
//
// 
//输入：s = "ab", t = "bb"
//输出：3
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("ab", "bb")
//("ab", "bb")
//("ab", "bb")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//示例 3：
//
// 
//输入：s = "a", t = "a"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "abe", t = "bbc"
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 100 
// s 和 t 都只包含小写英文字母。 
// 
// Related Topics 哈希表 字符串 动态规划 👍 114 👎 0

package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSubstringsThatDifferByOneCharacter {
    CountSubstringsThatDifferByOneCharacter.Solution solution = new Solution();

    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param s
         * @param t
         * @return
         */
        public int countSubstrings(String s, String t) {
            return violent(s, t);
        }

        // 暴力解法, 时间复杂度 n*n*n
        // 优化，哈希表，子串的长度从1到len，
        // 当子串长度为1时，比较s串与t串的每个字符的是否相同
        // 使用一个长为s.len,宽为t.len的二维数组temp保存不同字符的结果temp[k][j]表示从s串从j起i个，t串从j起i个字符中不相同字符的个数
        // 长度为2时，可以根据上一步的结果省略一些操作
        private int violent(String s, String t) {
            int res = 0;
            int subMaxLen = s.length();
            int[][] temp = new int[s.length()][t.length()];
            // 子串的长度
            for (int i = 1; i <= subMaxLen; i++) {
                for (int j = 0; j <= s.length() - i; j++) {
                    char sCur = s.charAt(j + i - 1);
                    for (int k = 0; k <= t.length() - i; k++) {
                        char tCur = t.charAt(k + i - 1);
                        if (temp[j][k] <= 1) {
                            // 如果新增位数不同
                            if (sCur != tCur) {
                                // 老位数都相同
                                if (temp[j][k] == 0) {
                                    res++;
                                }
                                temp[j][k]++;
                            } else {
                                if (temp[j][k] == 1) {
                                    res++;
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    @Test
    void should_return_6() {
        Assertions.assertEquals(6, solution.countSubstrings("aba", "baba"));
    }

    @Test
    void should_return_3() {
        Assertions.assertEquals(3, solution.countSubstrings("ab", "bb"));
    }

    @Test
    void should_return_0() {
        Assertions.assertEquals(0, solution.countSubstrings("a", "a"));
    }

    @Test
    void should_return_10() {
        Assertions.assertEquals(10, solution.countSubstrings("abe", "bbc"));
    }
}