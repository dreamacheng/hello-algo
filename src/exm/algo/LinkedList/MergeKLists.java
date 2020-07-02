package exm.algo.LinkedList;

/**
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    public static void main(String[] args) {
        ListNode l1 = null;
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);
        ListNode l3 = new ListNode(-9);
        l3.next = new ListNode(7);
        l3.next.next = new ListNode(9);
        ListNode l4 = null;
        ListNode[] lists = {l1, l2 ,l3, l4};
        ListNode ret = mergeKLists(lists);
        System.out.println(ret);
    }

    // 归并 合并链表
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        return mergeHelper(lists, 0 , lists.length - 1);
    }

    public static ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];
        int mid = start + (end - start >>> 1);
        return mergeTwoLists(mergeHelper(lists, start ,mid), mergeHelper(lists, mid + 1, end));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode recurs = dummy;
        while (l1 != null && l2 != null) {
            recurs.next = l1.val > l2.val ? l2 : l1;
            recurs = recurs.next;
            if (l1.val > l2.val) {
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
        }
        recurs.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {

    }
}
