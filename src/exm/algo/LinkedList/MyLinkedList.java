package exm.algo.LinkedList;

public class MyLinkedList {

    /**
     * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
     *
     * @param args
     */
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(6);
    }

    ListNode head;

    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode p = head;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode p = new ListNode(val);
            p.next = head;
            head = p;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode p = head;
            for (int i = 1; i < size; i++) {
                p = p.next;
            }
            p.next = new ListNode(val);
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        }
        ListNode p = head;
        ListNode node = new ListNode(val);
        while (index > 1) {
            p = p.next;
            index--;
        }
        node.next = p.next;
        p.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            ListNode p = head;
            while (index > 1) {
                p = p.next;
                index--;
            }

            p.next = p.next.next;
        }
        size--;
    }
}

