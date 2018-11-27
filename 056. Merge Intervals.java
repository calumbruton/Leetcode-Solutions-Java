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
    public List<Interval> merge(List<Interval> intervals) {
        int i = 0;
        while (i < intervals.size()-1){
            Interval interval1 = intervals.get(i);
            Interval interval2 = intervals.get(i+1);


            if (interval1.end >= interval2.start){

                // If the next interval starts and ends before the current swap them
                if (interval1.end > interval2.end && interval1.start>interval2.start){
                    intervals.add(i, interval2);
                    intervals.remove(i+2);   
                    i = 0;
                }

                // Merge the intervals otherwise
                else {
                    int start = Math.min(interval1.start, interval2.start);
                    int end = Math.max(interval1.end, interval2.end);
                    Interval newInterval = new Interval(start, end);
                    intervals.remove(i);
                    intervals.remove(i);
                    intervals.add(i, newInterval);
                    i = 0;
                }
            }

            // The intervals don't overlap 
            else{
                i++;
            }
        }
        return intervals;
    }
}