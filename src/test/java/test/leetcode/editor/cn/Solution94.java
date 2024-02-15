package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author he
 * @since 2024-02.10-09:11
 */
public class Solution94 {

    @Test
    public void test() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(1, null, 2, 3));
        Assertions.assertIterableEquals(Arrays.asList(1, 3, 2), inorderTraversal(root));
        Assertions.assertIterableEquals(Arrays.asList(), inorderTraversal(null));
        root = TreeUnit.initTreeNode(Arrays.asList(1));
        Assertions.assertIterableEquals(Arrays.asList(1), inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // dfs(root, res);
        dfsByIterate(root, res);
        return res;
    }

    /**
     * 使用迭代实现dfs
     * <p>
     * 使用两个栈来分别存储左侧的节点和右侧的节点
     * <p>
     * 任何节点都先进入左栈，然后出栈进入右栈，当左栈为空的时候，右栈开始出栈，此时该节点加入结果，并将该节点的右孩子加入左栈
     *
     * @param root
     * @param res
     */
    private void dfsByIterate(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        left.add(root);
        while (!left.isEmpty() || !right.isEmpty()) {
            while (!left.isEmpty()) {
                TreeNode cur = left.removeLast();
                right.add(cur);
                // 把所有左节点加入
                if (cur.left != null) {
                    left.add(cur.left);
                }
            }
            if (!right.isEmpty()) {
                TreeNode cur = right.removeLast();
                res.add(cur.val);
                if (cur.right != null) {
                    left.add(cur.right);
                }
            }
        }
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
