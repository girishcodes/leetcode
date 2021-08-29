package BinarySearch;

import java.util.Arrays;

public class FindMinInRotatedArray {

    /**
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     *
     * [0,1,2,3,4,5]
     * Left Rotate:[1,2,3,4,5,0],[2,3,4,5,0,1],[3,4,5,0,1,2]
     * Right Rotate:[5,0,1,2,3,4],[4,5,0,1,2,3],[3,4,5,0,1,2]
     * [3,3,3]
     * [3]
     */
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l +((r-l)/2);

            // {3,4,5,0,1,2}
            if(nums[m] > nums[r]) l = m + 1;
            //{4,5,0,1,2,3}
            else if(nums[m] < nums[l]) r = m;
            // {3,3,3}
            else r--;
        }
        return nums[l];
    }
    public static void main(String[] args) {
        int[][] nums2D = {
                {0,1,2,3,4,5},
                {1,2,3,4,5,0},{2,3,4,5,0,1},{3,4,5,0,1,2},
                {5,0,1,2,3,4},{4,5,0,1,2,3},{3,4,5,0,1,2},
                {3,3,3},
                {1}
        };
        for(int[] nums : nums2D){
            System.out.println("Minimum in " + Arrays.toString(nums) + " is " + findMin(nums));
        }
    }
}
