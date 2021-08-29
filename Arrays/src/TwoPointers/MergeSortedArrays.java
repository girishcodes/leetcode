package TwoPointers;

import java.util.Arrays;

public class MergeSortedArrays {
    static void mergerFirstIntoSecond(int[] arr1, int[] arr2) {
        int l1 = arr1.length - 1;
        int l2 = l1;
        int writeIndex = arr2.length - 1;

        while (l1 >= 0 && l2 >= 0) {
            if (arr1[l1] >= arr2[l2]) {
                arr2[writeIndex--] = arr1[l1--];
            } else {
                arr2[writeIndex--] = arr2[l2--];
            }
        }
        while (l1 >= 0) {
            arr2[writeIndex--] = arr1[l1--];
        }
        while (l2 >= 0) {
            arr2[writeIndex--] = arr2[l2--];
        }
    }

    public static void main(String[] args) {
        int [] nums1 = {1, 3, 5};
        int [] nums2 = {2, 4, 6, 0, 0, 0};
        mergerFirstIntoSecond(nums1, nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
