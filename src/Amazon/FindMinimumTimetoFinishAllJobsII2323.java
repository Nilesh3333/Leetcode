package Amazon;

import java.util.Arrays;

/*
Time Complexity: O(n log n)
Space Complexity: O(1)
*/
/*
Sort both arrays.
Smallest jobs is associated with the smallest workers.
Divide jobs by worker. We are doing the ceil so that if there is remainder we are adding one more day .
No remainder means exact days calculated.
Take the max of the current time and the time for that job and worker.
*/
public class FindMinimumTimetoFinishAllJobsII2323 {
    public static void main(String[] args) {
        int[] jobs = new int[]{5,2,4};
        int[] workers = new int[]{1,7,5};
        System.out.println(minimumTime(jobs,workers));
    }
    public static int minimumTime(int[] jobs, int[] workers) {
        int ans=0;
        int days;
        Arrays.sort(jobs);
        Arrays.sort(workers);
        for(int i=0;i<jobs.length;i++){
            days = (int) Math.ceil((double) jobs[i] /workers[i]);
            ans = Math.max(ans,days);
        }
        return ans;
    }
}
