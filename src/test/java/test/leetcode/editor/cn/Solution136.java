/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2022/6/6
 */
public class Solution136 {


    public int singleNumber(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Integer cur = Integer.valueOf(nums[i]);
            if (list.contains(cur)) {
                list.remove(cur);
            } else {
                list.add(cur);
            }
        }
        return list.get(0);
    }
}
