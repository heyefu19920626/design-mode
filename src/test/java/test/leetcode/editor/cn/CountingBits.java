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
        final int[] ints = solution.countBits(5);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf("%d ", ints[i]);
        }
    }

    class Solution {
        private int count = 0;

        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            int highBit = 0;
            for (int i = 1; i <= num; i++) {
                // 对于正整数 x，如果可以知道最大的正整数 y，使得y≤x且y是2的整数次幂，则 y的二进制表示中只有最高位是1，其余都是0，此时称y为x的「最高有效位」。
                // 令 z=x-y，显然0≤z<x，则bits[x]=bits[z]+1。
                // i & (i - 1) == 0 说明i是2的整数次冥
                if ((i & (i - 1)) == 0) {
                    highBit = i;
                }
                result[i] = result[i - highBit] + 1;
            }
            return result;
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