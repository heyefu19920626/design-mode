package test.leetcode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @since 2020/5/14
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(l1, l2);
        solution.print(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp1, temp2;
        ListNode result;
        if (l1.val > l2.val) {
            temp1 = l1;
            l1 = l2;
            l2 = temp1;
        }
        result = l1;
        while (l1 != null && l2 != null) {
            while (l2 != null) {
                if (l1.val <= l2.val) {
                    if (l1.next == null) {
                        l1.next = l2;
                        l2 = null;
                        break;
                    } else if (l2.val <= l1.next.val) {
                        temp1 = l1.next;
                        l1.next = l2;
                        temp2 = l2.next;
                        l2.next = temp1;
                        l2 = temp2;
                    } else {
                        l1 = l1.next;
                        System.out.println(l1.val + "  " + l2.val);
                    }
                } else {
                    break;
                }
            }
            l1 = l1.next;
        }

        return result;
    }

    public void print(ListNode listNode) {
        while (listNode != null) {
            System.out.printf(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}