package test.leetcode.editor.cn;

/**
 * //给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和
 * //asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b =
 * //bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 * //
 * // 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么
 * // "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 * //
 * // 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 * //
 * // 注意， x + y 表示连接字符串 x 和 y 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：a = "x", b = "y"
 * //输出：true
 * //解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * //aprefix = "", asuffix = "x"
 * //bprefix = "", bsuffix = "y"
 * //那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：a = "abdef", b = "fecab"
 * //输出：true
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：a = "ulacfd", b = "jizalu"
 * //输出：true
 * //解释：在下标为 3 处分割：
 * //aprefix = "ula", asuffix = "cfd"
 * //bprefix = "jiz", bsuffix = "alu"
 * //那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= a.length, b.length <= 10⁵
 * // a.length == b.length
 * // a 和 b 都只包含小写英文字母
 * //
 * //
 * // Related Topics 双指针 字符串 👍 75 👎 0
 */
class SplitTwoStringsToMakePalindrome {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 先从左到右遍历a,指针为i,同时从右到左遍历b,指针为j
         * 如果满足:a[i] = b[j], 直到i = j或者 i-1=j(长度为偶数)停止,则结果为true
         * 如果a[i] != b[j],那么此时a或者b没有遍历到的部分即a[i:j]或者b[i:j]为回文,则结果继续为true
         * <p>
         * 同理,将a与b反一下
         *
         * @param a
         * @param b
         * @return
         */
        public boolean checkPalindromeFormation(String a, String b) {
            return judge(a, b) || judge(b, a);
        }

        private static boolean judge(String a, String b) {
            int len = a.length();
            int i = 0, j = len - 1;
            boolean convert = false;
            while (true) {
                if (i == j || i - 1 == j) {
                    return true;
                }
                if (a.charAt(i) != b.charAt(j)) {
                    return judgeSub(b, i, j) || judgeSub(a, i, j);
                }
                i++;
                j--;
            }
        }

        private static boolean judgeSub(String b, int i, int j) {
            while (true) {
                if (i == j || i - 1 == j) {
                    return true;
                }
                if (b.charAt(i) != b.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}