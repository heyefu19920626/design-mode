package test.leetcode.editor.cn;
// 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
//
// 
// 该整数是 num 的一个长度为 3 的 子字符串 。 
// 该整数由唯一一个数字重复 3 次组成。 
// 
//
// 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。 
//
// 注意： 
//
// 
// 子字符串 是字符串中的一个连续字符序列。 
// num 或优质整数中可能存在 前导零 。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：num = "6777133339"
// 输出："777"
// 解释：num 中存在两个优质整数："777" 和 "333" 。
//"777" 是最大的那个，所以返回 "777" 。
// 
//
// 示例 2： 
//
// 
// 输入：num = "2300019"
// 输出："000"
// 解释："000" 是唯一一个优质整数。
// 
//
// 示例 3： 
//
// 
// 输入：num = "42352338"
// 输出：""
// 解释：不存在长度为 3 且仅由一个唯一数字组成的整数。因此，不存在优质整数。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= num.length <= 1000 
// num 仅由数字（0 - 9）组成 
// 
//
// Related Topics 字符串 👍 25 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2264 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals("777", solution.largestGoodInteger("6777133339"));
        Assertions.assertEquals("000", solution.largestGoodInteger("2300019"));
        Assertions.assertEquals("", solution.largestGoodInteger("42352338"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 从第三位开始左到右进行遍历，如果该位与前两位相等，记录此时的值,并与之前的进行对比
         *
         * @param num
         * @return
         */
        public String largestGoodInteger(String num) {
            String single = "-1";
            for (int i = 2; i < num.length(); i++) {
                if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                    // 数字字符在二进制中要剪去48
                    single = String.valueOf(Math.max(num.charAt(i) - 48, Integer.parseInt(single)));
                }
            }
            if (single.equals("-1")) {
                return "";
            }
            return single + single + single;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}

