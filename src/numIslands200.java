/*
    Iterate Through the Grid: Start by iterating through each cell in the grid.

    Check for Land: For each cell, if it's a '1' (land), then it's the start of an island.

    Explore the Island: Once you find a land cell, perform a depth-first search (DFS) or breadth-first search (BFS) to explore the entire island. During this traversal, mark visited cells to avoid revisiting them.

    Identify Connected Land Cells: During the traversal, consider adjacent land cells (up, down, left, right) as part of the same island. Continue traversing until you reach water (cell value '0') or until you've visited all connected land cells.

    Count Islands: Increment the island count every time you encounter a new island (i.e., a land cell that hasn't been visited yet).

    Repeat for All Cells: Continue this process for all cells in the grid.

Space Complexity:

count variable: Constant space (O(1)) as it holds a single integer value regardless of the grid size.
Recursive calls in checkIsland: In the worst case, where the entire grid is filled with '1's and each cell is connected to its neighbors, the checkIsland function can be called recursively up to m * n times (number of cells). Each recursive call creates a new activation record on the call stack, which typically stores local variables and return addresses. The size of these activation records is usually constant, but it depends on the compiler and architecture. Therefore, the space complexity for recursive calls is considered O(m * n) in the worst case.
Time Complexity:

Outer loop: Iterates m times (number of rows).
Inner loop: Iterates n times (number of columns) for each outer loop iteration.
checkIsland calls: In the worst case (entire grid filled with connected '1's), each cell triggers a checkIsland call, which can explore all connected '1' cells in the worst case, potentially leading to O(m * n) time complexity for a single call.
Overall Time Complexity:

The outer loops contribute O(m * n) time complexity.
The nested checkIsland calls, in the worst case, can add up to O(m * n) for each cell, resulting in a potential total of O(m^2 * n^2). However, this worst case only occurs when the entire grid consists of connected '1's.
In more realistic scenarios where islands are isolated or have limited connections, the checkIsland calls won't explore the entire grid for each cell. The actual time complexity will depend on the distribution of '1's in the grid.

Therefore, the time complexity can be expressed as:

Best case: O(m * n) (if there are no islands or islands are very small)
Average case: Likely somewhere between O(m * n) and O(m^2 * n^2), depending on the typical size and connectivity of islands
Worst case: O(m^2 * n^2) (entire grid filled with connected '1's)
In summary:

Space complexity: O(1) + O(m * n) (worst case for recursive calls)
Time complexity: O(m * n) to O(m^2 * n^2) depending on the input grid*/

public class numIslands200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
    }
    private static int numIslands(char[][] grid) {
        int count=0;
        int m = grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    checkIsland(grid,i,j);
                }
            }
        }
        return count;
    }

    private static void checkIsland(char[][] grid, int i, int j) {
        int m = grid.length;
        int n=grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0')  //baseCase
            return;
        grid[i][j] = '0';
        checkIsland(grid,i-1,j);
        checkIsland(grid,i+1,j);
        checkIsland(grid,i,j-1);
        checkIsland(grid,i,j+1);
    }
}
