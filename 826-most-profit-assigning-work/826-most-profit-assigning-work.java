class JobDetail {
    int difficulty;
    int profit;
    public JobDetail(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
}

class Solution {
    
    private int getUpperBound(int ability, ArrayList<JobDetail> list) {
        int low = 0, high = list.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            
            if(list.get(mid).difficulty > ability) {
                high = mid - 1;
            }
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length, W = worker.length;
        
        ArrayList<JobDetail> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(new JobDetail(difficulty[i], profit[i]));
        }
        list.sort((o1, o2) -> {
            return o1.difficulty - o2.difficulty;
        });
        
        int totalProfit = 0;
        for(int j=0; j<W; j++) {
            //for each worker, we need to find the max profit
            int high = getUpperBound(worker[j], list);
            if(high != -1) {
                int maxP = Integer.MIN_VALUE;
                for(int i=0; i<=high; i++) {
                    maxP = Math.max(maxP, list.get(i).profit);
                }
                totalProfit += maxP;
            }
        }
        return totalProfit;
    }
}