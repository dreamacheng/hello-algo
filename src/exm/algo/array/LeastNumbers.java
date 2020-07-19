package exm.algo.array;

import exm.algo.sort.HeapSort;

public class LeastNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,1};
        getLeastNumbers2(arr, 1);
    }

    /**
     *
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     *
     * 方法一：  利用快排减治
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[]{};
        partition(arr, 0, arr.length - 1, k);
        int[] rest = new int[k];
        for (int i = 0; i < k; i++) {
            rest[i] = arr[i];
        }
        return rest;
    }

    private void partition(int[] arr, int start, int end, int k) {
        if (start >= end) return;
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                if (i != j) {
                    HeapSort.swap(arr, i, j);
                }
                i++;
            }
        }
        arr[end] = arr[i];
        arr[i] = pivot;
        if (i == k - 1) {
            return;
        } else if (i < k - 1) {
            partition(arr, i + 1, end, k);
        } else {
            partition(arr, start, i -1, k);
        }
    }

    // 方法二： 利用堆
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) return new int[]{};
        int[] rest = new int[k];
        for (int i = 0; i < k; i++) {
            rest[i] = arr[i];
        }
        // 构建初始堆
        for (int i = k/2 - 1; i >= 0; i--) {
            heapify(rest, i, k);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < rest[0]) {
                rest[0] = arr[i];
                heapify(rest, 0, k);
            }
        }
        return rest;
    }
    // 构建大顶堆
    public static void heapify(int[] arr, int start, int len) {
        int maxIndex = start;
        int lChild = start * 2 + 1;
        int rChild = start * 2 + 2;
        if (lChild < len && arr[lChild] > arr[maxIndex]) {
            maxIndex = lChild;
        }
        if (rChild < len && arr[rChild] > arr[maxIndex]) {
            maxIndex = rChild;
        }
        if (maxIndex != start) {
            HeapSort.swap(arr, maxIndex, start);
            heapify(arr, maxIndex, len);
        }
    }
}
