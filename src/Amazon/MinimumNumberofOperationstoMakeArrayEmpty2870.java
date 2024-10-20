package Amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//Time and Space - 0(n)

/** count = 3
 3 - 3 = 0
 operations required = 1
 * count = 6
 6 - 3 - 3  = 0
 operations required = 2
 * count = 9
 9 - 3 - 3 - 3  = 0
 operations required = 3
 * count = 12
 12 - 3 - 3 - 3 - 3  = 0
 operations required = 4

 count = 4
 4 - 2 - 2 = 0 -> eliminate two pairs
 operations required = 2
 * count = 7
 7 - 2 - 2 = 3 -> eliminate two pairs
 3 - 3 = 0 -> eliminate remaining triplets
 operations required = 3
 * count = 10
 10 - 2 - 2 = 6 -> eliminate two pairs
 6 - 3 - 3 = 0 -> eliminate remaining triplets
 operations required = 4
 * count = 13
 13 - 2 - 2 = 9 -> eliminate two pairs
 9 - 3 - 3 - 3 = 0 -> eliminate remaining triplets
 operations required = 5

 * count = 5
 5 - 2 = 3 -> eliminate one pair
 3 - 3 = 0 -> eliminate remaining triplets
 operations required = 2
 * count = 8
 8 - 2 = 6 -> eliminate one pair
 6 - 3 - 3 = 0 -> eliminate remaining triplets
 operations required = 3
 * count = 11
 11 - 2 = 9 -> eliminate one pair
 9 - 3 - 3 - 3 = 0 -> eliminate remaining triplets
 operations required = 4
 * count = 14
 14 - 2 = 12 -> eliminate one pair
 12 - 3 - 3 - 3 - 3 = 0 -> eliminate remaining triplets
 operations required = 5

 Count	Operations required to remove elements
 1	return -1
 2	1
 3	1
 4	2
 5	2
 6	2
 7	3
 8	3
 9	3
 10	4
 11	4
 12	4

 From the information presented in this table, we can deduce that the number of operations needed to remove a
 total of count elements of a given kind is represented by the expression ceil(count / 3), where the ceil method rounds up the decimal result of count / 3.
 Except in the scenario where the count of the element is 1, making it impossible to remove elements of that kind,
 in which case we should return -1.*/
public class MinimumNumberofOperationstoMakeArrayEmpty2870 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,2,2,4,2,3,4};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        var counter = new HashMap<Integer, Integer>();
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int c: counter.values()) {
            if (c == 1) {
                return -1;
            }
            ans += (int) Math.ceil( (double) c / 3);
        }
        return ans;
                }
    }
