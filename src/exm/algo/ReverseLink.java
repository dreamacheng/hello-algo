package exm.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * 反转单向链表
 * 三种常见实现
 */
public class ReverseLink {

    /**
     * 顺序反转
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 使用stack完成反转
     * @param head
     * @return
     */
    public static Node reverse1(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        Node newHead = stack.pop();
        head = newHead;
        while (!stack.empty()){
            head.next = stack.pop();
            head = head.next;
        }
        head.next = null;
        return newHead;
    }

    /**
     * 递归实现
     *
     * What is the reverse of null (the empty list)? null.
     * What is the reverse of a one element list? the element.
     * What is the reverse of an n element list? the reverse of the rest of the list followed by the first element.
     * https://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
     * @param head
     * @return
     */
    public static Node reverse2(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node secondNode = head.next;
        head.next = null;
        Node node = reverse2(secondNode);
        secondNode.next = head;
        return node;
    }
}

class Node{
    int data;
    Node next;
}
