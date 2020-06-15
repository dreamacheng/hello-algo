package exm.algo.LinkedList;


public class JudgeRing {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        System.out.println(hasCycle(a));
    }

    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode quick = head;
        do{
            slow = slow.next;
            if (quick == null || quick.next == null) return false;
            quick = quick.next.next;
        } while (quick != slow);
        return quick == null ? false : true;
    }

    /**
     * 返回链表入环的第一个节点，无环则返回null
     * 双指针
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode quick = head;
        do{
            slow = slow.next;
            if (quick == null || quick.next == null) return null;
            quick = quick.next.next;
        } while (quick != slow);
        while (quick != null &&head != quick) {
            head = head.next;
            quick = quick.next;
        }
        return quick;
    }
}
