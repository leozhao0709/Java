package longestPalindromicSubstring;

import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring longestPalindromicSubstring;

    @Before
    public void setUp() {
        this.longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    public void longestPalindrome() {
        String res = this.longestPalindromicSubstring.longestPalindrome("bananas");
        System.out.println(res);
    }
}