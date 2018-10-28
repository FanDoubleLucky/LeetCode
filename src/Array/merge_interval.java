package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_interval {
    public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
    }

    class Solution_Time {
        public List<Interval> merge(List<Interval> intervals) {
            // sort start&end
            int n = intervals.size();
            int[] starts = new int[n];
            int[] ends = new int[n];
            for (int i = 0; i < n; i++) {
                starts[i] = intervals.get(i).start;
                ends[i] = intervals.get(i).end;
            }
            Arrays.sort(starts);
            Arrays.sort(ends);
            // loop through
            List<Interval> res = new ArrayList<Interval>();
            for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
                if (i == n - 1 || starts[i + 1] > ends[i]) {
                    res.add(new Interval(starts[j], ends[i]));
                    j = i + 1;
                }
            }
            return res;
        }
    }

    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class Solution_Space {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals == null || intervals.size() == 0){return new ArrayList<Interval>();}
            intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
            List<Interval> res = new ArrayList<Interval>();
            Interval tuple = intervals.get(0);
            for(int i=1;i<intervals.size();i++){
                Interval in = intervals.get(i);
                if(tuple.end>=in.start){
                    tuple.end = Math.max(tuple.end, in.end);
                }
                else{
                    res.add(tuple);
                    tuple = in;
                }
            }
            res.add(tuple);
            return res;
        }
    }
}
