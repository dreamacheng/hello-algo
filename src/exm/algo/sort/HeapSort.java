package exm.algo.sort;

// 堆排
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 1) return;

        int len = arr.length;

        // 从最后一个非叶子节点，由下至上，由右至左建堆
        for (int i = len/2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }

        // 逐个交换堆顶与最后一个叶子节点，并堆化
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

    // 大顶堆
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;
        if (left < len && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            heapify(arr, maxIndex, len);
        }
    }

    private static void heapify2(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIndex = i;
        if (left < len && arr[left] < arr[minIndex]) {
            minIndex = left;
        }
        if (right < len && arr[right] < arr[minIndex]) {
            minIndex = right;
        }
        if (minIndex != i) {
            swap(arr, i, minIndex);
            heapify2(arr, minIndex, len);
        }
    }
}
