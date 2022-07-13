// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

class SortByProfit implements Comparator<Job> {
    public int compare(Job j1, Job j2) {
        return j2.profit - j1.profit;
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int[] ans = new int[2];
        
        int maxDL = Integer.MIN_VALUE;
        HashSet<Integer> isDayAvailable = new HashSet<>();
        for(Job job : arr) {
            isDayAvailable.add(job.deadline);
            maxDL = Math.max(maxDL, job.deadline);
        }
        
        Arrays.sort(arr, new SortByProfit());
        int[] isValidDay = new int[maxDL+1];
        Arrays.fill(isValidDay, -1);
        
        int noOfJobsDone = 0, profit = 0;
        
        for(Job job : arr) {
            int dl = job.deadline;
            while(dl > 0 && isValidDay[dl] != -1) {
                dl--;
            }
            if(dl == 0) continue;
            noOfJobsDone++;
            profit += job.profit;
            isValidDay[dl] = job.id;
        }
        
        ans[0] = noOfJobsDone;
        ans[1] = profit;
        return ans;
    }
}

