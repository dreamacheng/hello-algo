package exm.algo.interview;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * 添加元素时，直接添加至s1；
 * 删除元素时，若s2不为空，直接移除栈顶元素
 *             若s2为空，则将s1的元素pop到s2，再移除栈顶元素
 */
public class CQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        if (s1.isEmpty()) return -1;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }
}
