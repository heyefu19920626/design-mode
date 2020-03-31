package structure.tree;

import lombok.Getter;
import lombok.Setter;
import structure.tree.basic.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * 二叉树.
 *
 * @author heyefu
 * Create in: 2020-03-31
 * Time: 上午10:33
 **/
@Getter
@Setter
public class BinaryTree {
    /**
     * 根节点
     */
    private Node root;

    private BinaryTree() {

    }

    /**
     * Description:
     * <p>
     * 根据层数获取完全二叉树.
     *
     * @param layer 层数，需要大于0
     * @return structure.tree.BinaryTree
     * @author heyefu 上午10:52 2020/3/31
     **/
    public static BinaryTree getCompleteBinaryTree(int layer) {
        BinaryTree tree = new BinaryTree();
        if (layer <= 0) {
            return tree;
        }
        //节点总数
        int total = (int) (Math.pow(2, layer) - 1);
        List<Node> nodes = new ArrayList<>(total);
        //初始化根节点
        Node root = new Node(1);
        nodes.add(root);

        //初始化其余节点
        for (int i = 2; i <= total; i++) {
            //新建节点
            Node node = new Node(i);
            //找寻父亲节点
            int parent = i / 2 - 1;
            //看该节点是左孩子还是右孩子
            if (i % 2 == 0) {
                nodes.get(parent).setLeft(node);
            } else {
                nodes.get(parent).setRight(node);
            }
            nodes.add(node);
        }
        tree.setRoot(root);
        return tree;
    }

    /**
     * Description:
     * <p>
     * 前序遍历二叉树.
     *
     * @author heyefu 上午10:57 2020/3/31
     **/
    public void preTraversing(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preTraversing(node.getLeft());
        preTraversing(node.getRight());
    }

    /**
     * Description:
     * <p>
     * 中序遍历二叉树
     *
     * @param node 根节点
     * @author heyefu 上午11:19 2020/3/31
     **/
    public void midTraversing(Node node) {
        if (node == null) {
            return;
        }
        midTraversing(node.getLeft());
        System.out.print(node.getData() + " ");
        midTraversing(node.getRight());
    }

    /**
     * Description:
     * <p>
     * 后序遍历二叉树.
     *
     * @param node 根节点
     * @author heyefu 上午11:24 2020/3/31
     **/
    public void postTraversing(Node node) {
        if (node == null) {
            return;
        }

        postTraversing(node.getLeft());
        postTraversing(node.getRight());
        System.out.print(node.getData() + " ");
    }
}
