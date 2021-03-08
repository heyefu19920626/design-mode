package test.leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划


import java.util.Arrays;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        System.out.println(solution.isPalindrome("ccdd"));
        System.out.println(solution.minCut("abbab"));
    }

    class Solution {
        public int minCut(String s) {
            int len = s.length();
            // 二维数组用来保存预处理s[i]-s[j]之间是否为回文串的结果
            boolean[][] isPalindrome = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                Arrays.fill(isPalindrome[i], true);
            }
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    // 动态规划求s[i]-s[j]之间是否是回文串
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
            }

            int[] result = new int[len];
            Arrays.fill(result, Integer.MAX_VALUE);
            // 外层循环求Fn
            for (int i = 0; i < len; i++) {
                // 如果从头到i都是回文，则该段最小分割次数为0
                if (isPalindrome[0][i]) {
                    result[i] = 0;
                } else {
                    // 使用动态规划，去除最后一个回文子串，则最后结果为求之前的最小分割数+1
                    for (int j = 0; j < i; j++) {
                        // 如果以j分割，j后面的到末尾是回文，则可以在这切割
                        if (isPalindrome[j + 1][i]) {
                            // 在这切割，并不意味着这里就是最小分割数，因此需要比较所有分割点的最小值 abbab
                            result[i] = Math.min(result[j] + 1, result[i]);
                        }
                    }
                }
            }
            return result[len - 1];
        }

        /**
         * 使用动态规划判断字符串是否为回文串
         *
         * @param s 目标
         * @return 判断结果
         */
        public boolean isPalindrome(String s) {
            if (s.length() <= 1) {
                return true;
            }
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}