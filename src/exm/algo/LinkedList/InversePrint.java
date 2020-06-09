package exm.algo.LinkedList;

import java.util.Stack;

public class InversePrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        inversePrint2(head);
    }

    /**
     * 逆序打印链表，递归
     * @param head
     */
    public static void inversePrint(ListNode head) {
        if (head == null) {
            return;
        }
        inversePrint(head.next);
        System.out.println(head.val);
    }

    /**
     * 利用stack逆序
     * @param head
     */
    public static void inversePrint2(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }

}
