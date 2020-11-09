For thos where we need to insert a new interval to those intervals that are sorted.
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval toinsert = newInterval;
        if(intervals.size()==0){
            intervals.add(toinsert);
            return intervals;
        }
        int i=0;
        while(i<intervals.size()){
            Interval curr = intervals.get(i);
            if(curr.end<toinsert.start){
                i++;
                continue;
            }
            else if(curr.start>toinsert.end){
                intervals.add(i,toinsert);
                break;
            }
            else{
                toinsert.start = Math.min(toinsert.start,curr.start);
                toinsert.end = Math.max(toinsert.end,curr.end);
                intervals.remove(i);
            }
        }
        
        if(i==intervals.size()){
            intervals.add(newInterval);
        }
        return intervals;
        
        
    }
}
