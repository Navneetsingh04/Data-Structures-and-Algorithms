/*
Job Sequencing Problem

Given an array, jobs[] where each job[i] has a jobid, deadline and profit associated with it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.
Note: jobs will be given in the form (jobid, deadline, profit) associated with that job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.

Examples :

Input: jobs[] = [(1,4,20), (2,1,1), (3,1,40), (4,1,30)]
Output: [2, 60]
Explanation: job1 and job3 can be done with maximum profit of 60 (20+40).
Input: jobs[] = [(1,2,100), (2,1,19), (3,2,27), (4,1,25), (5,1,15)]
Output: [2, 127]
Explanation: 2 jobs can be done with maximum profit of 127 (100+27).
Constraints:
1 <=  jobs.size <= 105
1 <= deadline, jobid <= jobs.size
1 <= profit <= 500
*/

import java.util.Arrays;

public class JobSequenceingProblem {
    static class Job{
        int id,profit,deadline;
        Job(int x,int y,int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    public static int[] jobScheduling(Job jobs[]){
        int n = jobs.length;
        Arrays.sort(jobs,(a,b) -> (b.profit - a.profit));
        int maxi = 0;
        for(int i = 0;i<n;i++){
            if(jobs[i].deadline > maxi){
                maxi = jobs[i].deadline;
            }
        }
        int ans[] = new int[maxi+1];
        for(int i = 1;i<=maxi;i++){
            ans[i] = -1;
        }
        int count = 0,jobProfit = 0;
        for(int i = 0;i<n;i++){
            for(int j = jobs[i].deadline;j>0;j--){
                if(ans[j] == -1){
                    ans[j] = i;
                    count++;
                    jobProfit += jobs[i].profit;
                    break;
                }
            }
        }
        int result[] = new int[2];
        result[0] = count;
        result[1] = jobProfit;
        return result;
    }
    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1,4,20);
        arr[1] = new Job(2,1,10);
        arr[2] = new Job(3,2,40);
        arr[3] = new Job(4,2,30);
        int ans[] = jobScheduling(arr);
        System.out.println(Arrays.toString(ans));
    }
}
