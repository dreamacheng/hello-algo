package exm.algo.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(3);
        twoSum(l1, l2);
    }


    /**
     * desc:
     *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * @param arr
     * @return
     */
    public int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = arr.length; i < len; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * desc:
     *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode twoSum(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int flag = 0;
//        ListNode head = null; //优化
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null || l2 != null || flag != 0) {
            int sum = flag;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            ListNode node = new ListNode(sum % 10);
//            if (head == null) {
//                head = node;
//                current = head;
//            } else {
//                current.next = node;
//                current = current.next;
//            }
            // 以上代码优化
            current.next = node;
            current = current.next;
            flag = sum /10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // return head;
        return head.next;
    }

    /**
     * desc:
     *  给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *  你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode twoSum2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || flag != 0) {
//            int temp1 = 0;
//            int temp2 = 0;
//            if (!s1.empty()) {
//                temp1 = s1.pop();
//            }
//            if (!s2.empty()) {
//                temp2 = s2.pop();
//            }
//            int value = (temp1 + temp2 + flag) % 10;
//            ListNode node = new ListNode(value);
//            node.next = head;
//            head = node;
//            flag = (temp1 + temp2 + flag) / 10;
            // 代码优化
            int sum = flag;
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            flag = sum /10;
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

