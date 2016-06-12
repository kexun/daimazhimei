package com.daimazhimei;


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
	
	@Test
	public void smokeTest() {
		Day02 d = new Day02();
		int[] array = new int[50];
		
		for (int i = 0; i < 50; i++) {
			array[i] = i;
		}
		System.out.println(array[d.binarySearch(array, 10)]);
		Assert.assertEquals(9, d.binarySearch(array, 10));
	}
	
}
