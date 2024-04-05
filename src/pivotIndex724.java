//Time Complexity -O(n), Space - O(1)
public class pivotIndex724 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        int ans = pivotIndex(nums);
        System.out.println(ans);
    }
    public static int pivotIndex(int[] nums) {
        int leftSum=0,rightSum=0;
        for(int i=1;i<nums.length;i++)
            rightSum = rightSum + nums[i];

        if(rightSum == 0)
            return 0;
//    In the second loop (starting from i = 1), the code iterates through the array again.
//    At each iteration, it checks if leftSum (sum of elements to the left of the current index) is equal to rightSum (sum of elements to the right of the current index).
//    If leftSum equals rightSum, it means the pivot index is found, and the code returns i - 1.
//    Otherwise, it updates leftSum by adding the current element (nums[i-1]) and updates rightSum by subtracting the next element (nums[i]).
        for(int i=1;i<nums.length;i++){
            if(leftSum == rightSum)
                return i-1;
            leftSum = leftSum+nums[i-1];
            rightSum = rightSum - nums[i];
        }

        if(leftSum == 0)
            return nums.length-1;

        return -1;
    }
}
