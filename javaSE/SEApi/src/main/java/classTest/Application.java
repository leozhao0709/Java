package classTest;

import java.util.ArrayList;
import java.util.Arrays;

class Application {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};
        Test test = new Test(arrayList);

        ArrayList<Integer> local = test.getTestList();
        System.out.println(local);

        local.add(4);
        System.out.println(local);
        System.out.println(test.getTestList());
    }
}
