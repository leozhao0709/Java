package _001_040._022_generateParentheses;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

    private GenerateParentheses generateParentheses;

    @Before
    public void setUp() throws Exception {
        this.generateParentheses = new GenerateParentheses();
    }

    @Test
    public void generateParenthesis() {
        int n = 3;
        List<String> res = this.generateParentheses.generateParenthesis(n);
        System.out.println(Arrays.toString(res.toArray()));
    }
}