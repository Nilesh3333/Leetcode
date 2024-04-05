//Time Complexity - O(n),  Space Complexity- O(1)
public class largestAltitude1732 {
    public static void main(String[] args) {
        int[] gain= new int[]{-4,-3,-2,-1,4,3,2};
        int ans = largestAltitude(gain);
        System.out.println(ans);

    }
    private static int largestAltitude(int[] gain) {
        int sum=0,maxSum=0;
        for(int i:gain){
            maxSum = Math.max(maxSum,sum);
            sum = sum +i;
        }
        return Math.max(maxSum,sum);
    }
}
