package test.leetcode.editor.cn;
// 给你一个字符串 date，它的格式为 yyyy-mm-dd，表示一个公历日期。
//
// date 可以重写为二进制表示，只需要将年、月、日分别转换为对应的二进制表示（不带前导零）并遵循 year-month-day 的格式。 
//
// 返回 date 的 二进制 表示。 
//
// 
//
// 示例 1： 
//
// 
// 输入： date = "2080-02-29" 
// 
//
// 输出： "100000100000-10-11101" 
//
// 解释： 
//
// 100000100000, 10 和 11101 分别是 2080, 02 和 29 的二进制表示。 
//
// 示例 2： 
//
// 
// 输入： date = "1900-01-01" 
// 
//
// 输出： "11101101100-1-1" 
//
// 解释： 
//
// 11101101100, 1 和 1 分别是 1900, 1 和 1 的二进制表示。 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其余的 date[i] 都是数字。 
// 输入保证 date 代表一个有效的公历日期，日期范围从 1900 年 1 月 1 日到 2100 年 12 月 31 日（包括这两天）。 
// 
//
// Related Topics 数学 字符串 👍 24 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution3280 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals("100000100000-10-11101", solution.convertDateToBinary("2080-02-29"));
        Assertions.assertEquals("11101101100-1-1", solution.convertDateToBinary("1900-01-01"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 将数字转为2进制
         * <p>
         * 1、将年，月，日提取出来
         * 2、分别转为二进制
         * 3、再拼接完成
         *
         * @param date 日期
         * @return
         */
        public String convertDateToBinary(String date) {
            String[] time = date.split("-");
            return convert(Integer.parseInt(time[0])) + "-" + convert(Integer.parseInt(time[1])) + "-" + convert(
                Integer.parseInt(time[2]));
        }

        /**
         * 一个数字，右移1位，相当于除于2
         * <p>
         * 1、用余数判断: n 除于 2，如果不能整除，说明末位是1，否则为0
         * 2、用与判断: n & 1 = n的末位，只有末位影响结果，其余位都为0
         *
         * @param n
         * @return
         */
        public String convert(int n) {
            StringBuilder res = new StringBuilder();
            // 从后往前
            for (; n > 0; n >>= 1) {
                res.append(n & 1);
            }
            return res.reverse().toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}

