package test.leetcode.editor.cn;

import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree">1261. 在受污染的二叉树中查找元素</a>
 *
 * @since 2024/3/12
 **/
public class Solution1261Test {
    @Test
    void test() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(-1, -1, -1, -1, -1));
        FindElements findElements = new FindElements(root);
        Assertions.assertTrue(findElements.find(1));
        Assertions.assertTrue(findElements.find(3));
        Assertions.assertFalse(findElements.find(5));
    }

    @Test
    void test_1() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(-1, null, -1, -1, null, -1));
        FindElements findElements = new FindElements(root);
        Assertions.assertTrue(findElements.find(2));
        Assertions.assertFalse(findElements.find(3));
        Assertions.assertFalse(findElements.find(4));
        Assertions.assertTrue(findElements.find(5));
    }
}

class FindElements {
    List<Integer> values = new ArrayList<>();

    /**
     * 首先要还原二叉树
     * <p>
     * 二叉树的根节点值为0，左子节点为父节点的值 parent.val * 2 + 1, 右子节点的值为parent.val * 2 + 2
     * <p>
     * 方法1：
     * 因为遍历二叉树的同时，修改节点的值, 并保存下值，后续find时直接判断是否包含即可
     *
     * @param root 根节点
     */
    public FindElements(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        values.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                cur.left.val = cur.val * 2 + 1;
                values.add(cur.left.val);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                cur.right.val = cur.val * 2 + 2;
                values.add(cur.right.val);
                queue.offer(cur.right);
            }
        }
    }

    /**
     * 查找元素是否存在
     *
     * @param target 目标元素的值
     * @return 是否存在
     */
    public boolean find(int target) {
        return values.contains(target);
    }
}