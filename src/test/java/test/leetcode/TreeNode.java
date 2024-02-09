package test.leetcode;

import lombok.Getter;

/**
 * @author tangan
 * @version [1.0]
 * @since 2023/3/25
 */
@Getter
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
