package longestPalindromicSubstring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new Solution();
    }

    @Test
    public void longestPalindrome() {
        String res = this.solution.longestPalindrome("bananas");
        System.out.println(res);
    }
}