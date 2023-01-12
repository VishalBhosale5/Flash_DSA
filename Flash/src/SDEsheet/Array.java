package SDEsheet;

import java.util.HashMap;

public class Array {
	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * Patterns: 1)Sliding window: min length subarray, max len subarray, subarray
		 * with length k 2)2 pointer : find pair 3)prefix sum: subarray with sum k
		 */

	}

	// find 2nd largest element in array without sorting
	// time: O(n) space: O(1)
	int print2largest(int arr[], int n) {
		int max1 = -1, max2 = -1;

		for (int i : arr) {
			if (i > max1) {
				max2 = max1;
				max1 = i;
			}
			if (i > max2 && i != max1)
				max2 = i;
		}
		return max2;
	}

	// find 3rd largest element

	int thirdLargest(int a[], int n) {
		// code here
		int max1 = -1, max2 = -1, max3 = -1;
		for (int i : a) {
			if (i > max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			}
			if (i > max2 && i != max1) {
				max3 = max2;
				max2 = i;
			}

			if (i > max3 && i != max2 && i != max1)
				max3 = i;
		}
		return max3;

	}

	/*
	 * check if array is sorted and rotated time: O(n) space: O(1)
	 * 
	 * explaination: if sorted count=1 , if rotated count=1
	 */

	public boolean check(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[(i + 1) % nums.length])
				count++;
		}
		return (count <= 1);
	}

	/*
	 * remove duplicates from sorted array time: O(n) space : O(1)
	 * 
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}

		}
		return i + 1;
	}

	/*
	 * Rotate array by k if left rotate k=k if right rotate k=array.length-k-1; time
	 * : O(n) space: O(1)
	 */
	public void rotate(int[] nums, int k) {
		if (nums.length <= 1)
			return;
		k = k % nums.length;
		k = nums.length - k - 1;
		reverse(nums, 0, k);
		reverse(nums, k + 1, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	public void reverse(int[] ar, int i, int j) {
		while (i < j) {
			int temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
			i++;
			j--;
		}
	}

	/*
	 * Move zeros to end time: O(n) spacce: O(1)
	 */
	public void moveZeroes(int[] nums) {

		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
			if (nums[cur] != 0) {
				int temp = nums[lastNonZeroFoundAt];
				nums[lastNonZeroFoundAt++] = nums[cur];
				nums[cur] = temp;
			}
		}
	}

	/*
	 * https://leetcode.com/problems/missing-number/submissions/876193840/ time:
	 * O(n) space:O(1)
	 */
	public int missingNumber(int[] nums) {
		int tSum = 0, cSum = 0;
		for (int i = 0; i < nums.length; i++) {
			tSum += i;
			cSum += nums[i];
		}
		tSum += nums.length;
		return tSum - cSum;
	}

	/*
	 * Find missing and duplicate number time: O(3N) space: O(1)
	 */

	int[] findTwoElement(int arr[], int n) {
		int[] an = new int[2];

		// first do xor from 1..n and array elements we will ge xor of missing and
		// duplicate number
		int tXor = 0;
		for (int i = 1; i <= n; i++) {
			tXor ^= i;
			tXor ^= arr[i - 1];
		}
		// now we have xor of missing and duplicate
		// find the rightmost set bit
		// System.out.println("--"+Integer.toBinaryString(tXor));
		int ithBitSet = 0;
		int temp = tXor;
		while ((temp & 1) == 0) {
			temp = temp >> 1;
			ithBitSet++;
		}

		int num1 = 0, num2 = 0;
		int mask = 1 << ithBitSet;

		// if there is ith bit set means for that positions 1 number has set bit and
		// another has 0
		// to find those we will again categrize based on set and 0 bit at that position
		for (int i = 1; i <= n; i++) {
			if ((i & mask) != 0)
				num2 ^= i;
			else
				num1 ^= i;

			if ((arr[i - 1] & mask) != 0)
				num2 ^= arr[i - 1];
			else
				num1 ^= arr[i - 1];

		}

		// check if num1 is duplicate
		boolean isNum1Duplicate = false;

		for (int i = 0; i < n; i++) {
			if (arr[i] == num1)
				isNum1Duplicate = true;
		}

		if (isNum1Duplicate) {
			an[0] = num1;
			an[1] = num2;
		} else {
			an[0] = num2;
			an[1] = num1;
		}
		return an;
	}

	/*
	 * max consecutive 1ns sliding window approach time : O(n) space O(1)
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		int s = 0, e = 0;
		int maxlen = 0;
		while (e < nums.length) {
			if (nums[e] == 0) {
				maxlen = Math.max(maxlen, e - s);
				s = e = e + 1;
			} else
				e++;
		}

		maxlen = Math.max(maxlen, e - s);
		return maxlen;
	}

	/*
	 * Find sub arrays with sum k time :O(n) space: O(n)
	 */

	public int subarraySum(int[] nums, int k) {
		int s = 0, e = 0;
		int sum = 0, tSbArrySum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				tSbArrySum += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return tSbArrySum;
	}

	/*
	 * find element in row wise sorted matrix time : O(log(m*n) space: O(1)
	 */

	public boolean searchMatrix(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
				return binarySearch(matrix[i], target);
			}
		}
		return false;
	}

	public boolean binarySearch(int[] arr, int target) {

		int start = 0, end = arr.length - 1;
		int mid = start + (end - start) / 2;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == target)
				return true;
			else if (arr[mid] > target) {
				end = mid - 1;
			} else
				start = mid + 1;
		}

		return false;
	}

	/*
	 * Row with mx 1's time: O(nlogn) space: O(1)
	 */
	int rowWithMax1s(int arr[][], int n, int m) {
		// code here
		//instead of doing binary search on every row check if prev index has 1 in current row index else skip search for current row move to next 
		int ans = 0, idx = -1, index = 0, indexc = arr[0].length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (idx == -1 || arr[i][indexc] == 1) {
				index = binarySearch(arr[i]);
				if (index >= 0 && index < indexc)
					indexc = index;
				int k = arr[i].length - 1 - index;
				if (k > ans) {
					ans = k;
					idx = i;
				}
			}
		}
		return idx;
	}

	public int binarySearch(int[] ar) {

		int s = 0, e = ar.length - 1;

		int mid = 0;

		while (s <= e) {
			mid = s + (e - s) / 2;

			if (ar[mid] == 0 && mid + 1 < ar.length && ar[mid + 1] == 1) {
				return mid;
			} else if (ar[mid] == 0) {
				s = mid + 1;
			} else
				e = mid - 1;
		}

		return ar[0] == 0 ? ar.length : -1;
	}
}
