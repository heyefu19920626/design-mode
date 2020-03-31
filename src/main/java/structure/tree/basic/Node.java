package structure.tree.basic;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 * <p>
 * 节点.
 *
 * @author heyefu
 * Create in: 2020-03-31
 * Time: 上午10:35
 **/
@Getter
@Setter
public class Node {
    /**
     *节点的数据
     */
    private int data;
    /**
     * 左节点
     */
    private Node left;
    /**
     * 右节点
     */
    private Node right;

    public Node(int data) {
        this.data = data;
    }
}
