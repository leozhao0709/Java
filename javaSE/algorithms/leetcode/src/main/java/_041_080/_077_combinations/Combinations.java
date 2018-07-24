package _041_080._077_combinations;

import java.util.ArrayList;
import java.util.List;

class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        this.combine(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void combine(int start, int end, int k, List<Integer> temp, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (start > end) {
            return;
        }

        for (int i = start; i <= end; i++) {
            temp.add(i);
            this.combine(i+1, end, k-1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
