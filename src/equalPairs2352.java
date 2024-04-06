/*
* Time Complexity:
The nested loops to iterate through the grid have a time complexity of O(n^2), where n is the size of the grid.
Within these loops, the operations involving HashMap (put, getOrDefault, containsKey) generally have an average time complexity of O(1).
Therefore, the overall time complexity is O(n^2) considering the size of the grid.

Space Complexity:
The space complexity is also O(n^2) due to the HashMap storing the frequencies of rows in the grid.
Each row in the grid is stored once in the hashmap, resulting in space proportional to the size of the grid.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class equalPairs2352 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int count=0;
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        /*Rows -- iterate through each row in the grid. For each row, created a list to store its elements and then put that list
        into the HashMap and increment the count of the corresponding row each time it's encountered.*/
        for(int[] arr:grid){
            List<Integer> list = new ArrayList<>(arr.length);
            for(int i:arr)
                list.add(i);
            map.put(list, map.getOrDefault(list,0)+1);
        }
        /*Columns: iterated through each column in the grid. For each column,created a list to store its elements.
         then check if the HashMap contains this list. If it does,incrementing the count by the frequency of that row stored
        in the HashMap.*/
        for(int i=0;i<grid.length;i++){
            List<Integer> list = new ArrayList<>(grid.length);
            for(int j=0;j<grid.length;j++)
                list.add(grid[j][i]);
            if(map.containsKey(list))
                count = count+ map.get(list);
        }
        return count;
    }
}
