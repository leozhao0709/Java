package _001_040._040_combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        this.combinationSum2(candidates, 0, candidates.length-1, target, res, new ArrayList<>());
        return res;
    }

    private void combinationSum2(int[] candidates, int start, int end, int target, List<List<Integer>> res, List<Integer> cur) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(cur);
            res.add(temp);
            return;
        }

        if (start > end || target < 0) {
            return;
        }

        for (int i = start; i <= end ; i++) {
            if (i != start && candidates[i] == candidates[i-1]) {
                continue;
            }
            cur.add(candidates[i]);
            this.combinationSum2(candidates, i + 1, end, target - candidates[i], res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
