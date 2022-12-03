class Pair {
    char ch;
    int freq;
    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    
    private void fillFreqArray(String s, int[] lowerC, int[] upperC, int[] digits) {
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                lowerC[s.charAt(i) - 'a']++;
            }
            else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                upperC[s.charAt(i) - 'A']++;
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                digits[s.charAt(i) - '0']++;
            }
        }
    }
    
    public String frequencySort(String s) {
        int[] lowerC = new int[26];
        int[] upperC = new int[26];
        int[] digits = new int[10];
        
        fillFreqArray(s, lowerC, upperC, digits);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> {
            return p2.freq - p1.freq;
        });
        
        for(int i=0; i<26; i++) {
            if(lowerC[i] != 0) {
                char ch = (char)(i + 'a');
                pq.add(new Pair(ch, lowerC[i]));
            }
            if(upperC[i] != 0) {
                char ch = (char)(i + 'A');
                pq.add(new Pair(ch, upperC[i]));
            }
            if(i<10 && digits[i] != 0) {
                char ch = (char)(i + '0');
                pq.add(new Pair(ch, digits[i]));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            Pair temp = pq.poll();
            char ch = temp.ch;
            int freq = temp.freq;
            
            for(int i=0; i<freq; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}