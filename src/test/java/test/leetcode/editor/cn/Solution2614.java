package test.leetcode.editor.cn;

import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree-ii/description/">题目</a>
 *
 * @since 2024/2/7
 **/
public class Solution2614 {
    @Test
    void test() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(5, 4, 9, 1, 10, null, 7));
        Assertions.assertEquals("0,0,0,7,7,11", getString(replaceValueInTree(root)));
        root = TreeUnit.initTreeNode(Arrays.asList(3, 1, 2));
        Assertions.assertEquals("0,0,0", getString(replaceValueInTree(root)));
    }

    private String getString(TreeNode root) {
        return TreeUnit.bfs(root).stream().map(TreeNode::getVal).map(Object::toString).collect(Collectors.joining(","));
    }

    /**
     * 思路：
     * <p>
     * 因为是计算每个节点对应层的非兄弟节点的和, 可以先计算本层的节点和，减去自己本身以及亲兄弟节点的值, 得到的值即为堂兄弟的和
     * <p>
     * 因为要算本层的节点，所有需要使用层序遍历, 并区分每层，因为要算自己与亲兄弟节点的值，所以要区分父节点
     *
     * @param root 根节点
     * @return 计算完成之后的节点
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        List<List<TreeNode>> bfs = new ArrayList<>();
        List<TreeNode> firstTier = new ArrayList<>();
        firstTier.add(root);
        firstTier.add(null);
        bfs.add(firstTier);
        while (!bfs.isEmpty()) {
            List<TreeNode> curTier = bfs.removeFirst();
            List<TreeNode> nextTier = new ArrayList<>();
            // 每层的总和
            int total = 0;
            // 遍历添加下一层
            for (int i = 0; i < curTier.size(); i++) {
                TreeNode cur = curTier.get(i);
                if (cur == null) {
                    continue;
                }
                total += cur.val;
                if (cur.left != null) {
                    nextTier.add(cur.left);
                }
                if (cur.right != null) {
                    nextTier.add(cur.right);
                }
                //  换父节点之后, 添加一个null
                nextTier.add(null);
            }
            if (!nextTier.isEmpty()) {
                bfs.add(nextTier);
            }
            for (int i = 0; i < curTier.size(); i++) {
                TreeNode cur = curTier.get(i);
                if (cur == null) {
                    continue;
                }
                // i+1肯定存在
                TreeNode next = curTier.get(i + 1);
                int brother = cur.val;
                if (next != null) {
                    brother += next.val;
                    next.val = total - brother;
                }
                cur.val = total - brother;
                // 因为获取了兄弟节点, 不要重复遍历
                i++;
            }
        }
        return root;
    }
}
