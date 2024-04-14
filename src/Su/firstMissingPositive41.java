/*
https://www.youtube.com/watch?v=9SnkdYXNIzM&ab_channel=AlgosWithMichael
https://www.youtube.com/watch?v=8g78yfzMlao&t=889s&ab_channel=NeetCode
*/
package Su;

public class firstMissingPositive41 {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        // Step 1: Handling negative numbers, 0, and numbers greater than the array length
        int containsOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                containsOne = 1;  // Check if the array contains 1 (important for later)
            } else if (nums[i] <= 0 || nums[i] > nums.length) {
                // Replace negative numbers, 0, and numbers greater than the array length with 1
                // We don't need to consider these values as they don'  t represent valid missing positive integers
                // within the range 1 to nums.length
                nums[i] = 1;
            }
        }

        if (containsOne == 0) {
            // If 1 is not present in the array, the missing positive integer is 1
            return 1;
        }
        // Step 2: Marking elements present in the array using their indices as negative markers
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  // Use the absolute value of the element as the index
            if (nums[index] > 0) {  // Check if the element at the calculated index is positive
                nums[index] = -1 * nums[index];  // Make the element at the index negative, marking its presence
            }
        }

        // Step 3: Finding the missing positive integer
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {  // If an element is positive, it represents the missing positive integer
                return i + 1;  // The missing integer is one more than the index (since indices start from 0)
            }
        }

        // If no missing positive integer is found within the range 1 to nums.length (all elements are marked negative)
        return nums.length + 1;  // The missing integer is the array length + 1
    }
}
