package TwoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    /***
     * Leetcode : https://leetcode.com/problems/3sum/
     *
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Thought:
     * Sort the array, this will help in moving left and right pointers based on sum using 2 pointers technique.
     * Iterate i -> 0 to (len - 2)
     * For every a[i] use 2 pointer technique iterate from l = i + 1 and r = a.len - 1 to find a[i] + a[l] + a[r] = 0
     *
     * Tags: #Arrays #2Pointers #Sorting
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums == null || nums.length < 3) return results;

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int sum = 0 - nums[i];
            int l = i + 1, r = len - 1;
            while (l < r) {
                if (sum == nums[l] + nums[r]) {
                    results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // remove duplicates
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;

                    l++;
                    r--;
                } else if (sum < nums[l] + nums[r]) r--;
                else l++;
            }
            // remove duplicates
            while (i < len - 2 && nums[i] == nums[i + 1]) i++;
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> results = threeSum(nums);
        System.out.println(results);
    }
}
