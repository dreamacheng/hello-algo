package exm.algo.LinkedList;

public class IntersectLinked {

    /**
     *
     * 编写一个程序，找到两个单链表相交的起始节点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            lenA++;
            a = a.next;
        }
        while (b != null) {
            lenB++;
            b = b.next;
        }
        int gap;
        if (lenA > lenB) {
            gap = lenA - lenB;
            for (int i = 0; i < gap; i++) {
                headA = headA.next;
            }
        } else {
            gap = lenB - lenA;
            for (int i = 0; i < gap; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headB;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针： a -> headA, b -> headB, a、b同时向后遍历，当a先走到null时，将 a -> headB, 反之将 b -> headA
     * A和B两个链表长度可能不同，但是A+B和B+A的长度相同，遍历A+B和遍历B+A一定是同时结束。
     * 如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     * 大佬的代码
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
