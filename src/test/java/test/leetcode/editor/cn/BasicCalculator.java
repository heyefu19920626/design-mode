package test.leetcode.editor.cn;

//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        // System.out.println(solution.calculate("1 + 1"));
        System.out.println(solution.calculate("- (3 + (4 + 5))"));
        // System.out.println(solution.sum("-5+9"));
        // System.out.println(solution.sum("1+1"));
    }

    class Solution {
        public int calculate(String s) {
            Stack<String> stack = new Stack<>();
            s = s.replaceAll(" ", "");
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != ')') {
                    stack.push(String.valueOf(c));
                } else {
                    String temp = "";
                    while (!stack.peek().equals("(")) {
                        temp = stack.pop() + temp;
                    }
                    stack.pop();
                    int sum = sum(temp);
                    if (sum < 0) {
                        if (stack.isEmpty()) {
                            stack.push(String.valueOf(sum));
                        } else if (stack.peek().equals("+")) {
                            stack.pop();
                            stack.push(String.valueOf(sum));
                        } else if (stack.peek().equals("-")) {
                            stack.pop();
                            stack.push("+" + String.valueOf(-sum));
                        }
                    } else {
                        stack.push(String.valueOf(sum));
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            stack.forEach(builder::append);
            return sum(builder.toString());
        }

        public int sum(String s) {
            System.out.println(s);
            Stack<Integer> stack = new Stack<>();
            if (s.startsWith("-")) {
                s = s.substring(1);
                String temp = "";
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '-' || c == '+') {
                        s = s.substring(i);
                        break;
                    }
                    temp += c;
                }
                stack.push(Integer.parseInt("-" + temp));
                if (s.indexOf('-') < 0 && s.indexOf('+') < 0) {
                    return stack.pop();
                }
            }

            String a = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '+' || c == '-') {
                    if (a.length() > 0) {
                        stack.push(Integer.valueOf(a));
                        a = "";
                    }
                    String temp = "";
                    for (int j = i + 1; j < s.length(); j++) {
                        char e = s.charAt(j);
                        if (e == '+' || e == '-') {
                            i = j - 1;
                            break;
                        }
                        temp += e;
                        i = j;
                    }
                    int result = 0;
                    if (c == '+') {
                        result = stack.pop() + Integer.parseInt(temp);
                    } else {
                        result = stack.pop() - Integer.parseInt(temp);
                    }
                    stack.push(result);
                } else {
                    a += c;
                }
            }
            if (a.length() > 0) {
                return Integer.parseInt(a);
            }
            return stack.pop();
        }
    }
}