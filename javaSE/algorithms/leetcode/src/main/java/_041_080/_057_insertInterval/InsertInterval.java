package _041_080._057_insertInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();

        intervals.add(newInterval);
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
