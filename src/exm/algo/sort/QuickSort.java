package exm.algo.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		boolean isCorrect = true;
		for(int m = 0; m < 1000; ++m) {
			int[] arr = new int[10];
			Random random = new Random();
			int i = 0;
			while(i < arr.length) {
				arr[i++] = random.nextInt(100);
			}
			System.out.println("排序前数组为： " + Arrays.toString(arr));
			quickSort(arr, 0, arr.length -1);
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

	private static void quickSort(int[] arr, int i, int j) {
		if(i >= j) {
			return;
		}
		int pivot = partition3(arr, i, j);
		quickSort(arr, i, pivot -1);
		quickSort(arr, pivot + 1, j);
	}

	/**
	 * 	前后指针实现
	 * @param arr
	 * @param i 数组起始下标
	 * @param j 数组结束下标
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int partition1(int[] arr, int begin, int end) {

		int pivot = arr[end];
		int i = begin;
		for(int j = begin; j < end; ++j) {
			if(arr[j] < pivot) {
				if(i == j) {
					i++;
				}else {
					arr[i++] = arr[j];
					int temp = arr[i];
					arr[j] = temp;
				}
			}
		}
		int temp = arr[i];
		arr[i] = pivot;
		arr[end] = temp;

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
			if(arr[i] <= pivot && i < j) {
				i++;
			}
			arr[j] = arr[i];
			if(arr[j] >= pivot && i < j) {
				j--;
			}
			arr[i] = arr[j];
		}
		arr[i] = pivot;
		return i;
	}

}
