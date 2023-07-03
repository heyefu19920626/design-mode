package test.leetcode.editor.cn;

import java.util.*;

/**
 * //如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。
 * //
 * // 花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则：
 * //
 * //
 * // 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x}
 * //
 * //
 * //
 * // 例如，表达式 "a" 表示字符串 "a"。
 * // 而表达式 "w" 就表示字符串 "w"。
 * //
 * //
 * // 当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 * //
 * // 例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。
 * // 而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。
 * //
 * //
 * // 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a,
 * //b) in R(e_1) × R(e_2)}
 * //
 * // 例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。
 * //
 * //
 * // 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
 * //
 * // 例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"。
 * // 例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh",
 * //"acdfg", "acdfh", "acefg", "acefh"。
 * //
 * //
 * //
 * //
 * // 给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。
 * //
 * // 假如你希望以「集合」的概念了解此题，也可以通过点击 “显示英文描述” 获取详情。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：expression = "{a,b}{c,{d,e}}"
 * //输出：["ac","ad","ae","bc","bd","be"]
 * //
 * // 示例 2：
 * //
 * //
 * //输入：expression = "{{a,z},a{b,c},{ab,z}}"
 * //输出：["a","ab","ac","z"]
 * //解释：输出中 不应 出现重复的组合结果。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= expression.length <= 60
 * // expression[i] 由 '{'，'}'，',' 或小写英文字母组成
 * // 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串
 * //
 * //
 * // Related Topics 栈 广度优先搜索 字符串 回溯 👍 164 👎 0
 */
class BraceExpansionIi {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 先解决三种乘法：
         * }{ ; a{ ; }a;
         * 使用栈
         * <p>
         * 遇到右括号开始出栈，左括号出栈后停止出栈
         * 此时，栈顶有以下几种情况：
         * 1. 栈顶为空, 那将括号及括号内的内容作为一个整体重新入栈
         * 2. 栈顶为逗号, 可以将括号去除重新入栈
         * 3. 栈顶为字母, 将字母与出栈的字母相乘，重新入栈
         * 4. 栈顶为右括号, 继续出栈，并将后出栈后的字母与先出栈的字母相乘
         * 5. 栈顶为左括号，那将括号及括号内的内容作为一个整体重新入栈
         * <p>
         * 如果字母前面是右括号，则也需出栈相乘
         *
         * @param expression
         * @return
         */
        public List<String> braceExpansionII(String expression) {
            System.out.println(expression);
            String pre = compute(expression);
            String next = compute(pre);
            while (pre.length() != next.length()) {
                System.out.println(next);
                pre = next;
                next = compute(next);
            }
            System.out.println(next);
            return new ArrayList<>();
        }

        private String compute(String expression) {
            Stack<String> stack = new Stack<>();
            String temp = "";
            for (int i = 0; i < expression.length(); i++) {
                char cur = expression.charAt(i);
                if (cur >= 'a' && cur <= 'z') {
                    // 字母
                    temp = temp + cur;
                } else if (cur == '}') {
                    if (temp.length() > 0) {
                        stack.add(temp);
                        temp = "";
                    }
                    // 右括号出栈
                    LinkedList<String> builder = new LinkedList<>();
                    while (true) {
                        String top = stack.pop();
                        if (top.equals("{")) {
                            break;
                        }
                        builder.add(0, top);
                    }
                    if (stack.isEmpty() || "{".equals(stack.peek())) {
                        // 作为一个整体入栈
                        stack.add("{" + String.join("", builder) + "}");
                    } else if (",".equals(stack.peek())) {
                        // 栈顶为逗号
                        stack.addAll(builder);
                    } else if ("}".equals(stack.peek())) {
                        // 栈顶为右括号
                        LinkedList<String> pre = new LinkedList<>();
                        while (true) {
                            String top = stack.pop();
                            pre.add(0, top);
                            if (top.equals("{")) {
                                break;
                            }
                        }
                        Set<String> mulRe = mul(pre, builder);
                        stack.add("{" + String.join(",", mulRe) + "}");
                    } else {
                        List<String> pre = new ArrayList<>();
                        pre.add(stack.pop());
                        // 栈顶为字母
                        Set<String> mulRe = mul(pre, builder);
                        stack.add("{" + String.join(",", mulRe) + "}");
                    }
                } else {
                    // 左括号或者逗号
                    if (temp.length() > 0) {
                        // 第三种乘法,交换一下位置
                        if (!stack.isEmpty() && stack.peek().endsWith("}")) {
                            String top = stack.pop();
                            stack.add(temp);
                            stack.add(top);
                        } else {
                            stack.add(temp);
                        }
                        temp = "";
                    }
                    stack.add(String.valueOf(cur));
                }
            }
            if (temp.length() > 0) {
                stack.add(temp);
            }
            return String.join("", stack);
        }

        private Set<String> mul(List<String> a, List<String> b) {
            a.removeIf(as -> ",".equals(as) || "{".equals(as) || "}".equals(as));
            b.removeIf(as -> ",".equals(as) || "{".equals(as) || "}".equals(as));
            Set<String> result = new HashSet<>();
            for (String as : a) {
                for (String bs : b) {
                    result.add(as + bs);
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}