/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package test.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @since 2022/5/27
 */
public class Solution1170 {
    @Test
    public void computeMinTimes() {
        Assert.assertEquals(1, new Solution1170().computeMinTimes("bbabc"));
        Assert.assertEquals(2, new Solution1170().computeMinTimes("bbabac"));
    }

    @Test
    public void numSmallerByFrequency() {
        Assert.assertArrayEquals(new int[]{1},
            new Solution1170().numSmallerByFrequency(new String[]{"cbd"}, new String[]{
                "zaaaz"}));
        Assert.assertArrayEquals(new int[]{1, 2}, new Solution1170().numSmallerByFrequency(new String[]{"bbb", "cc"},
            new String[]{"a", "aa", "aaa", "aaaa"}));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] queryValue = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryValue[i] = computeMinTimes(queries[i]);
        }
        int[] wordValue = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordValue[i] = computeMinTimes(words[i]);
        }
        Arrays.sort(wordValue);
        for (int i = 0; i < queryValue.length; i++) {
            boolean find = false;
            for (int j = wordValue.length - 1; j >= 0; j--) {
                if (queryValue[i] >= wordValue[j]) {
                    result[i] = words.length - j - 1;
                    find = true;
                    break;
                }
            }
            if (!find) {
                result[i] = words.length;
            }
        }
        return result;
    }

    public int computeMinTimes(String target) {
        int times = 0;
        if (target == null || target.length() == 0) {
            return times;
        }
        char pre = target.charAt(0);
        times = 1;
        for (int i = 1; i < target.length(); i++) {
            char cur = target.charAt(i);
            if (cur < pre) {
                pre = cur;
                times = 1;
            } else if (cur == pre) {
                times++;
            }
        }
        return times;
    }
}