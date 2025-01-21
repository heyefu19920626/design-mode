package test.leetcode.editor.cn;
// Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
//
// 
//
// 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。 
//
// 
// 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母 'k' 。 
// 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。 
// 
//
// 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。 
//
// 
// 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。 
// 
//
// 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：pressedKeys = "22233"
// 输出：8
// 解释：
// Alice 可能发出的文字信息包括：
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
// 由于总共有 8 种可能的信息，所以我们返回 8 。
// 
//
// 示例 2： 
//
// 
// 输入：pressedKeys = "222222222222222222222222222222222222"
// 输出：82876089
// 解释：
// 总共有 2082876103 种 Alice 可能发出的文字信息。
// 由于我们需要将答案对 10⁹ + 7 取余，所以我们返回 2082876103 % (10⁹ + 7) = 82876089 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pressedKeys.length <= 10⁵ 
// pressedKeys 只包含数字 '2' 到 '9' 。 
// 
//
// Related Topics 哈希表 数学 字符串 动态规划 👍 114 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution2266 {
    Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(1, solution.countTexts("2"));
        Assertions.assertEquals(7, solution.countTexts("2222"));
        Assertions.assertEquals(8, solution.countTexts("22233"));
        Assertions.assertEquals(82876089, solution.countTexts("222222222222222222222222222222222222"));
        Assertions.assertEquals(886136986, solution.countTexts(
            "88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int devisor = 1000000007;

        /**
         * 动态规划
         * <p>
         * pressedKeys可以拆分成不同的子串，每个子串中只包含一种字符，结果为每个子串可能得组合数相乘
         * <p>
         * 当字符支持3个字母时，则末尾的字母有三种情况，分别对应按1、2、3次的情况，
         * 可以得到推导式
         * f(x) = f(x-1) + f(x-2) + f(x-3)
         *
         * @param pressedKeys
         * @return
         */
        public int countTexts(String pressedKeys) {
            long res = 1;
            List<Long> threePlan = new ArrayList<>();
            threePlan.add(1L);
            threePlan.add(1L);
            threePlan.add(2L);
            threePlan.add(4L);
            List<Long> fourPlan = new ArrayList<>();
            fourPlan.add(1L);
            fourPlan.add(1L);
            fourPlan.add(2L);
            fourPlan.add(4L);
            // fourPlan.add(8L);
            char cur = pressedKeys.charAt(0);
            int len = 0;
            for (int i = 0; i < pressedKeys.length(); i++) {
                if (pressedKeys.charAt(i) == cur) {
                    len++;
                } else {
                    res = computeRes(cur, len, threePlan, fourPlan, res);
                    len = 1;
                    cur = pressedKeys.charAt(i);
                }
            }
            return (int) computeRes(cur, len, threePlan, fourPlan, res);
        }

        private long computeRes(char cur, int len, List<Long> threePlan, List<Long> fourPlan, long res) {
            boolean isThree = cur != '7' && cur != '9';
            long curRes = compute(len, isThree ? threePlan : fourPlan, isThree);
            res = res * curRes % devisor;
            return res;
        }

        private long compute(int len, List<Long> plan, boolean isThree) {
            if (plan.size() > len) {
                return plan.get(len);
            }
            int size = plan.size();
            for (int i = size; i <= len; i++) {
                long cur = plan.get(i - 1) + plan.get(i - 2) + plan.get(i - 3);
                if (!isThree) {
                    cur += plan.get(i - 4);
                }
                cur = cur % devisor;
                plan.add(cur);
            }
            return plan.get(len);
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}

