package exm.algo.LinkedList;

public class ReverseBetween {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // 利用dummy节点处理特殊情况，遍历链表找到第m个节点的前驱节点
        for (int i = 1; i < m && prev != null; i++) {
            prev = prev.next;
        }
        ListNode curr  = prev.next;
        ListNode pre = null;
        // 顺序遍历翻转
        for (int i = m; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 拼接链表
        prev.next.next = curr;
        prev.next = pre;
        return dummy.next;
    }
}
