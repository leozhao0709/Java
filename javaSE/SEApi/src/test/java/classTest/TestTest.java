package classTest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestTest {

    private classTest.Test test;

    @Before
    public void setUp() throws Exception {
        this.test = new classTest.Test(new ArrayList<Integer>(){{
            add(5);
            add(6);
            add(7);
        }});
    }

    @Test
    public void getTestList() {
        ArrayList<Integer> list = this.test.getTestList();
        System.out.println(Arrays.toString(list.toArray()));
        list.add(8);
        list.add(9);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(this.test.getTestList().toArray()));
    }
}