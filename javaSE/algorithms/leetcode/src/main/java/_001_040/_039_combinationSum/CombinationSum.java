package _001_040._039_combinationSum;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        this.combinationSum(candidates, 0, candidates.length-1, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void combinationSum(int[] candidate, int start, int end, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(cur);
            res.add(temp);
            return;
        }

        if (target < 0 || start > end) {
            return;
        }

        for (int i = start; i <= end ; i++) {
            cur.add(candidate[i]);
            this.combinationSum(candidate, i, end, target-candidate[i], cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
