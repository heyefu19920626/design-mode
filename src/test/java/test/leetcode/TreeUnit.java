package test.leetcode;

import java.util.*;

/**
 * @author tangan
 * @version [1.0]
 * @since 2023/3/25
 */
public class TreeUnit {
    /**
     * 以层序遍历二叉树
     *
     * @param root 二叉树的根节点
     * @return 层序遍历的顺序
     */
    public static List<TreeNode> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.add(poll);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return res;
    }

    public static TreeNode initTreeNode(Integer... params) {
        return initTreeNode(Arrays.asList(params));
    }

    /**
     * 初始化二叉树
     *
     * @param list 二叉树的元素，以层序输入，不存在的位为null
     * @return 二叉树的根节点
     */
    public static TreeNode initTreeNode(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        root.val = list.get(0);
        queue.add(root);
        int i = 1;
        while (i < list.size()) {
            TreeNode point = queue.poll();
            Integer cur = list.get(i);
            if (cur != null) {
                point.left = new TreeNode();
                point.left.val = cur;
                queue.add(point.left);
            }
            i++;
            if (i >= list.size()) {
                continue;
            }
            cur = list.get(i);
            if (cur != null) {
                point.right = new TreeNode();
                point.right.val = cur;
                queue.add(point.right);
            }
            i++;
        }
        return root;
    }
}
