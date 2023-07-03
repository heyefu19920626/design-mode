//有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 
//n 各不相同。 
//
// 最开始时： 
//
// 
// 「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）； 
// 「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。 
// 
//
// 「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。 
//
// 之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「
//一号」玩家染红色，「二号」玩家染蓝色）。 
//
// 如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。 
//
// 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。 
//
// 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。 
// 
//
// 示例 1 ： 
//
// 
//输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
//输出：true
//解释：第二个玩家可以选择值为 2 的节点。 
//
// 示例 2 ： 
//
// 
//输入：root = [1,2,3], n = 3, x = 1
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目为 n 
// 1 <= x <= n <= 100 
// n 是奇数 
// 1 <= Node.val <= n 
// 树中所有值 互不相同 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 199 👎 0

package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeColoringGame {
    public static
        //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 一号玩家选定的点为x, 将x移除，统计剩余子树的节点数量，如果存在某一个子树的节点数量大于其余子树的节点数量+1,则可以获胜
         * <p>
         * 1. 先找到节点x
         * 2. 以x分割子树
         * 3. 统计各个子树的节点数量
         * 4. 判断结果： 1. 如果存在某一个子树的节点数量大于其余子树的节点数量+1,则可以获胜；否则不能获胜
         * <p>
         * 因为给出n，所以可以遍历一遍即可：找到x节点，然后根据x的子树所包含的节点，计算x的父亲树的节点，再判断即可
         *
         * @param root 根节点
         * @param n    总节点数量
         * @param x    一号玩家选定的点
         * @return 结果
         */
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            List<TreeNode> subTree = splitTreeByValue(root, x);
            List<Integer> nums = new ArrayList<>();
            for (TreeNode treeNode : subTree) {
                nums.add(computeNum(treeNode));
            }
            if (nums.size() == 1) {
                return true;
            }
            if (nums.size() == 2) {
                return Math.abs(nums.get(0) - nums.get(1)) > 1;
            }
            if (nums.get(0) + nums.get(1) + 1 < nums.get(2)) {
                return true;
            } else if (nums.get(1) + nums.get(2) + 1 < nums.get(0)) {
                return true;
            } else {
                return nums.get(0) + nums.get(2) + 1 < nums.get(1);
            }
        }

        private int computeNum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int num = 0;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                num++;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            return num;
        }

        private List<TreeNode> splitTreeByValue(TreeNode root, int value) {
            List<TreeNode> subTree = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.val == value) {
                    splitLeftAndRightTree(subTree, cur);
                    return subTree;
                }
                if (cur.left != null) {
                    if (cur.left.val == value) {
                        subTree.add(root);
                        splitLeftAndRightTree(subTree, cur.left);
                        cur.left = null;
                        return subTree;
                    }
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    if (cur.right.val == value) {
                        subTree.add(root);
                        splitLeftAndRightTree(subTree, cur.right);
                        cur.right = null;
                        return subTree;
                    }
                    queue.add(cur.right);
                }
            }
            return subTree;
        }

        private void splitLeftAndRightTree(List<TreeNode> subTree, TreeNode cur) {
            if (cur.left != null) {
                subTree.add(cur.left);
                cur.left = null;
            }
            if (cur.right != null) {
                subTree.add(cur.right);
                cur.right = null;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}