package _041_080._056_mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();

        Collections.sort(intervals, (i1, i2) -> i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end
        );

        for(Interval interval: intervals) {
            if (res.size() == 0) {
                res.add(interval);
            } else {
                Interval last = res.get(res.size() - 1);
                if (interval.start <= last.end && interval.end > last.end) {
                    res.set(res.size() - 1, new Interval(last.start, interval.end));
                } else if (interval.start > last.end) {
                    res.add(interval);
                }
            }
        }

        return res;
    }
}
