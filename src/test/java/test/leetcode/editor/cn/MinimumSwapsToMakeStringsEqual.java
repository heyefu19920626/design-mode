//有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。 
//
// 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。 
//
// 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[
//j]。 
//
// 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "xx", s2 = "yy"
//输出：1
//解释：
//交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。 
//
// 示例 2： 
//
// 输入：s1 = "xy", s2 = "yx"
//输出：2
//解释：
//交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
//交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
//注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。 
//
// 示例 3： 
//
// 输入：s1 = "xx", s2 = "xy"
//输出：-1
// 
//
// 示例 4： 
//
// 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1, s2 只包含 'x' 或 'y'。 
// 
// Related Topics 贪心 数学 字符串 👍 90 👎 0

package test.leetcode.editor.cn;

public class MinimumSwapsToMakeStringsEqual {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 比较s1，s2的每一位，得出不同的位数数量，不同的位数为n,s1中与s2中不同的集合为s1_n
         * 设结果为f(n), 则有以下几种情况
         * <p>
         * 1. n=0, f(n) = 0
         * 2. n=奇数, f(n) = -1
         * 3. n=偶数
         * 1. s1_n中x的数量a，y的数量为b, 交换次数为f(n)
         * 2. 如果a为偶数,则f(n) = f(a) + f(b), f(a) = a / 2, f(b) = b / 2
         * 3. 如果a为奇数，则f(n) = 2 + (a+b-2) / 2, a为奇数，b必定也为奇数，a和b每个都取出一个数之后，剩余的为偶数，可以使用上一步的结论，而取出的两个数最小交换次数为2
         *
         * @param s1
         * @param s2
         * @return
         */
        public int minimumSwap(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return -1;
            }
            int notSameX = 0;
            int notSameY = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (s1.charAt(i) == 'x') {
                        notSameX++;
                    } else {
                        notSameY++;
                    }
                }
            }
            int notSameNum = notSameY + notSameX;
            if (notSameNum % 2 != 0) {
                return -1;
            }
            if (notSameX % 2 == 0) {
                return notSameNum / 2;
            }
            return notSameNum / 2 + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}