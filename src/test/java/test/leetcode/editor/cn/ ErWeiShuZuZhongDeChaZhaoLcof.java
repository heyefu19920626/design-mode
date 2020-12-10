package test.leetcode.editor.cn;

/**
 * 剑指 Offer 04. 二维数组中的查找
 */
class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int row = matrix.length - 1;
            if (row < 0) {
                return false;
            }
            int column = matrix[0].length;
            int co = 0;
            while (row >= 0 && co < column) {
                if (matrix[row][co] == target) {
                    return true;
                }
                if (matrix[row][co] > target) {
                    row--;
                    continue;
                }
                if (matrix[row][co] < target) {
                    co++;
                }
            }
            return false;
        }
    }
}
