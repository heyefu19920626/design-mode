package test.leetcode.editor.cn;

import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree">题目</a>
 *
 * @since 2024/2/8
 **/
public class Solution993 {
    @Test
    void test() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(1, 2, 3, 4));
        Assertions.assertFalse(isCousins(root, 4, 3));
        root = TreeUnit.initTreeNode(Arrays.asList(1, 2, 3, null, 4, null, 5));
        Assertions.assertTrue(isCousins(root, 5, 4));
        root = TreeUnit.initTreeNode(Arrays.asList(1, 2, 3, null, 4));
        Assertions.assertFalse(isCousins(root, 2, 3));
    }

    /**
     * 思路：
     * <p>
     * 首先使用bfs遍历, 遍历每层时，看该节点是否在同一层，如果不在同一层，则不是，如果在同一层，但父节点相同，则也不是
     *
     * @param root 根节点
     * @param x 第一个节点的值
     * @param y 第二个节点的值
     * @return x与y是否是堂兄弟
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        // 当前层
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLayer = new LinkedList<>();
            // 下一层
            while (!queue.isEmpty()) {
                boolean containX = false;
                boolean containY = false;
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    nextLayer.add(cur.left);
                    if (cur.left.val == x) {
                        containX = true;
                    }
                    if (cur.left.val == y) {
                        containY = true;
                    }
                }
                if (cur.right != null) {
                    nextLayer.add(cur.right);
                    if (cur.right.val == x) {
                        containX = true;
                    }
                    if (cur.right.val == y) {
                        containY = true;
                    }
                }
                // 亲兄弟
                if (containX && containY) {
                    return false;
                }
            }
            // 堂兄弟
            if (nextLayer.stream().anyMatch(node -> node.val == x) && nextLayer.stream()
                .anyMatch(node -> node.val == y)) {
                return true;
            }
            queue = nextLayer;
        }

        return false;
    }
}