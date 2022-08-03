class MyCalendar {
    TreeMap<Integer, Integer> calendar = null;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        Integer ceilingKey = calendar.ceilingKey(start);
        
        if(floorKey != null && start < calendar.get(floorKey)) return false;
        
        if(ceilingKey != null && end > ceilingKey) return false;
        
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */