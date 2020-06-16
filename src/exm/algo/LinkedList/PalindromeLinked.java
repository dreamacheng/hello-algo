package exm.algo.LinkedList;

public class PalindromeLinked {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(0);
        a.next.next = new ListNode(1);
        System.out.println(isPalindrome(a));
    }

    /**
     * 请判断一个链表是否为回文链表。
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode prev = null, next = null;
        // 设置快慢指针，快指针走两步，慢指针走一步，慢指针在遍历的过程中翻转链表
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (quick == null || quick.next == null) {
            // 如果节点个数为两个，将prev -> head
            if (slow == head) prev = head;
            // 如果quick不为空，链表为奇数长度，将next指向它的后继
            if (quick != null) next = next.next;
            while (prev != null && next != null) {
                if (prev.val != next.val) {
                    return false;
                }
                prev = prev.next;
                next = next.next;
            }
            return true;
        }
        return false;
    }
}
