package Amazon;

/*To get the minium number of swaps, we need to:
We need to find the index of left most min value and index of right most max value. Then count the number of swaps needed to put them at the extreme of the array.

Loop to find the index of left most min value and right most max value.
Then we need to calculate the number of swaps required to push the min value to the 0th index and max value to the n-1th index.
Its nothing but minValIndex + ((arraysize-1) - maxValIndex).

But we need to consider one case which is if the max value index is less than the min value index.
If so, when the swap happens, both item will get swapped together at some point, which means we need to reduce the total number of snaps by 1.
minValIndex + ((arraysize-1) - maxValIndex) - 1.

Complexity
Time complexity: O(n) as we have to go through the array once to find the min and max value index.
Space complexity:O(1) space complexity*/
public class MinimumAdjacentSwapstoMakeaValidArray2340 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,5,3,1};
        System.out.println(minimumSwaps(nums));
    }
    public static int minimumSwaps(int[] nums) {
        int minIndex = 0,maxIndex=0,size = nums.length;
        for(int i=0;i<size;i++){
            if(nums[minIndex] > nums[i])
                minIndex = i;
            if(nums[maxIndex] <= nums[i])
                maxIndex = i;
        }
        int ans = minIndex + (size-1-maxIndex);

        // if minIndex > maxIndex (the smallest number is on the right side of the largest number),
        // we need to do one less swap operation because swapping one of the largest/smallest number to its destination would swap the other.
        return minIndex > maxIndex ? ans-1 : ans;
    }
}
