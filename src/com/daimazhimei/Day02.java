package com.daimazhimei;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * 二分查找实现， 以及测试代码
 * @author kexun
 *
 */
public class Day02 {

	/**
	 * 二分查找
	 * @param array
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] array, int target) {
		
		int low = 0;
		int high = array.length;
		
		while (low <= high) {
			
			int mid = (low + high) >>> 1;
			int value = array[mid];
			if (value < target) {
				low = mid+1;
			} else if (value > target) {
				high = mid-1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
	
	/**
	 * 用于测试二分查找中，数组过大，求中间值溢出问题。
	 * @param low
	 * @param high
	 * @return
	 */
	public int calculateMidPoind(int low, int high) {
		int mid = (low + high) >>> 1;
		System.out.println((low + high));
		return mid;
	}
	
	/**
	 * 用于测试二分查找中，数组过大，求中间值溢出问题。
	 * @param low
	 * @param high
	 * @return
	 */
	public int calculateMidPoind2(int low, int high) {
		int mid = (low + high) /2;
		return mid;
	}
	
	public int[] generateRandomSortedArray(int maxArraySize, int maxValue) {
		
		int arraySize = 1 + new Random().nextInt(maxArraySize);
		int[] array = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			array[i] = new Random().nextInt(maxValue);
		}
		
		Arrays.sort(array);
		for (int a : array) {
			System.out.print(a+",");
		}
		
		return array;
	}
	
	@Test
	public void smokeTest() {
		Day02 d = new Day02();
		int[] array = {
			Integer.MIN_VALUE,-23,-5,-1,0,45,67,89
		};
		
		
		int v1 = d.calculateMidPoind2(Integer.MAX_VALUE-2, Integer.MAX_VALUE-1);
		int v2 = d.calculateMidPoind(Integer.MAX_VALUE-2, Integer.MAX_VALUE-1);
		int v3 = d.calculateMidPoind(1200000000, 1300000000);
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		
		int v4 = d.binarySearch(array, -23);
		System.out.println(v4);
		int v5 = d.binarySearch(array, 89);
		System.out.println(v5);
		int v6 = d.binarySearch(array, Integer.MIN_VALUE);
		System.out.println(v6);
		
		System.out.println("/////////////////////////");
		int[] array2 = d.generateRandomSortedArray(40, 90);
		int v7 = d.binarySearch(array2, 60);
		System.out.println(v7);
		
	}
	
}
