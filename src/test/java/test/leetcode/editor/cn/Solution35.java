package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 *
 * @author he
 * @since 2022-06.23-23:10
 */
public class Solution35 {
    private int[] nums = new int[]{1, 3, 5, 6};

    @Test
    void should_return_2_when_5_exits() {
        Assertions.assertEquals(2, new Solution35().searchInsert(nums, 5));
    }

    @Test
    void should_return_1_when_2_not_exits() {
        Assertions.assertEquals(1, new Solution35().searchInsert(nums, 2));
    }

    @Test
    void should_return_4_when_7_not_exits() {
        Assertions.assertEquals(4, new Solution35().searchInsert(nums, 7));
    }

    @Test
    void should_return_0_when_0_not_exits() {
        Assertions.assertEquals(0, new Solution35().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int midIndex = (int) Math.round((start + end) / 2.0);
            if (nums[midIndex] > target) {
                if (end == midIndex) {
                    end--;
                } else {
                    end = midIndex;
                }
            } else if (nums[midIndex] < target) {
                if (start == midIndex) {
                    start++;
                } else {
                    start = midIndex;
                }
            } else {
                return midIndex;
            }
        }
        int round = (int) Math.round((start + end) / 2.0);
        if (nums[round] < target) {
            return round + 1;
        }
        return round;
    }
}
