package Amazon;


import java.util.Arrays;
import java.util.Stack;

//Explanation : https://www.youtube.com/watch?v=_A-PMoHIVMI&t=1237s&ab_channel=CapsLock
//We can do this problem with monotonic Stack

//Time Complexity: O(n)  Space Complexity: O(n)
public class JumpGameVIII2297 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4,4,1};
        int[] costs = new int[]{3,7,6,4,2};
        System.out.println(minCost(nums,costs));
    }
    public static long minCost(int[] nums, int[] costs) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        long[] dp = new long[len];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        //Monotonic stack 1st stack contains the next Greatest Element and  2nd stack contains the next smallest element see below for example
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && nums[i] >= nums[stack.peek()]) {
                int idx = stack.pop();
                dp[i] = Math.min(dp[i], dp[idx] + costs[i]);
            }
            stack.push(i);

            while (!stack2.empty() && nums[i] < nums[stack2.peek()]) {
                int idx = stack2.pop();
                dp[i] = Math.min(dp[i], dp[idx] + costs[i]);
            }
            stack2.push(i);
        }
        return dp[len - 1];
    }
}

/*
//nextGreaterElements
A monotonically increasing stack maintains elements in non-decreasing order from the bottom of the stack to the top.
Each new element added to the stack is greater than or equal to the element before it.
This is useful for problems like finding the next smaller element for each element in an array.

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Output: [4, 2, 4, -1, -1]
    }
}
*/

/*
nextSmallerElements
A monotonically decreasing stack maintains elements in non-increasing order from the bottom of the stack to the top
Each new element added to the stack is less than or equal to the element before it.
This is useful for problems like finding the next smaller element for each element in an array.

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    public static int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 5};
        int[] result = nextSmallerElements(nums);
        System.out.println(Arrays.toString(result)); // Output: [3, 2, -1, 5, -1]
    }
}*/

