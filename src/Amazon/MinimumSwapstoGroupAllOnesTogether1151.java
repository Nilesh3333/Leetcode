package Amazon;

import java.util.Arrays;

//Time complexity: O(n)         Space complexity: O(1)
public class MinimumSwapstoGroupAllOnesTogether1151 {
    public static void main(String[] args) {
        int[] data = new int[]{1,0,1,0,1};
        System.out.println(minSwaps(data));
    }

    /*We will use two pointers left and right to maintain a sliding window of length ones, and while we check every window through
    the input array data, we would calculate the number of 1's in it as cnt_one and store the largest one as max_one.
    While the window is sliding through data, we want to maintain its length as ones.
    At the same time, we also want to update the number of 1's in the window by adding the new boundary data[right]
    and deducting the left boundary data[left].*/
    public static int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();  //calculating the number of 1's
        int maxOnes = 0,countOnes = 0,i=0,j=0;

        while(j<data.length){
            countOnes += data[j++];     //count the number of 1s in the given window
            if(j-i > ones)
                countOnes -= data[i++];  //the window will be the ones in line 18 so the we will get the number of swaps

            maxOnes = Math.max(maxOnes,countOnes);
        }
        return ones - maxOnes;
    }
}

