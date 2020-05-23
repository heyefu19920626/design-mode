//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package test.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(solution.twoSum(nums, 6)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        //一遍哈希表
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int reduce = target - nums[i];
                if (map.containsKey(reduce)) {
                    return new int[]{map.get(reduce), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }

        //暴力
        public int[] twoSum1(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}