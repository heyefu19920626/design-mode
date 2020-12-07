package test.leetcode.editor.cn;

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView test = new BinaryTreeRightSideView();
        Solution solution = new BinaryTreeRightSideView().new Solution();
        TreeNode treeNode = test.getTree(1, 2, 3, null, 5, null, 4);
        for (Integer integer : solution.rightSideView(treeNode)) {
            System.out.println(integer);
        }
        solution.bfs(treeNode);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        Queue<LinkedList<TreeNode>> beforeView = new LinkedList<>();

        /**
         * 只保留最右边的节点
         *
         * @param root 根节点
         * @return 最右边的节点列表
         */
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> list = new LinkedList();
            list.add(root);
            beforeView.add(list);
            List<Integer> right = new LinkedList<>();
            right.add(root.val);
            while (!beforeView.isEmpty()) {
                LinkedList<TreeNode> willT = beforeView.poll();
                LinkedList<TreeNode> willAdd = new LinkedList<>();
                while (!willT.isEmpty()) {
                    final TreeNode treeNode = willT.removeFirst();
                    if (treeNode.left != null) {
                        willAdd.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        willAdd.add(treeNode.right);
                    }
                }
                if (!willAdd.isEmpty()) {
                    beforeView.add(willAdd);
                    right.add(willAdd.getLast().val);
                }
            }
            return right;
        }

        StringBuilder path = new StringBuilder();
        // 已遍历过的
        LinkedList<TreeNode> after = new LinkedList<>();
        // 将要遍历的
        LinkedList<TreeNode> before = new LinkedList<>();

        /**
         * 标准bfs
         *
         * @param root 根节点
         */
        public void bfs(TreeNode root) {
            before.add(root);
            while (!before.isEmpty()) {
                final TreeNode treeNode = before.removeFirst();
                after.add(treeNode);
                if (treeNode.left != null) {
                    before.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    before.add(treeNode.right);
                }
            }
            for (TreeNode treeNode : after) {
                path.append(treeNode.val);
            }
            System.out.println(path);
        }
    }

    /**
     * 生成二叉树
     *
     * @param a 所有节点
     * @return 返回值
     */
    public TreeNode getTree(Integer... a) {
        TreeNode root = new TreeNode(a[0]);
        LinkedList<TreeNode> will = new LinkedList<>();
        will.add(root);
        int i = 1;
        while (i < a.length) {
            final TreeNode treeNode = will.removeFirst();
            if (treeNode == null) {
                continue;
            }
            if (a[i] == null) {
                treeNode.left = null;
            } else {
                treeNode.left = new TreeNode(a[i]);
            }
            will.add(treeNode.left);
            i++;
            if (i >= a.length) {
                break;
            }
            if (a[i] == null) {
                treeNode.right = null;
            } else {
                treeNode.right = new TreeNode(a[i]);
            }
            will.add(treeNode.right);
            i++;
        }
        return root;
    }
}