package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Complexity Time complexity: O(nlogn) Space complexity: O(n)

public class MergeIntervals56 {

    public static void main(String[] args) {
        int[][] intervals =  {{1,3},{2,6},{8,10},{15,18}};
        int[][] answer = merge(intervals);
        for(int[] ans: answer)
            for(int a : ans)
                System.out.println(a);
    }

    public static int[][] merge(int[][] intervals) {
        /*Integer.compare(a[0], b[0]): This line compares the first element (a[0]) of interval a with the first element (b[0]) of interval b.
        It uses the Integer.compare() method, which returns an integer value indicating the comparison result:
        Negative value if a[0] is less than b[0].
        Zero if a[0] is equal to b[0].
        Positive value if a[0] is greater than b[0].*/
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> interval =  new ArrayList<>();
        int size = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];

        /*Merging Intervals: It then iterates over the sorted intervals. For each interval, if there is an overlap with the previous interval (determined by comparing the end time of the previous interval with the start time of the current interval),
        it updates the end time of the merged interval to the maximum of the end times of the overlapping intervals.
        Storing Merged Intervals: After processing all intervals, it adds the merged interval (start time of the first interval and end time of the last interval in the merged group) to a list.*/
        for(int i=1;i<size;i++){
            if(end >= intervals[i][0]){
                if(end < intervals[i][1])
                    end = intervals[i][1];
                continue;
            }
            interval.add(new int[]{start,end});
            start = intervals[i][0];
            end = intervals[i][1];
        }
        interval.add(new int[]{start,end});
        int[][] ans = new int[interval.size()][];
        interval.toArray(ans);
        return ans;
    }
}
