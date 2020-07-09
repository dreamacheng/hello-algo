package exm.algo.interview;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 */
public class MinStack {

    MinListNode dummy = new MinListNode(0, null);


    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        MinListNode curr = dummy.next == null ? new MinListNode(x, x) : new MinListNode(x, Math.min(dummy.next.min, x));
        curr.next = dummy.next;
        dummy.next = curr;
    }

    public void pop() {
        if (dummy.next == null) throw new RuntimeException("Fucking Illegal operation!!!");
        MinListNode curr = dummy.next;
        dummy.next = curr.next;
    }

    public int top() {
        if (dummy.next == null) throw new RuntimeException("Fucking Illegal operation!!!");
        return dummy.next.val;
    }

    public int getMin() {
        return dummy.next.min;
    }
}

class MinListNode {
    int val;
    Integer min;
    MinListNode next;
    MinListNode(int val, Integer min) {
        this.val = val;
        this.min = min;
    }
}
