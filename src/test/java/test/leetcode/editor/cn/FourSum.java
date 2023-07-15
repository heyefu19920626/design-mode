//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1645 👎 0

package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    Solution solution = new Solution();

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            return violence(nums, target);
        }

        private List<List<Integer>> violence(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Set<String> exitResult = new HashSet<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    long two = nums[i] + nums[j];
                    for (int m = j + 1; m < nums.length - 1; m++) {
                        long three = two + nums[m];
                        for (int n = m + 1; n < nums.length; n++) {
                            long four = three + nums[n];
                            if (four == target) {
                                String cur = String.format("%s_%s_%s_%s", nums[i], nums[j], nums[m], nums[n]);
                                if (!exitResult.contains(cur)) {
                                    exitResult.add(cur);
                                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m], nums[n])));
                                }
                                break;
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    @Test
    void should_return_correct_when_target_is_0() {
        List<List<Integer>> result = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        Assertions.assertEquals("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]", result.toString());
    }

    @Test
    void should_return_correct_when_target_is_8() {
        List<List<Integer>> result = solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        Assertions.assertEquals("[[2, 2, 2, 2]]", result.toString());
    }

    @Test
    void should_return_empty_when_target_is_8() {
        List<List<Integer>> result = solution.fourSum(new int[]{2, 2, 2}, 8);
        Assertions.assertEquals("[]", result.toString());
    }

    @Test
    void should_return_empty_when_target_is_large() {
        List<List<Integer>> result = solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000},
            -294967296);
        Assertions.assertEquals("[]", result.toString());
    }

    @Test
    void should_return_correct_0_when_target_is_0() {
        List<List<Integer>> result = solution.fourSum(new int[]{0, 0, 0, 0}, 0);
        Assertions.assertEquals("[[0, 0, 0, 0]]", result.toString());
    }

    @Test
    void should_return_correct_when_target_is_11() {
        List<List<Integer>> result = solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        Assertions.assertEquals("[[-5, -4, -3, 1]]", result.toString());
    }

    @Test
    void should_return_empty_when_target_is_small() {
        int[] ints = {-1000000000, -1000000000, -1000000000, -1000000000};
        System.out.println(ints[0] + ints[1] + ints[2]);
        System.out.println(ints[0] + ints[1] + ints[2] + ints[3]);
        List<List<Integer>> result = solution.fourSum(new int[]{-1000000000, -1000000000, -1000000000, -1000000000},
            294967296);
        Assertions.assertEquals("[]", result.toString());
    }
}