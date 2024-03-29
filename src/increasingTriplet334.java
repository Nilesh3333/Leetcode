//Time Complexity - O(n), Space - O(1)
public class increasingTriplet334 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,0,4,10,6};
        boolean ans = increasingTriplet(nums);
        System.out.println(ans);
    }

    //we can use a simple approach involving two variables to keep track of the smallest and second smallest elements
    // encountered so far. If we find a third element greater than both of these, we can return true.
    //If we encounter any element smaller than the smallest or between the smallest and second smallest, we update our variables accordingly.
    public static boolean increasingTriplet(int[] nums) {
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;
        for(int i:nums){
            if(i <= lowest)
                lowest = i;
            else if(i<= secondLowest)
                secondLowest =i;
            else
                return true;
        }
        return false;
    }
}
