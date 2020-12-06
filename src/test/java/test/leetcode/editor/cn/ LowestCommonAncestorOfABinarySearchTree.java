package test.leetcode.editor.cn;

import java.util.Stack;

/**
 * 235: 二叉搜索树的最近公共祖先
 * <p>
 * 二叉搜索树: 左节点永远比根节点小,根节点比右节点小
 */
class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree test = new LowestCommonAncestorOfABinarySearchTree();
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(6);
        TreeNode result = solution.lowestCommonAncestor(test.getTree(), p, q);
        System.out.println(result.val);
    }

    class Solution {
        private boolean find = false;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode back = root;
            // 先使用dfs求最短路径,然后再取最后一个重复的节点
            Stack<TreeNode> ps = new Stack<>();
            dfs(root, p, ps);
            find = false;
            Stack<TreeNode> qs = new Stack<>();
            dfs(back, q, qs);
            int len = Math.min(ps.size(), qs.size());
            for (int i = 0; i < len; i++) {
                if (ps.get(i).val != qs.get(i).val) {
                    return ps.get(i - 1);
                }
            }
            if (ps.size() > qs.size()) {
                return qs.pop();
            } else {
                return ps.pop();
            }
        }

        private void dfs(TreeNode root, TreeNode p, Stack<TreeNode> shortPath) {
            if (find || root == null) {
                return;
            }
            shortPath.push(root);
            if (root.val == p.val) {
                find = true;
                return;
            }
            dfs(root.left, p, shortPath);
            dfs(root.right, p, shortPath);
            if (!find) {
                shortPath.pop();
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode getTree() {
        TreeNode root = new TreeNode(0);
        TreeNode l_1 = new TreeNode(1);
        root.left = l_1;
        TreeNode r_1 = new TreeNode(2);
        root.right = r_1;

        TreeNode l_2 = new TreeNode(3);
        root.left.left = l_2;
        TreeNode l_3 = new TreeNode(4);
        root.left.right = l_3;

        TreeNode r_2 = new TreeNode(5);
        root.right.left = r_2;
        TreeNode r_3 = new TreeNode(6);
        root.right.right = r_3;
        return root;
    }

}