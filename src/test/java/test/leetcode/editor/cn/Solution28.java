/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @since 2022/6/7
 */
public class Solution28 {

    @Test
    public void should_return_2() {
        Assertions.assertEquals(2,new Solution28().strStr("hello","ll"));
    }

    @Test
    public void should_return_minus_1() {
        Assertions.assertEquals(-1,new Solution28().strStr("aaaaa","bba"));
    }

    @Test
    public void should_return_0() {
        Assertions.assertEquals(0,new Solution28().strStr("aaaaa",""));
    }

    @Test
    public void should_return_1() {
        Assertions.assertEquals(1,new Solution28().strStr("bababaa","ab"));
    }

    @Test
    public void should_return_5() {
        Assertions.assertEquals(5,new Solution28().strStr("helloworld","world"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int allLen = haystack.length();
        int len = needle.length();
        for (int i = 0; i <= allLen - len; i++) {
            for (int j = 0; j < len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else {
                    if (j == len - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
