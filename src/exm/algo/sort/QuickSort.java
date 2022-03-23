package exm.algo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {


	public static void quickSort(int[] arr, int i, int j) {
		if(i >= j) {
			return;
		}
		int pivot = partition1(arr, i, j);
		quickSort(arr, i, pivot -1);
		quickSort(arr, pivot + 1, j);
	}

	/**
	 * 	前后指针实现
	 * @param arr
	 * @param begin 数组起始下标
	 * @param end 数组结束下标
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int partition1(int[] arr, int begin, int end) {

		int pivot = arr[end];
		int i = begin;
		for (int j = begin; j < end; ++j) {
			if (arr[j] < pivot) {
				if (i == j) {
					i++;
				} else {
					int temp = arr[i];
					arr[i++] = arr[j];
					arr[j] = temp;
				}
			}
		}
		arr[end] = arr[i];
		arr[i] = pivot;
		return i;
	}
	/**
	 *	左右指针实现
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int partition2(int[] arr, int begin, int end) {
		int pivot = arr[end];
		int i = begin;
		int j = end;
		while(i < j) {
			while(arr[i] <= pivot && i < j) {
				i++;
			}
			while(arr[j] >= pivot && i < j) {
				j--;
			}
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[end] = arr[i];
		arr[i] = pivot;
		return i;
	}

	/**
	 * 	挖坑法实现
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int partition3(int[] arr, int begin, int end) {
		int pivot = arr[end];
		int i = begin;
		int j = end;
		while(i < j) {
			if (arr[i] <= pivot) {
				i++;
			}
			arr[j] = arr[i];
			if (arr[j] >= pivot && i < j) {
				j--;
			}
			arr[i] = arr[j];
		}
		arr[i] = pivot;
		return i;
	}

}
