/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2023-2023. All rights reserved.
 */

package test.leetcode.editor.cn;

/**
 * @author h00620506
 * @version [SmartKit, 2023/7/3]
 * @since 2023/7/3
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getListNodeFromArray(int[] array) {
        ListNode next = null;
        for (int i = array.length - 1; i >= 0; i--) {
            if (next == null) {
                next = new ListNode(array[i]);
            } else {
                next = new ListNode(array[i], next);
            }
        }
        return next;
    }
}
