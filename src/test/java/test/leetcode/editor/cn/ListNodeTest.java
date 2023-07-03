package test.leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListNodeTest {
    @Test
    @DisplayName("当使用数组初始化节点时返回正确")
    void should_return_right_node_when_use_array() {
        ListNode result = ListNode.getListNodeFromArray(new int[]{5, 1, 2, 3});
        Assertions.assertEquals(5, result.val);
        Assertions.assertEquals(1, result.next.val);
        Assertions.assertEquals(2, result.next.next.val);
        Assertions.assertEquals(3, result.next.next.next.val);
        Assertions.assertNull(result.next.next.next.next);
    }
}