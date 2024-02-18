package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/">N 叉树的前序遍历</a>
 *
 * @since 2024/2/18
 **/
public class Solution589 {
    /**
     * 前序遍历，即先根节点再左节点，再右节点,可以采用dfs, N叉树的遍历与二叉树基本一样
     * <p>
     * 方式一： 采用递归
     * 方式二： 采用迭代
     *
     * @param root 跟节点
     * @return 结果
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // dfs(root, res);
        dfsByIterate(root, res);
        return res;
    }

    /**
     * 采用迭代的方式进行深度遍历
     * <p>
     * 需要使用栈, 用栈将根节点压入栈，遍历的时候，从栈顶弹出元素，并将该元素的子元素按照从右到左的顺序压入栈中
     *
     * @param root 跟节点
     * @param res 结果存储的列表
     */
    private void dfsByIterate(Node root, List<Integer> res) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            if (cur.children != null && !cur.children.isEmpty()) {
                int size = cur.children.size();
                for (int i = size - 1; i >= 0; i--) {
                    stack.add(cur.children.get(i));
                }
            }
        }
    }

    private void dfs(Node root, List<Integer> res) {
        res.add(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            root.children.forEach(child -> dfs(child, res));
        }
    }
}
