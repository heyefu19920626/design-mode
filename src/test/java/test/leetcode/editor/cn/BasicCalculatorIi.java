package test.leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate("3"));
    }

    class Solution {
        /**
         * 使用栈
         * <p>
         * 先计算乘法和除法
         * <p>
         * 依次入栈，遇到乘法和除法后出栈计算后再入栈
         * <p>
         * 最后只剩加法和减法，再计算
         *
         * @param s
         * @return
         */
        public int calculate(String s) {
            Stack<String> stack = new Stack<>();
            List<String> list = Arrays.asList("*", " ", "+", "-", "/");

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    continue;
                }
                if (c == '*' || c == '/') {
                    String a = "";
                    while (!stack.isEmpty() && !stack.peek().equals("+") && !"-".equals(stack.peek())) {
                        a = stack.pop() + a;
                    }
                    String b = "";
                    for (int j = i + 1; j < s.length(); j++) {
                        char d = s.charAt(j);
                        if (d == ' ') {
                            continue;
                        }
                        if (list.contains(String.valueOf(d))) {
                            i = j - 1;
                            break;
                        }
                        b += d;
                        i = j;
                    }
                    if (c == '*') {
                        stack.push(String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));
                    } else {
                        stack.push(String.valueOf(Integer.parseInt(a) / Integer.parseInt(b)));
                    }
                } else {
                    stack.push(String.valueOf(c));
                }
            }
            StringBuilder builder = new StringBuilder();
            stack.forEach(builder::append);
            return sum(builder.toString());
        }

        public int sum(String s) {
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