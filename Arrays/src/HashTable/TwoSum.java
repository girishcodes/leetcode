package HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /***
    Leetcode : https://leetcode.com/problems/two-sum/
    I/P :
    nums = [2,7,11,15], target = 9

    O/P : [0,1]

    Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

    Thought :
    To avoid double looping or O(n^2), for numbers seen already we need a way to store
    and retrieve the numbers and their indices.
    Use a map or a large array(if it can hold the range) to store the number and it's index as you iterate.

    Iterate throught the array.
    Check if (target - nums[i]) exists in the map, if so (target - nums[i]) was already seen before.
    And you have found the pair that sum to the target return their indices.
    Otherwise add nums[i] and i into map.

    Tags: #Array #HashTable
    Time Complexity : O(N)
    Space Complexity : O(N) in the worst case when map fills up.
    */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexLookup = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;

            if (indexLookup.containsKey(num2))
                return new int[] {indexLookup.get(num2), i};

            indexLookup.put(num1, i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1,target1)));

        int[] nums2 = {3,2,4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2,target2)));

        int[] nums3 = {3,3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3,target3)));
    }
}
