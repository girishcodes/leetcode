package TwoPointers;

import java.util.Arrays;

public class RemoveElementFromUnsortedArray {
    /***
     * Leetcode : https://leetcode.com/problems/remove-element/
     *
     *Technique: 2 pointers. Have one pointer to keep track of writing position and another to iterate.
     * While the item at iterate index is target element just skip it.
     * Tags: 2 Pointers.
     */
    public static int removeElement(int[] nums, int element) {
        int len = nums.length;
        int writeIndex = 0;
        int i = 0;
        while (i < len) {
            while (i < len && nums[i] == element) i++;

            if (i < len && nums[i] != element) {
                nums[writeIndex++] = nums[i++];
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int lastIndex = removeElement(nums, 2);
        int[] newArray = Arrays.copyOfRange(nums, 0,lastIndex );
        System.out.println(Arrays.toString(newArray));
    }
}
