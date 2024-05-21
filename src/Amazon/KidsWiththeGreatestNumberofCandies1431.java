package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time and Space Complexity - O(N)
public class KidsWiththeGreatestNumberofCandies1431 {
    public static void main(String[] args) {
        int candies[] = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> answer= kidsWithCandies(candies,extraCandies);
        for(Boolean ans:answer){
            System.out.println(ans);
        }
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        if(candies.length == 0)
            return list;
        int maxValue = Arrays.stream(candies).max().getAsInt();
        for(int candie : candies)
            list.add(candie + extraCandies >= maxValue);
        return list;
    }
}
