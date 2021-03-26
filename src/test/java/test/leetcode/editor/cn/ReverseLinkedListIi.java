package test.leetcode.editor.cn;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表


public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode start = new ListNode(1);
        ListNode s2 = new ListNode(2);
        start.next = s2;
        ListNode s3 = new ListNode(3);
        s2.next = s3;
        ListNode s4 = new ListNode(4);
        s3.next = s4;
        ListNode s5 = new ListNode(5);
        s4.next = s5;
        ListNode listNode = solution.reverseBetween(start, 1, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class Solution {
        /**
         * 将需要反转的链表节点看成一个子链表,我们只需要反转子链表即可
         * <p>
         * 用一个pre指针定位left的前一个位置，用一个tempHead表示子链表的头，用一个tempEnd表示子链表的尾
         *
         * @param head
         * @param left
         * @param right
         * @return
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            // 放一个空节点在头上，简单处理边界条件，之后直接返回第二个节点即可
            ListNode temp = new ListNode();
            temp.next = head;
            // 相应的都要加1
            left++;
            right++;
            head = temp;
            int i = 1;
            ListNode oriHead = head;
            // 反转的尾节点
            ListNode tempEnd = null;
            // 反转的头结点
            ListNode tempHead = null;
            // 反转之前的节点
            ListNode pre = null;
            while (head != null) {
                if (i + 1 == left) {
                    // 初始化反转之前的节点
                    pre = head;
                }
                // 结束条件
                if (i > right) {
                    break;
                }
                // 开始反转
                if (left <= i) {
                    if (tempEnd == null) {
                        // 初始化反转的子链表
                        tempEnd = head;
                        tempHead = head;
                    } else {
                        // 反转中间的
                        // 把子链表尾节点指向当前节点的下一个节点
                        tempEnd.next = head.next;
                        // 把当前节点放置为子链表的头结点
                        head.next = tempHead;
                        // 移动子链表的头指针
                        tempHead = head;
                    }
                }
                if (tempEnd != null) {
                    head = tempEnd.next;
                } else {
                    head = head.next;
                }
                i++;
            }
            // 将反转之前的指向子链表的头
            pre.next = tempHead;
            return oriHead.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}