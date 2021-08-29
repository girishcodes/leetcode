package BinarySearch;

public class MergeSortedArrays {
    /***
     * Leetcode : https://leetcode.com/problems/median-of-two-sorted-arrays/
     *
     * Median of an array is the middle item. In case of array of even length (say 4)
     * it's the average of sum of middle two items (items[2]+items[3]/2).
     *
     * Constraint :
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */

    /***
     * Thought:
     *
     * The solution uses auxiliary array and copies the smallest of the two until the mid-point.
     *
     * Tags: #Array
     * Time Complexity : O(N+M)
     * Space Complexity : O(N+M)
     */
    public static double findMedianSortedArrays2(int[] num1, int[] num2) {
        int l1 = num1.length;
        int l2 = num2.length;
        if (l1 == 0 && l2 == 0) return 0.0;

        int[] merge = new int[l1 + l2];
        int i1 = 0, i2 = 0;
        int mid = (l1 + l2) / 2;

        for (int k = 0; k < mid + 1 && k < l1 + l2; k++) {
            int n1 = (i1 < l1) ? num1[i1] : Integer.MAX_VALUE;
            int n2 = (i2 < l2) ? num2[i2] : Integer.MAX_VALUE;

            if (n1 < n2) {
                merge[k] = n1;
                i1++;
            } else {
                merge[k] = n2;
                i2++;
            }
        }
        // if the lengths of 2 is even then (res[mid-1]+res[mid])/2
        return ((l1 + l2) % 2 == 0) ? (merge[mid - 1] + merge[mid]) / 2.0 : merge[mid] * 1.0;
    }

    /***
     * Thought: Since both arrays are sorted, we can use binarySearch to partition the arrays to find the middle point.
     * Time Complexity : O(log(min(N,M))
     * Space Complexity : O(1)
     * Tags: #Array #BinarySearch
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            throw new IllegalArgumentException("Constraint: 1 <= m + n <= 2000");
        // Make nums1 the shorter of the two arrays.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;
        //int mid = (total + 1) / 2;
        // Work by partitioning the smaller array.
        int left = 0, right = l1;
        while (left <= right) {
            int n1PartitionIdx = (left + right) / 2;
            // for finding the middle of the combined array, we have to partition the second array by remaining.
            int n2PartitionIdx = (total + 1) / 2 - n1PartitionIdx;

            int n1Left = (n1PartitionIdx == 0) ? Integer.MIN_VALUE :
                    nums1[n1PartitionIdx - 1];
            int n1Right = (n1PartitionIdx == l1) ? Integer.MAX_VALUE :
                    nums1[n1PartitionIdx];

            int n2Left = (n2PartitionIdx == 0) ? Integer.MIN_VALUE :
                    nums2[n2PartitionIdx - 1];
            int n2Right = (n2PartitionIdx == l2) ? Integer.MAX_VALUE :
                    nums2[n2PartitionIdx];

            // Partitioning is correct if left-half of one is less than the right-half of the other.
            if (n1Left <= n2Right && n2Left <= n1Right) {
                // partition is correct
                if (total % 2 == 0)
                    return (Math.max(n1Left, n2Left) + Math.min(n1Right, n2Right)) / 2.0;
                return Math.max(n1Left, n2Left) / 1.0;
            } else if (n1Left > n2Right) {
                // number to the left of the partition in nums1 is larger. Move the range further left.
                right = n1PartitionIdx - 1;
            } else {
                // number to the right of the partition in nums1 is smaller. Move the range further right.
                left = n1PartitionIdx + 1;
            }
        }
        throw new IllegalArgumentException("Arrays are not sorted.");
    }

    public static void main(String[] args) {

        int[] nums11 = {1, 3};
        int[] nums12 = {2};
        double res1 = findMedianSortedArrays(nums11, nums12);
        System.out.println(res1);

        int[] nums21 = {1, 3};
        int[] nums22 = {2, 4};
        double res2 = findMedianSortedArrays(nums21, nums22);
        System.out.println(res2);

        int[] nums31 = {0, 0};
        int[] nums32 = {0, 0};
        double res3 = findMedianSortedArrays(nums31, nums32);
        System.out.println(res3);

        int[] nums41 = {};
        int[] nums42 = {6};
        double res4 = findMedianSortedArrays(nums41, nums42);
        System.out.println(res4);

        try {
            int[] nums51 = {};
            int[] nums52 = {};
            double res5 = findMedianSortedArrays(nums51, nums52);
            System.out.println(res5);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
