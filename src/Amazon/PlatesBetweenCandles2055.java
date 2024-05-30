package Amazon;
import java.util.TreeSet;

public class PlatesBetweenCandles2055 {
    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        int[] ans = platesBetweenCandles(s,queries);
        for(int i : ans)
            System.out.println(i);
    }

    /*Time Complexity:

    Prefix Sum Calculation (Loop 1):
        Iterating through the string s to calculate the prefix sum array prefixSum takes O(n), where n is the length of the string.
        Each iteration involves constant-time operations, so the total time complexity for this part is O(n).

    Finding Nearest Left Pipe (Loop 2):
        Again, iterating through the string s to calculate the nearest left pipe index array left takes O(n), where n is the length of the string.
        Each iteration involves constant-time operations, so the total time complexity for this part is O(n).

    Finding Nearest Right Pipe (Loop 3):
        Similar to the previous loop, iterating through the string s to calculate the nearest right pipe index array right takes O(n).
        Each iteration involves constant-time operations, so the total time complexity for this part is also O(n).

    Processing Queries (Loop 4):
        Processing each query involves constant-time operations, so the time complexity for this part is O(q), where q is the number of queries.

    Overall, the time complexity is dominated by the linear iterations over the string s, resulting in a time complexity of
     O(n + q).

Space Complexity:

    Prefix Sum Array:
        The prefixSum array requires O(n) space to store the prefix sum values.

    Nearest Left Pipe Array:
        The left array also requires O(n) space to store the nearest left pipe indices.

    Nearest Right Pipe Array:
        The right array requires O(n) space to store the nearest right pipe indices.

    Result Array:
        The ans array requires O(q) space to store the results of each query.

Overall, the space complexity is O(n + q) due to the space required for the arrays storing prefix sums, nearest pipe indices, and the result array.*/

    //Check Image 2055.jpeg
    public static int[] platesBetweenCandles(String s, int[][] queries) {

        int[] prefixSum = new int[s.length()];
        prefixSum[0] = s.charAt(0) == '*' ? 1 : 0;
        for(int i=1;i<s.length();i++)
            prefixSum[i] =prefixSum[i-1] + (s.charAt(i) == '*' ? 1: 0);

        int[] left = new int[s.length()];
        left[0] = s.charAt(0) == '|' ? 0 : -1;
        for(int i=1;i<s.length();i++)
            left[i] = s.charAt(i) == '|' ? i : left[i-1];

        int[] right = new int[s.length()];
        right[s.length()-1] = s.charAt(s.length()-1) == '|' ? s.length()-1 : -1;
        for(int i=s.length()-2;i>=0;i--)
            right[i] = s.charAt(i) == '|' ? i : right[i+1];

        int[] ans= new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int startIndex=queries[i][0];
            int endIndex=queries[i][1];
            int si=right[startIndex];  //y we are getting the index from right here because the nearest | will be in the right for the low index
            int ei=left[endIndex];
            if(si<0 || ei<0){
                continue;
            }
            ans[i]= Math.max(prefixSum[ei] - prefixSum[si], 0);
        }
        return ans;

    }

    //Time complexity: O(s + q * log s)  and Space complexity: O(s + q)
    public static int[] platesBetweenCandles1(String s, int[][] queries) {
        TreeSet<Integer> candles = new TreeSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '|')
                candles.add(i);
        }
        int[] prefixSum = new int[s.length()];
        prefixSum[0] = s.charAt(0) == '*' ? 1 : 0;
        for(int i=1;i<s.length();i++)
            prefixSum[i] = s.charAt(i) == '*' ? 1+prefixSum[i-1] : prefixSum[i-1];

        int[] ans =  new int[queries.length];
        int j=0;
        for(int[] i : queries){
            Integer low = candles.ceiling(i[0]);
            Integer high = candles.floor(i[1]);
            if(low == null || high == null || low >= high || low > i[1] || high < i[0]){
                ans[j++] = 0;
                continue;
            }
            ans[j++] = prefixSum[high] - prefixSum[low];
        }
        return ans;
    }
}
