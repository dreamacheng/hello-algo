package exm.algo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int begin, int end){
        if(begin >= end){
            return;
        }
        int pivot = begin + (end - begin >>> 1);
        mergeSort(arr, begin, pivot);
        mergeSort(arr, pivot + 1, end);
        merge(arr, begin, pivot, end);
    }

    private static void merge(int[] arr, int begin, int pivot, int end) {
        int i = begin;
        int j = pivot + 1;
        int k = 0;
        int[] temp = new int[end - begin + 1];
        while (i <= pivot && j <= end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        int m = i;
        int n = pivot;
        if(i > pivot){
            m = j;
            n = end;
        }
        while (m <= n){
            temp[k++] = arr[m++];
        }
        int q = 0;
        while (begin <= end){
            arr[begin++] = temp[q++];
        }
    }


}
