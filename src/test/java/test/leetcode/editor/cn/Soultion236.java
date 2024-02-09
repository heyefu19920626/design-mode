package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import java.util.Arrays;

/**
 * @author he
 * @since 2024-02.09-19:10
 */
public class Soultion236 {

    @Test
    void test() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        Assertions.assertEquals(3, lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
        root = TreeUnit.initTreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        Assertions.assertEquals(5, lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
        root = TreeUnit.initTreeNode(Arrays.asList(1, 2));
        Assertions.assertEquals(1, lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2)).val);

    }

    @Test
    void test1() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println("==========");
        root = TreeUnit.initTreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
    }

    /**
     * 采用先左后右最后中间的遍历方式, 找到任意一个节点就返回
     * <p>
     * 如果左右子树分别包含p和q，则该节点为最近的父节点
     * <p>
     * 如果左子树或右子树包含p或q，则该节点为最近的父节点？
     *
     * @param root 根节点
     * @param p    要找得节点p
     * @param q    要找到的节点q
     * @return 结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode x = null, y = null;
        if (root.left != null) {
            x = dfs(root.left, p, q);
        }
        if (root.right != null) {
            y = dfs(root.right, p, q);
        }
        if (root.val == p.val) {
            return root;
        }
        if (root.val == q.val) {
            return root;
        }
        if (x != null && y != null) {
            return root;
        }
        if (x != null) {
            return x;
        }
        if (y != null) {
            return y;
        }
        return null;
    }
}
