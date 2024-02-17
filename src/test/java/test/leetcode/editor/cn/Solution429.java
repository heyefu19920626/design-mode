package test.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/">N 叉树的层序遍历</a>
 *
 * @since 2024/2/17
 **/
public class Solution429 {
    /**
     * N叉树的层序遍历，跟二叉树差别不大，二叉树是使用队列来分层存放下一层的左右节点，N叉树存放下一层的所有节点即可，由于返回的是分层的，所以要区分每一层
     *
     * @param root 跟节点
     * @return 结果
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> curLayer = new LinkedList<>();
        curLayer.add(root);
        while (!curLayer.isEmpty()) {
            // 存放下一层的节点
            Queue<Node> nextLayer = new LinkedList<>();
            // 存放当前层的值
            List<Integer> curVal = new ArrayList<>();
            while (!curLayer.isEmpty()) {
                Node cur = curLayer.poll();
                curVal.add(cur.val);
                if (cur.children != null && !cur.children.isEmpty()) {
                    nextLayer.addAll(cur.children);
                }
            }
            res.add(curVal);
            curLayer = nextLayer;
        }
        return res;
    }
}

class Node {
    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};