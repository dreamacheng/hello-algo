package exm.algo.LinkedList;

public class RemoveAllTarget {

    /**
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * 利用dummy避免删除头节点特殊处理
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
