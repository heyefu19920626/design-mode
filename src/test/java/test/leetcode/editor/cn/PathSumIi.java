//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 934 👎 0

package test.leetcode.editor.cn;

import org.junit.jupiter.api.Test;
import test.leetcode.TreeNode;
import test.leetcode.TreeUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSumIi {
    PathSumIi.Solution solution = new Solution();

    public static

        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int total = 0;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            List<Integer> cur = new ArrayList<>();
            dfs(root, cur, res, targetSum);
            return res;
        }

        private void dfs(TreeNode root, List<Integer> cur, List<List<Integer>> res, int target) {
            cur.add(root.val);
            total += root.val;
            if (root.left != null) {
                dfs(root.left, cur, res, target);
            }
            if (root.right != null) {
                dfs(root.right, cur, res, target);
            }
            if (root.left == null && root.right == null && total == target) {
                res.add(new ArrayList<>(cur));
            }
            cur.remove(cur.size() - 1);
            total -= root.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    @Test
    void should_return_x() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
        List<List<Integer>> res = solution.pathSum(root, 22);
        System.out.println(res);
    }

    @Test
    void should_return_xx() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(1, 2, 3));
        List<List<Integer>> res = solution.pathSum(root, 5);
        System.out.println(res);
    }

    @Test
    void should_return_xx1() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(1, 2, 3));
        List<List<Integer>> res = solution.pathSum(root, 3);
        System.out.println(res);
    }

    @Test
    void should_return_xx12() {
        List<List<Integer>> res = solution.pathSum(null, 1);
        System.out.println(res);
    }

    @Test
    void should_return_xxx() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(1, 2));
        List<List<Integer>> res = solution.pathSum(root, 0);
        System.out.println(res);
    }

    @Test
    void should_return_xxx1() {
        TreeNode root = TreeUnit.initTreeNode(Arrays.asList(1, 2));
        List<List<Integer>> res = solution.pathSum(root, 1);
        System.out.println(res);
    }

}