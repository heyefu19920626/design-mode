package test.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tangan
 * @version [1.0]
 * @since 2023/3/25
 */
public class TreeUnit {

    public static TreeNode initTreeNode(List<Integer> list) {
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
