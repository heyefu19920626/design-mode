package test.leetcode.editor.cn;

//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈


public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        int[] nums = new int[]{1};
        for (int i : solution.nextGreaterElements(nums)) {
            System.out.println(i);
        }
    }

    class Solution {
        /**
         * @param nums
         * @return
         */
        public int[] nextGreaterElements(int[] nums) {
            int[] result = new int[nums.length];
            boolean isFind;
            for (int i = 0; i < nums.length; i++) {
                isFind = false;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        result[i] = nums[j];
                        isFind = true;
                        break;
                    }
                }
                if (!isFind) {
                    for (int j = 0; j < i; j++) {
                        if (nums[j] > nums[i]) {
                            result[i] = nums[j];
                            isFind = true;
                            break;
                        }
                    }
                }
                if (!isFind) {
                    result[i] = -1;
                }
            }
            return result;
        }
    }
}