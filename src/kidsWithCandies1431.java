import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time and space : O(n)
public class kidsWithCandies1431 {
    public static void main(String[] args) {
        int candies[] = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> answer= kidsWithCandies(candies,extraCandies);
        for(Boolean ans:answer){
            System.out.println(ans);
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = getMaxNumber(candies);
        for(int candie : candies){
            list.add(candie + extraCandies >= max ? true : false); //or list.add(candie + extraCandies >= max);
        }
        return list;
    }

    private static int getMaxNumber(int[] candies) {
        //it will return the max value from the array
        return Arrays.stream(candies).max().getAsInt(); //The getAsInt() method is part of the OptionalInt class in Java. It is used to retrieve the value stored within an OptionalInt object.
        /*
        * or another way to get the max value
        * List<Integers> list = Arrays.asList(candies);
        * return Collections.max(list);
        * */
    }
}
