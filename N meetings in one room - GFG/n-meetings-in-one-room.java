// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class MeetingDetails {
    int s;
    int e;
    public MeetingDetails(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

class SortByEnd implements Comparator<MeetingDetails> {
    public int compare(MeetingDetails m1, MeetingDetails m2) {
        return m1.e - m2.e;
    }
}

class Solution  {
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<MeetingDetails> md = new ArrayList<>();
        for(int i=0; i<n; i++) {
            md.add(new MeetingDetails(start[i], end[i]));
        }
        
        Collections.sort(md, new SortByEnd());
        
        
        int possibleMeetings = 0;
        int lastEnd = -1;
        
        for(int i=0; i<n; i++) {
            MeetingDetails currMeeting = md.get(i);
            
            int s = currMeeting.s;
            int e = currMeeting.e;
            
            if(s > lastEnd) {
                possibleMeetings++;
                lastEnd = e;
            }
            
        }
        
        return possibleMeetings;
    }
}
