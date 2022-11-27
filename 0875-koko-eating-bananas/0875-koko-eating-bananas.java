class Solution {
    
    private long getTimeAtMidBananaPerHour(int speed, int[] piles) {
        long hourTaken = 0;
        for(int i=0; i<piles.length; i++) {
            // time to eat piles[i] banana at speed = speed ==> piles[i] / speed(floor value)
            if(piles[i] % speed != 0) {
                hourTaken += 1;
            }
            hourTaken += (piles[i] / speed);
        }
        return hourTaken;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        // Range --> [low, high] // speed of eating bananas
        // koko can eat at a speed which will definitely belongs to the defined range
        int low = 1;
        int high = 0;
        for(int e : piles) {
            high = Math.max(high, e);
        }
        
        int minHourTaken = 0;
        while(low <= high) {
            int mid = (low + high) / 2; // if speed is mid(banana per hour)
            
            long hourTaken = getTimeAtMidBananaPerHour(mid, piles);
            
            if(hourTaken <= h) {
                minHourTaken = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return minHourTaken;
    }
}