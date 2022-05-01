package exm.algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例 1：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 示例  2:
 * 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * 输出：[22,28,8,6,17,44]
 *
 * 提示：
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i]  各不相同 
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray2(arr1, arr2)));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : arr1) {
            counter.merge(i, 1, Integer::sum);
        }
        int[] cursor = new int[]{0};
        for (int i : arr2) {
            Integer looper = counter.remove(i);
            while (looper-- > 0) {
                result[cursor[0]++] = i;
            }
        }
        counter.keySet().stream().sorted().forEach(i -> {
            Integer looper = counter.get(i);
            while (looper-- > 0) {
                result[cursor[0]++] = i;
            }
        });
        return result;
    }

    // 计数排序
    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] counter = new int[1001];
        for (int i : arr1) {
            counter[i]++;
        }
        int cursor = 0;
        for (int i : arr2) {
            while (counter[i]-- > 0) {
                arr1[cursor++] = i;
            }
        }
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0) {
                arr1[cursor++] = i;
            }
        }
        return arr1;
    }
}
