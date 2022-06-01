/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package test.nowcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 判断字符串子序列
 * <p>
 * 给定两个字符串source和target，source的一个子序列可以是source删除一些字符串（或者不删除），但不改变原有顺序形成的子字符串
 *
 * @since 2022/6/1
 */
public class JudgeSubSequence {

    @Test
    public void test() {
        Assert.assertEquals(3, new JudgeSubSequence().judgeSubSequence("abcaybec", "abc"));
        Assert.assertEquals(0, new JudgeSubSequence().judgeSubSequence("abcaybec", "acy"));
        Assert.assertEquals(-1, new JudgeSubSequence().judgeSubSequence("aebycd", "ayb"));
    }


    public int judgeSubSequence(String source, String target) {
        int targetIndex = target.length() - 1;
        for (int i = source.length() - 1; i >= 0; i--) {
            if (source.charAt(i) == target.charAt(targetIndex)) {
                targetIndex--;
            }
            if (targetIndex < 0) {
                return i;
            }
        }
        return -1;
    }
}