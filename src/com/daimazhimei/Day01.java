package com.daimazhimei;

/**
 * 最美丽的代码， Quicksort
 * @author kexun
 *
 */
public class Day01 {

	public static void main(String[] args) {

		Day01 d = new Day01();
		int[] array = new int[20];
		
		for (int i = 0; i<array.length; i++) {
			array[i] = (int)(1+Math.random()*(1000-1+1));
		}
		
		d.quickSort(array, 0, array.length-1);
		d.print(array);
	}
	
	public void quickSort(int[] array, int left, int right) {
		
		int length = array.length;
		if (length == 0 || left > right) {
			return;
		}

		int start = left;
		int end = right;
		
		int base = array[left];
		while (left < right) {
			
			while (left < right && base <= array[right]) {
				right--;
			}
			
			if (left < right) {
				array[left] = array[right];
				left++;
			}
			
			while (left < right && base > array[left]) {
				left++;
			}
			
			if (left < right) {
				array[right] = array[left];
				right--;
			}
			
		}
		
		array[left] = base;
		
		quickSort(array, start, left-1);
		quickSort(array, right+1, end);
	}

	public void print(int[] array) {
		for (int a : array)
			System.out.print(a+",");
	}
	
}
