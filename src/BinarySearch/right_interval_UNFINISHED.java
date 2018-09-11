package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

//this is a bad solution.
public class right_interval_UNFINISHED {
     public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
     }

    class Solution {
        public int[] findRightInterval(Interval[] intervals) {
            TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
            int n = intervals.length;
            int[] res = new int[n];
            for(int i=0;i<n;i++){
                res[i] = -1;
            }
            if(n==1){
                res[0] = -1;
                return res;
            }
            for(int i = 0;i<n;i++){
                map.put(intervals[i].start,i);
            }
            Arrays.sort(intervals,new Comparator<Interval>(){
                public int compare(Interval a,Interval b){
                    return a.start-b.start;
                }
            });
            for(int i = 0;i<n;i++){
                int left = 0;
                int right = n-1;
                int mid = 0;
                while(left<right){
                    mid = left+(right-left)/2;
                    if(intervals[mid].start<intervals[i].end){
                        left = mid+1;
                    }
                    else{
                        right = mid;
                    }
                }
                if(intervals[left].start >= intervals[i].end){
                    res[map.get(intervals[i].start)] = map.get(intervals[left].start);
                }
            }
            return res;
        }
    }
}
