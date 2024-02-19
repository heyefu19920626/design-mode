/*
 * Copyright (c) TangAn Technologies Co., Ltd. 2023-2023. All rights reserved.
 */

package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description">N 叉树的后序遍历</a>
 *
 * @author TangAn
 * @version 0.1
 * @since 2024/2/19
 */
public class Solution590 {
    /**
     * N叉树的遍历与二叉树的遍历差别不大
     * <p>
     * 后续遍历指，先左后右，最后中间, 可以使用dfs
     * <p>
     * 可以使用递归与迭代
     *
     * @param root 根节点
     * @return 结果
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // dfs(root, res);
        dfsByIterator(root, res);
        return res;
    }

    /**
     * 使用迭代实现N叉树的dfs
     * <p>
     * 使用栈来存储节点，遍历时先将当前节点放入栈中，如果该元素存在子元素，则将其子元素从右至左加入栈中, 否则弹出该元素，为了避免重复，需要判断该元素是否已经遍历
     *
     * @param root 根节点
     * @param res  结果存储
     */
    private void dfsByIterator(Node root, List<Integer> res) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if (cur.children == null || cur.children.isEmpty()) {
                stack.pop();
                res.add(cur.val);
            } else {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
                cur.children = null;
            }
        }
    }

    private void dfs(Node root, List<Integer> res) {
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                dfs(child, res);
            }
        }
        res.add(root.val);
    }
}
