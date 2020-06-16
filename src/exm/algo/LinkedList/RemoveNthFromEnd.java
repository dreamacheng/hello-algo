package exm.algo.LinkedList;

public class RemoveNthFromEnd {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 双指针，dummy节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (n > 0) {
            first = first.next;
            n--;
        }
        while (first != null && first.next != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
