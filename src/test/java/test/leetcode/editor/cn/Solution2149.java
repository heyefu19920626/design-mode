/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package test.leetcode.editor.cn;

/**
 * @since 2022/5/24
 */
public class Solution2149 {
    public int[] rearrangeArray(int[] nums) {
        int positiveIndex = 0;
        int minusIndex = 1;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (positiveIndex < i && nums[positiveIndex] > 0) {
                    temp = nums[positiveIndex];
                    nums[positiveIndex] = nums[i];
                    nums[i] = temp;
                    positiveIndex += 2;
                } else {
                    positiveIndex = i;
                }
            } else {
                if (minusIndex < i && nums[minusIndex] > 0) {
                    temp = nums[minusIndex];
                    nums[minusIndex] = nums[i];
                    nums[i] = temp;
                    minusIndex += 2;
                } else {
                    minusIndex = i;
                }
            }
        }
        return nums;
    }
}