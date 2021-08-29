package BinarySearch;

import java.util.Arrays;

public class SearchInRotatedArray {
    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     *
     * [0,1,2,3,4,5]
     * Left Rotate:[1,2,3,4,5,0],[2,3,4,5,0,1],[3,4,5,0,1,2]
     * Right Rotate:[5,0,1,2,3,4],[4,5,0,1,2,3],[3,4,5,0,1,2]
     * [3,3,3]
     * [3]
     */

    private static int searchNum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l + 1) / 2);//Add 1 to avoid integer division loss
            if(nums[m] == target) return m;

            // left side is sorted in ascending order.
            if(nums[l] <= nums[m]) {
                // case {3,4,5,0,1,2} t = 4
                if(nums[l] <= target && target < nums[m]) r = m - 1;
                // case {3,4,5,0,1,2} t = 1
                else l = m;
            } // right side is sorted in ascending order.
            else {
                // case {5,0,1,2,3,4} t = 4
                if(target > nums[m] && target <= nums[r]) l = m;
                // case {5,0,1,2,3,4} t = 1
                else r = m - 1;
            }

        }
        if(nums[l] == target) return l;
        return -1;
    }

    public static void main(String[] args) {
        int[][] nums2D = {
                {0,1,2,3,4,5},
                {1,2,3,4,5,0},{2,3,4,5,0,1},{3,4,5,0,1,2},
                {5,0,1,2,3,4},{4,5,0,1,2,3},{3,4,5,0,1,2},
                {3,3,3},
                {1}
        };
        searchNum(nums2D[5], 4);
        for(int[] nums : nums2D){
            System.out.println("4 is found at index : " + searchNum(nums, 4) + " in " + Arrays.toString(nums));
            System.out.println("1 is found at index : " + searchNum(nums, 1) + " in " + Arrays.toString(nums));
        }
    }
}
