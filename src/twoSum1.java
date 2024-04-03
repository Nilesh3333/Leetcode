//Time and Space Complexity - O(n)

import java.util.HashMap;

/*
* The logic iterates through the array, checking if the complement of the current element (i.e., target - current element)
* exists in the hashmap. If found, it returns the indices of the two elements that sum up to the target.
* If not found, it stores the current element and its index in the hashmap for future reference.
* */
public class twoSum1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] ans = twoSum(nums,target);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans= new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            else
                map.put(nums[i],i);
        }
        return ans;
    }
}
