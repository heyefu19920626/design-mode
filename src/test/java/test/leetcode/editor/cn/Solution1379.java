/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package test.leetcode.editor.cn;

import test.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/">找出克隆二叉树中的相同节点</a>
 *
 * @author h00620506
 * @version [dms, 2024/4/3]
 * @since 2024/4/3
 **/
public class Solution1379 {
    /**
     * 因为原始树与克隆树结构完全一样，因此可以将原始树与克隆树使用相同方式一起遍历,当在原始树找到target时，对应的克隆树上的节点也就找到了
     *
     * @param original 原始树
     * @param cloned 克隆树
     * @param target 原始树上的目标节点
     * @return 克隆树上的目标节点
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> originQueue = new LinkedList<>();
        originQueue.offer(original);
        Queue<TreeNode> cloneQueue = new LinkedList<>();
        cloneQueue.offer(cloned);
        while (!originQueue.isEmpty()) {
            TreeNode originCur = originQueue.poll();
            TreeNode cloneCur = cloneQueue.poll();
            if (originCur == target) {
                return cloneCur;
            }
            if (originCur.left != null) {
                originQueue.offer(originCur.left);
                cloneQueue.offer(cloneCur.left);
            }
            if (originCur.right != null) {
                originQueue.offer(originCur.right);
                cloneQueue.offer(cloneCur.right);
            }
        }
        return null;
    }
}
