package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">题目</a>
 *
 * @author he
 * @since 2024-02.16-09:23
 */
public class Solution103 {

    @Test
    void test() {
        TreeNode root = TreeUnit.initTreeNode(3, 9, 20, null, null, 15, 7);
        Assertions.assertEquals("[[3],[20,9],[15,7]]", zigzagLevelOrder(root).toString().replaceAll(" ", ""));
        root = TreeUnit.initTreeNode(1);
        Assertions.assertEquals("[[1]]", zigzagLevelOrder(root).toString().replaceAll(" ", ""));
        Assertions.assertEquals("[]", zigzagLevelOrder(null).toString().replaceAll(" ", ""));
    }

    /**
     * 层序遍历，需要记录每一层的元素，第一层为从左到右，第二层为从右到左，第三层为从左到右...
     * <p>
     * 可以统一都从左至右遍历，存结果的时候将对应的结果翻转即可
     *
     * @param root 根节点
     * @return 结果
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean leftToRight = true;
        // 当前层
        List<TreeNode> curLayer = new ArrayList<>();
        curLayer.add(root);
        while (!curLayer.isEmpty()) {
            List<TreeNode> nextLayer = new ArrayList<>();
            List<Integer> curRes = new ArrayList<>();
            while (!curLayer.isEmpty()) {
                TreeNode cur = curLayer.removeFirst();
                if (leftToRight) {
                    curRes.add(cur.val);
                }else {
                    curRes.addFirst(cur.val);
                }
                if (cur.left != null) {
                    nextLayer.add(cur.left);
                }
                if (cur.right != null) {
                    nextLayer.add(cur.right);
                }
            }
            curLayer = nextLayer;
            if (curRes.isEmpty()) {
                leftToRight = !leftToRight;
                continue;
            }
            res.add(curRes);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
