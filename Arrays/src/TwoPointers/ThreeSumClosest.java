import java.util.Arrays;

public class ThreeSumClosest {

    /***
     * Thought :
     * This is similar to ThreeSum()
     * Sort the array.
     * Iterate through the array.
     * For every a[i] use 2 pointer technique iterate from l = i + 1 and r = a.len - 1
     *
     * Tags: #Arrays #2Pointers #Sorting
     */
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int len = nums.length;
        for (int i = 0; i < Math.min(3, len); i++) {
            closestSum += nums[i];
        }
        if (len < 3 || closestSum == target) return closestSum;

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) closestSum = sum;

                if (sum > target) r--;
                else l++;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int closestSum = threeSumClosest(nums, 0);
        System.out.println(closestSum);
    }
}
