package test.leetcode.editor.cn;

/**
 * //给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * //
 * // 你应当保留两个分区中每个节点的初始相对位置。
 * //
 * //
 * //
 * // 示例：
 * //
 * //
 * //输入：head = 1->4->3->2->5->2, x = 3
 * //输出：1->2->2->4->3->5
 * //
 * // Related Topics 链表 双指针
 */
class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(2);
        ListNode result = solution.partition(root, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    class Solution {
        /**
         * 将所有小于x的节点取出，然后需要对小于x的节点进行排序,最后将排序后的节点放到原始节点的开头
         * <p>
         * 此题理解有误，不应该对小于x的节点进行排序
         *
         * @param head 头结点
         * @param x    特定值
         * @return 新链表
         */
        public ListNode partition(ListNode head, int x) {
            ListNode root = head;
            ListNode less = null;
            while (head != null && head.val < x) {
                ListNode tmp = head;
                head = head.next;
                root = head;
                // less = addLessEle(less, tmp);
                less = addLessEleNoOder(less, tmp);
            }
            if (head == null) {
                return less;
            }
            while (head.next != null) {
                ListNode tmp = head.next;
                ListNode tmpNext = tmp.next;
                if (head.next.val < x) {
                    // less = addLessEle(less, head.next);
                    less = addLessEleNoOder(less, head.next);
                    head.next = tmpNext;
                } else {
                    head = tmp;
                }
            }
            if (less == null) {
                return root;
            }
            lessLast.next = root;
            ListNode lessHead = less;
            // while (less.next != null) {
            //     less = less.next;
            // }
            // less.next = root;
            return lessHead;
        }

        private ListNode lessLast;

        private ListNode addLessEleNoOder(ListNode less, ListNode ele) {
            // less为空
            if (less == null) {
                ele.next = null;
                lessLast = ele;
                return ele;
            }
            lessLast.next = ele;
            lessLast = ele;
            ele.next = null;
            return less;
        }

        private ListNode addLessEle(ListNode less, ListNode ele) {
            // less为空
            if (less == null) {
                ele.next = null;
                return ele;
            }
            // less的首个元素就大于新元素，新元素放开头
            if (less.val > ele.val) {
                ele.next = less;
                return ele;
            }
            // 保留头结点
            ListNode head = less;
            // 只要less的下个元素小于新元素，就移动less的指针
            while (less.next != null && less.next.val < ele.val) {
                less = less.next;
            }
            ele.next = less.next;
            less.next = ele;
            return head;
        }
    }
}