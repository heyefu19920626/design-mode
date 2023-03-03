package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class BinaryTreeColoringGameTest {
    BinaryTreeColoringGame.Solution solution = new BinaryTreeColoringGame.Solution();

    @Test
    void should_return_true() {
        BinaryTreeColoringGame.TreeNode root = initTreeNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        Assertions.assertTrue(solution.btreeGameWinningMove(root, 11, 3));
    }

    @Test
    void should_return_false_1() {
        BinaryTreeColoringGame.TreeNode root = initTreeNode(Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertFalse(solution.btreeGameWinningMove(root, 5, 2));
    }

    @Test
    void should_return_false() {
        BinaryTreeColoringGame.TreeNode root = initTreeNode(Arrays.asList(1, 2, 3));
        Assertions.assertFalse(solution.btreeGameWinningMove(root, 3, 1));
    }

    @Test
    void should_return_true_1() {
        BinaryTreeColoringGame.TreeNode root = initTreeNode(Arrays.asList(1, 2, 3));
        Assertions.assertTrue(solution.btreeGameWinningMove(root, 3, 2));
    }

    @Test
    void should_return_false_xx() {
        BinaryTreeColoringGame.TreeNode root = initTreeNode(
            Arrays.asList(5, 9, 6, null, null, 7, null, null, 8, 1, 4, null, null, null, 3, null, 2));
        Assertions.assertFalse(solution.btreeGameWinningMove(root, 9, 8));
    }


    BinaryTreeColoringGame.TreeNode initTreeNode(List<Integer> list) {
        Queue<BinaryTreeColoringGame.TreeNode> queue = new LinkedList<>();
        BinaryTreeColoringGame.TreeNode root = new BinaryTreeColoringGame.TreeNode();
        root.val = list.get(0);
        queue.add(root);
        int i = 1;
        while (i < list.size()) {
            BinaryTreeColoringGame.TreeNode point = queue.poll();
            Integer cur = list.get(i);
            if (cur != null) {
                point.left = new BinaryTreeColoringGame.TreeNode();
                point.left.val = cur;
                queue.add(point.left);
            }
            i++;
            if (i >= list.size()) {
                continue;
            }
            cur = list.get(i);
            if (cur != null) {
                point.right = new BinaryTreeColoringGame.TreeNode();
                point.right.val = cur;
                queue.add(point.right);
            }
            i++;
        }
        return root;
    }
}