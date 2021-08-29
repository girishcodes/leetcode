package TwoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    /**
     * https://leetcode.com/problems/4sum
     *
     * THOUGHT:
     * Sort the array, this will help in moving left and right pointers based on sum using 2 pointers technique.
     * Iterate i -> 0 to (len - 3)
     * Iterate j -> i + 1 to (len - 2)
     * Use 2 Pointer technique. l = j + 1 & r = len - 1
     * Find nums[i] + nums[j] + nums[l] + nums[r] == target
     *
     * Skip duplicates at each level.
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (target == nums[i] + nums[j] + nums[l] + nums[r]) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // remove duplicates
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;

                        l++;
                        r--;
                    } else if (target < nums[i] + nums[j] + nums[l] + nums[r]) r--;
                    else l++;
                }
                // remove duplicates.
                while(j < nums.length - 2 && nums[j] == nums[j + 1]) j++;
            }
            // remove duplicates.
            while(i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
        }
        return results;
    }

    public static void main(String[] args) {
        int []nums1 = {1,0,-1,0,-2,2};
        int []nums2 = {2,2,2,2,2};
        System.out.println(fourSum(nums1, 0));
        System.out.println(fourSum(nums2, 8));
    }
}
