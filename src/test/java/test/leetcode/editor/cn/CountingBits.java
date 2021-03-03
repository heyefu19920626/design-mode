package test.leetcode.editor.cn;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划


public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        System.out.println(solution.queryOneNum(5));
        final int[] ints = solution.countBits(100);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf("%d ", ints[i]);
        }
        System.out.println();
        System.out.println(solution.count);
    }

    class Solution {
        private int count = 0;

        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            result[0] = 0;
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 0) {
                    int temp = i >> 1;
                    if (result[temp] != 0) {
                        // 被2整除的1的个数与其商的1的个数相等
                        result[i] = result[temp];
                        continue;
                    }
                    result[i] = queryOneNum(i);
                } else {
                    result[i] = result[i - 1] + 1;
                }
            }
            return result;
        }

        private int queryOneNum(String target) {
            count++;
            int num = 0;
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) == '1') {
                    num++;
                }
            }
            return num;
        }


        private int queryOneNum(int target) {
            if (target == 0) {
                return 0;
            }
            // 十进制转二进制： 除2取余，逆序排列
            int num = 0;
            while (target > 1) {
                if (target % 2 != 0) {
                    num++;
                }
                target = target >> 1;
            }
            return num + 1;
        }
    }
}