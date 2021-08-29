package TwoPointers;

public class ContainerWithMostWater {

    /***
     * Leetcode : https://leetcode.com/problems/container-with-most-water/
     *
     * Thought: 2 Pointer technique.
     * The area of water stored between 2 lines is min(line1, line2) * distance between line1 & line2.
     * Then move the smaller line closer or one of them when both lines are of same height.
     *
     *
     * Constraint :
     * n == height.length
     * 2 <= n <= 105
     * 0 <= height[i] <= 104
     *
     * Tags: #Arrays, #2 Pointers, #Greedy
     */

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int distance = right - left;
            int leftMaxHeight = height[left];
            int rightMaxHeight = height[right];
            int area = Math.min(leftMaxHeight, rightMaxHeight) * distance;

            // move the smaller line closer or one of them when both are same height.
            if (leftMaxHeight <= rightMaxHeight) {
                // nothing smaller than leftMaxHeight can hold more water.
                while (left < right && leftMaxHeight >= height[++left]) ;
            } else {
                // nothing smaller than rightMaxHeight can hold more water.
                while (left < right && rightMaxHeight >= height[--right]) ;
            }

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int maxAreaV0(int[] height) {
        int maxArea = 0;
        int start = 0, end = height.length - 1;

        while (start < end) {
            //area = width * min of heights, move smaller line closer.
            int area = (end - start) * ((height[start] > height[end]) ? height[end--] : height[start++]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = maxArea(heights);
        System.out.println(area);

        area = maxAreaV0(heights);
        System.out.println(area);
    }
}
