package test.leetcode.editor.cn;

// 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
// 输入：l1 = [7,2,4,3], l2 = [5,6,4]
// 输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
// 输入：l1 = [2,4,3], l2 = [5,6,4]
// 输出：[8,0,7]
// 
//
// 示例3： 
//
// 
// 输入：l1 = [0], l2 = [0]
// 输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学 👍 625 👎 0


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersIi {
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 反转链表，从后往前计算,使用新链表来存储结果
         * <p>
         * 循环计算,若两位相加大于9，使用temp来保存大于10的首位值
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int temp = 0;
            l1 = reverse(l1);
            l2 = reverse(l2);
            ListNode result = null;
            while (l1 != null || l2 != null || temp != 0) {
                l1 = l1 == null ? new ListNode(0) : l1;
                l2 = l2 == null ? new ListNode(0) : l2;
                int res = l1.val + l2.val + temp;
                ListNode newListNode;
                if (res > 9) {
                    temp = 1;
                    newListNode = new ListNode(res - 10);
                } else {
                    temp = 0;
                    newListNode = new ListNode(res);
                }
                newListNode.next = result;
                result = newListNode;
                l1 = l1.next;
                l2 = l2.next;
            }
            return result;
        }

        private ListNode reverse(ListNode node) {
            ListNode result = node;
            ListNode next = node.next;
            result.next = null;
            while (next != null) {
                ListNode temp = next;
                next = next.next;
                temp.next = result;
                result = temp;
            }
            return result;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    @Test
    void should_return_7807() {
        ListNode result = new Solution().addTwoNumbers(ListNode.getListNodeFromArray(new int[]{7, 2, 4, 3}),
            ListNode.getListNodeFromArray(new int[]{5, 6, 4}));
        Assertions.assertEquals(7, result.val);
        Assertions.assertEquals(8, result.next.val);
        Assertions.assertEquals(0, result.next.next.val);
        Assertions.assertEquals(7, result.next.next.next.val);
        Assertions.assertNull(result.next.next.next.next);
    }

    @Test
    void should_return_0() {
        ListNode result = new Solution().addTwoNumbers(ListNode.getListNodeFromArray(new int[]{0}),
            ListNode.getListNodeFromArray(new int[]{0}));
        Assertions.assertEquals(0, result.val);
        Assertions.assertNull(result.next);
    }

    @Test
    void should_return_10() {
        ListNode result = new Solution().addTwoNumbers(ListNode.getListNodeFromArray(new int[]{5}),
            ListNode.getListNodeFromArray(new int[]{5}));
        Assertions.assertEquals(1, result.val);
        Assertions.assertEquals(0, result.next.val);
        Assertions.assertNull(result.next.next);
    }

    @Test
    void should_return_right_when_input_multi_node() {
        ListNode node = ListNode.getListNodeFromArray(new int[]{5, 1, 2});
        ListNode reverse = new Solution().reverse(node);
        Assertions.assertEquals(2, reverse.val);
        Assertions.assertEquals(1, reverse.next.val);
        Assertions.assertEquals(5, reverse.next.next.val);
        Assertions.assertNull(reverse.next.next.next);
    }

    @Test
    void should_return_right_when_input_multi_single() {
        ListNode node = ListNode.getListNodeFromArray(new int[]{5});
        ListNode reverse = new Solution().reverse(node);
        Assertions.assertEquals(5, reverse.val);
        Assertions.assertNull(reverse.next);
    }
}