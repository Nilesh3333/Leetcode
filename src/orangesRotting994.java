/*Approach for this Problem:
Create a visited grid to store the state of the cell (fresh, rotten, or empty).
Initialize a queue to store the rotten oranges and count the number of fresh oranges.
Check if there are no fresh oranges, return 0, or if there are no rotten oranges, return -1.
Loop while the queue is not empty.
    a. Store the size of the queue.
    b. Loop through the size of the queue.
        i. Get the front cell of the queue.
        ii. Check all four directions of the cell to see if there are any fresh oranges.
        iii. If there is a fresh orange, change its state to rotten and decrement the count of fresh oranges, and push the cell into the queue.
    c. Increment the minutes.
If there are no fresh oranges, return the minutes - 1. //-1 for the dry run
If there are still fresh oranges, return -1.

Time complexity: O(m*n)
Space complexity: O(m*n)

*/

import java.util.LinkedList;
import java.util.Queue;

public class orangesRotting994 {
    public static void main(String[] args) {
       int[][] grid= new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int minutes = 0;
        int[][] visited = grid;
        int m = grid.length;
        int n = grid[0].length;
        int countFreshOranges = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] == 2)
                    queue.add(new int[]{i,j});
                if(visited[i][j] == 1)
                    countFreshOranges++;
            }
        }
        if(countFreshOranges == 0)
            return 0;
        if(queue.isEmpty())
            return -1;

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] rotten = queue.poll();
                int x = rotten[0];
                int y = rotten[1];
                for(int[] dir:directions){
                    int i = x+dir[0];
                    int j = y+dir[1];
                    if(i >= 0 && i<m && j>=0 && j<n && visited[i][j] ==1){
                        visited[i][j] = 2;
                        countFreshOranges--;
                        queue.add(new int[]{i,j});
                    }
                }
            }
            minutes++;
        }
        if(countFreshOranges == 0)
            return minutes-1 ; /*.By the time you've rotten all the oranges. Your queue still has last set of rotten oranges,
            your answer is found at this stage but the loop will run one more time to empty the queue and come out.
            But in this extra iteration your minutes increases by 1. */
        return -1;
    }
}
