package test.structure;

import org.junit.Test;
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
    public void preTraversing() {
        BinaryTree tree = BinaryTree.getCompleteBinaryTree(3);
        tree.preTraversing(tree.getRoot());
    }

    @Test
    public void midTraversing() {
        BinaryTree tree = BinaryTree.getCompleteBinaryTree(3);
        tree.midTraversing(tree.getRoot());
    }

    @Test
    public void postTraversing() {
        BinaryTree tree = BinaryTree.getCompleteBinaryTree(4);
        tree.postTraversing(tree.getRoot());
    }
}
