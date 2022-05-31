/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package test.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * <p>
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * <p>
 * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2022/5/31
 */
public class Solution821 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0},
            new Solution821().shortestToChar("loveleetcode", 'e'));
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0},
            new Solution821().shortestToChar("aaab", 'b'));
    }


    public int[] shortestToChar(String s, char c) {
        int[] lMin = new int[s.length()];
        int left = -s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                left = i;
            }
            lMin[i] = i - left;
        }
        int right = 2 * s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right = i;
            }
            lMin[i] = Math.min(lMin[i], right - i);
        }
        return lMin;
        // return violence(s, c);
    }

    private int[] violence(String s, char c) {
        List<Integer> cIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cIndex.add(i);
            }
        }
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int min = s.length();
            for (Integer index : cIndex) {
                min = Math.min(min, Math.abs(index - i));
            }
            result[i] = min;
        }
        return result;
    }
}
