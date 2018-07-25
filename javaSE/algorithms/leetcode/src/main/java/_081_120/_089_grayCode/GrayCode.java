package _081_120._089_grayCode;

import java.util.ArrayList;
import java.util.List;

class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();

        if (n == 0) {
            res.add(0);
            return res;
        }

        res.add(0);
        res.add(1);

        for (int i = 2; i <= n; i++) {
            int highestBit = 1 << i-1;
            for (int j = res.size()-1; j >= 0; j--) {
                res.add(highestBit + res.get(j));
            }
        }

        return res;
    }
}
