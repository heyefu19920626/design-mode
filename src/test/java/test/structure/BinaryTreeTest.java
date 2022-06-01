package test.structure;

import org.junit.jupiter.api.Test;
import structure.tree.BinaryTree;

/**
 * Description:
 * <p>
 * 二叉树测试.
 *
 * @author heyefu
 * Create in: 2020-03-31
 * Time: 上午11:08
 **/
public class BinaryTreeTest {


    @Test
    public void preOrderTraversing() {
        BinaryTree tree = BinaryTree.getCompleteBinaryTree(3);
        tree.preOrderTraverse(tree.getRoot());
    }

    @Test
    public void inOrderTraversing() {
        BinaryTree tree = BinaryTree.getCompleteBinaryTree(3);
        tree.inOrderTraverse(tree.getRoot());
    }

    @Test
    public void postOrderTraversing() {
        BinaryTree tree = BinaryTree.getCompleteBinaryTree(4);
        tree.postOrderTraverse(tree.getRoot());
    }

    @Test
    public void inThreadBinaryTree() {
        BinaryTree tree = BinaryTree.getCompleteBinaryTree(3);
        tree.inOrderTraverse(tree.getRoot());
        System.out.println();
        tree.getInThreadBinTree(tree.getRoot());
        tree.inOrderTraverse(tree.getRoot());
        System.out.println();
        tree.inThreadBinaryTreeTraverse(tree.getRoot());
    }
}
