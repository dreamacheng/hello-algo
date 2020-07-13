package exm.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectArray {

    public static void main(String[] args) {
        int[] a = new int[]{4,9,5};
        int[] b = new int[]{9,4,9,8,4};
        int[] intersect = intersect(a, b);
        System.out.println(Arrays.toString(intersect));
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     */
    // 利用哈希表
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null
                || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        HashMap<Integer, Integer> counter = new HashMap<>();
        ArrayList<Integer> rest = new ArrayList<>();
        for (int i : nums1) {
            counter.merge(i, 1, Integer::sum);
        }
        for (int i : nums2) {
            Integer count = counter.computeIfPresent(i, (k, v) -> --v);
            if (count != null && count >= 0) rest.add(i);
        }
        return rest.stream().mapToInt(Integer::intValue).toArray();
    }

    // nums1, nums2 有序  =》 双指针
    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null
                || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        ArrayList<Integer> rest = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                rest.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return rest.stream().mapToInt(Integer::intValue).toArray();
    }
}
