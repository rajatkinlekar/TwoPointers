package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, -5, -6};
        int k = 3;
        System.out.println(Arrays.toString(maxSubArraySizeK(nums, k)));
    }

    static int[] maxSubArraySizeK(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[] ans = new int[k];

        for (int i = l; i <= r; i++) {
            currentSum += nums[i];
        }

        while (r < nums.length) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
                ans = Arrays.copyOfRange(nums, l, r+1);
            }

            currentSum -= nums[l];
            l++;
            r++;
            currentSum += r < nums.length ? nums[r] : 0;
        }

        return ans;

    }

}