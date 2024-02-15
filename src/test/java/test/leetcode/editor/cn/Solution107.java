package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/">题目</a>
 *
 * @author he
 * @since 2024-02.15-22:11
 */
public class Solution107 {
    @Test
    void test() {
        System.out.println();
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(3, 9, 20, null, null, 15, 7));
        Assertions.assertEquals("[[15,7],[9,20],[3]]", levelOrderBottom(root).toString().replace(" ", ""));
        root = TreeUnit.initTreeNode(Arrays.asList(1));
        Assertions.assertEquals("[[1]]", levelOrderBottom(root).toString().replace(" ", ""));
        Assertions.assertEquals("[]", levelOrderBottom(null).toString().replace(" ", ""));
    }

    /**
     * 先进行正常的bfs, 但需要分割存储每一层的节点，进行遍历
     *
     * @param root 根节点
     * @return 结果
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> curLayer = new ArrayList<>();
        curLayer.add(root);
        while (!curLayer.isEmpty()) {
            List<TreeNode> nextLayer = new ArrayList<>();
            List<Integer> curVal = new ArrayList<>();
            while (!curLayer.isEmpty()) {
                TreeNode cur = curLayer.removeFirst();
                if (cur == null) {
                    continue;
                }
                curVal.add(cur.val);
                if (cur.left != null) {
                    nextLayer.add(cur.left);
                }
                if (cur.right != null) {
                    nextLayer.add(cur.right);
                }
            }
            if (!curVal.isEmpty()) {
                res.add(curVal);
            }
            curLayer = nextLayer;
        }
        return res.reversed();
    }
}
