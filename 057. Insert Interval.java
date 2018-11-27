/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        boolean ifound = false;
        boolean jfound = false;
        int i = 0;
        int j = 0;
        int start = newInterval.start;
        int end = newInterval.end;
        
        // Base cases
        if (intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        };
        if (end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals; 
        }
        if (start > intervals.get(intervals.size()-1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        
        
        // Find locations of intervals new interval is within
        // i is starting interval index, j is ending interval
        for (int v = 0; v<intervals.size(); v++){
            Interval inter = intervals.get(v);
            if (!ifound) {
                if (inter.end >= start) {
                    i = v;
                    ifound = true;
                }
            }
            if (inter.end >= end){
                if (inter.start <= end) j = v;
                else j = v-1;
                jfound = true;
                break;
            }
        }
        if (!jfound) j = intervals.size()-1;
        
        // Create the new interal and remove those being merged
        int newStart = Math.min(newInterval.start, intervals.get(i).start);
        int newEnd = Math.max(newInterval.end, intervals.get(j).end);
        for (int del = j; del>=i ; del--){
            intervals.remove(i);
        }
        intervals.add(i, new Interval(newStart, newEnd));
        
        return intervals;
    }
}