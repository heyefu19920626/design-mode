//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
// Related Topics 位运算 数学 字符串 👍 72 👎 0

package test.leetcode.editor.cn;

public class BianryNumberToStringLcci {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 要寻找小数的二进制, 将该小数乘以2，其整数部分就是第一位二进制，将剩余的小数部分依次操作即可
         *
         * @param num
         * @return
         */
        public String printBin(double num) {
            StringBuilder result = new StringBuilder("0.");
            double end = num;
            for (int i = 0; i < 30; i++) {
                num = num * 2;
                if (num >= 1) {
                    result.append("1");
                    num = num - 1;
                    if (num == 0) {
                        break;
                    }
                } else {
                    result.append("0");
                }
            }
            if (num != 0) {
                return "ERROR";
            }
            return result.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}