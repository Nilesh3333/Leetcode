package Amazon;
/*
Bottom-Up dynamic Programming  -
The first letter of each string is the same.
The first letter of each string is different.

For the first case, we solve the subproblem that removes the first letter from each, and add 1.In the grid, this subproblem is always the diagonal immediately down and right.
For the second case, we consider the subproblem that removes the first letter off the first word, and then the subproblem that removes the first letter off the second word.
    In the grid, these are subproblems immediately right and below.

Putting this all together, we iterate over each column in reverse, starting from the last column (we could also do rows, the final result will be the same).
For a cell (row, col), we look at whether or not text1.charAt(row) == text2.charAt(col) is true. if it is, then we set grid[row][col] = 1 + grid[row + 1][col + 1].
Otherwise, we set grid[row][col] = max(grid[row + 1][col], grid[row][col + 1]).
For ease of implementation, we add an extra row of zeroes at the bottom, and an extra column of zeroes to the right.

Check the Image in the folder for example if same character taking the diagonal and adding 1 or else max of right or left
Time complexity : O(M⋅N) Space complexity : O(M⋅N)
*/
public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        // Make a grid of 0's with text2.length() + 1 columns and text1.length() + 1 rows.
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        // Iterate up each column, starting from the last one.
        for(int col=text2.length()-1;col >=0;col--){
            for(int row=text1.length()-1;row >=0;row--){
                // If the corresponding characters for this cell are the same...
                if(text1.charAt(row) == text2.charAt(col))
                    dp[row][col] = 1+dp[row+1][col+1];
                else {
                    dp[row][col] = Math.max(dp[row+1][col],dp[row][col+1]);
                }
            }
        }
        // The original problem's answer is in dp_grid[0][0]. Return it.
        return dp[0][0];
    }
}
