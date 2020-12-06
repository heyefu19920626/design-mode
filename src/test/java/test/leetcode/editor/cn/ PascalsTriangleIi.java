package test.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(JSON.toJSONString(solution.generate(4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>(numRows);
            for (int i = 0; i < numRows; i++) {
                int number = i + 1;
                List<Integer> row = new ArrayList<>(number);
                for (int j = 0; j < number; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        List<Integer> last = result.get(i - 1);
                        row.add(last.get(j - 1) + last.get(j));
                    }
                }
                result.add(row);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}