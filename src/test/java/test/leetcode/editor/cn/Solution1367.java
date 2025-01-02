package test.leetcode.editor.cn;
// 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
//
// 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 
//。 
//
// 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
// null,1,3]
// 输出：true
// 解释：树中蓝色的节点构成了与链表对应的子路径。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
// null,1,3]
// 输出：true
// 
//
// 示例 3： 
//
// 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
// null,1,3]
// 输出：false
// 解释：二叉树中不存在一一对应链表的路径。
// 
//
// 
//
// 提示： 
//
// 
// 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。 
// 链表包含的节点数目在 1 到 100 之间。 
// 二叉树包含的节点数目在 1 到 2500 之间。 
// 
//
// Related Topics 树 深度优先搜索 链表 二叉树 👍 199 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution1367 {
    Solution solution = new Solution();

    @Test
    public void test() {
        TreeNode root = TreeUnit.initTreeNode(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3);
        ListNode head = ListNode.getListNodeFromArray(new int[]{4, 2, 8});
        Assertions.assertTrue(solution.isSubPath(head, root));
        // root = TreeUnit.initTreeNode(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3);
        head = ListNode.getListNodeFromArray(new int[]{1, 4, 2, 6});
        Assertions.assertTrue(solution.isSubPath(head, root));
        head = ListNode.getListNodeFromArray(new int[]{1, 4, 2, 6, 8});
        Assertions.assertFalse(solution.isSubPath(head, root));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 使用层序遍历，并且将每层分割出来，
         * <p>
         * 如何head的首节点在某一层中，则下一层开始匹配head中的下一个节点
         *
         * @param head
         * @param root
         * @return
         */
        public boolean isSubPath(ListNode head, TreeNode root) {
            // return subPathOne(head, root);
            if (root == null) {
                return false;
            }
            return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }

        /**
         * 深度遍历树，同时比较head
         *
         * @param root
         * @param head
         * @return
         */
        private boolean dfs(TreeNode root, ListNode head) {
            if (root == null) {
                return false;
            }
            if (root.val != head.val) {
                return false;
            }
            if (head.next == null) {
                return true;
            }
            return dfs(root.left, head.next) || dfs(root.right, head.next);
        }

        private boolean subPathOne(ListNode head, TreeNode root) {
            List<List<Integer>> paths = new ArrayList<>();
            dfs(root, new ArrayList<>(), paths);
            paths.sort(Comparator.comparingInt(List::size));
            List<Integer> headVal = new ArrayList<>();
            headVal.add(head.val);
            while (head.next != null) {
                head = head.next;
                headVal.add(head.val);
            }
            for (List<Integer> path : paths) {
                if (path.size() < headVal.size()) {
                    continue;
                }
                for (int i = 0; i <= path.size() - headVal.size(); i++) {
                    if (path.get(i).equals(headVal.get(0))) {
                        if (path.subList(i, i + headVal.size()).equals(headVal)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private void dfs(TreeNode root, List<Integer> list, List<List<Integer>> paths) {
            list.add(root.val);
            if (root.left != null) {
                dfs(root.left, list, paths);
            }
            if (root.right != null) {
                dfs(root.right, list, paths);
            }
            if (root.right == null && root.left == null) {
                paths.add(List.copyOf(list));
            }
            list.removeLast();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}

