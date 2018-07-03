package _001_040._022_generateParentheses;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        this.generateParenthesis(n, 0, "", res);
        return res;
    }

    private void generateParenthesis(int left, int right, String current, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(current);
        }

        if (left > 0) {
            this.generateParenthesis(left-1, right+1, current + "(", res);
        }

        if (right > 0) {
            this.generateParenthesis(left, right-1, current + ")", res);
        }
    }
}
