/*
    Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k]
     < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
 */

import java.util.Arrays;

public class Solution {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < Math.abs(target)) {
                    count++;
                    left++;
                    right--;
                }
                else
                    right--;
            }
        }

        return count;
    }
}
