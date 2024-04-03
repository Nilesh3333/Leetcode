import java.util.HashMap;

//Time and Space - O(n)
/*
* This code efficiently counts the number of pairs in the nums array where the difference between two elements equals the
* given target k. It utilizes a HashMap to store encountered elements and their frequencies.
* For each element i, it calculates its complement x (target - i) and checks if x exists in the HashMap with a frequency
* greater than 0. If found, it increments the count and decrements the frequency of x. Otherwise, it adds i to the HashMap.
* Finally, it returns the count of valid pairs found. This approach ensures linear time complexity O(n),
* where n is the number of elements in nums, and linear space complexity O(n)
* */
public class maxOperations1679 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;
        int ans = maxOperations(nums,k);
        System.out.println(ans);
    }
    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =0;
        for(int i:nums){
            int x = k-i;
            if(map.containsKey(x) && map.get(x)>0){
                map.put(x, map.get(x)-1);
                count++;
            }
            else
                map.put(i,map.getOrDefault(i,0)+1);
        }
        return count;
    }
}
