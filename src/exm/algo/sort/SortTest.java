package exm.algo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序是否正确测试
 */
public class SortTest {
    public static void main(String[] args) {
        boolean isCorrect = true;
        int[] arr = new int[10];
        Random random = new Random();
        for(int m = 0; m < 1000; ++m) {
            int i = 0;
            while(i < arr.length) {
                arr[i++] = random.nextInt(100);
            }
            System.out.println("排序前数组为： " + Arrays.toString(arr));
            MergeSort.mergeSort(arr, 0, arr.length -1);
            System.out.println("排序后数组为： " + Arrays.toString(arr));
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    isCorrect = false;
                }
            }
            System.out.println("排序" + (isCorrect ? "正确" : "错误"));
        }
        System.out.println("1000组数据排序" + (isCorrect ? "正确" : "错误"));
    }
}
