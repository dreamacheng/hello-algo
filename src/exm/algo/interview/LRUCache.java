package exm.algo.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private ListNode head;
    private ListNode tail;
    private final Map<Integer,ListNode> data;
    private final int capacity;

    public LRUCache(int capacity) {
        this.data = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode rest = data.get(key);
        if (rest == null) {
            return -1;
        }
        moveToHead(rest);
        return rest.val;
    }

    public void put(int key, int value) {
        ListNode node = data.get(key);
        if (node == null) {
            if (data.size() >= capacity) {
                removeLast();
            }
            node = new ListNode(key, value);
            addToHead(node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    public void moveToHead(ListNode node) {
        if (node == head) {
            return;
        } else if (node == tail) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = head.prev;
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addToHead(ListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        data.put(node.key, node);
    }

    public void removeLast() {
        data.remove(tail.key);
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}