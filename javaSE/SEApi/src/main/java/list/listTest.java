package list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class listTest {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("b");
        l.add("c");
        l.add("d");

//        for (int i = 0; i < l.size(); i++) {
//            if (l.get(i).equals("b")) {
//                l.remove(i);
//                i--;
//            }
//        }

//        for (ListIterator<String> iter=l.listIterator(); iter.hasNext()) {
//            if (iter.next().equals("b")) {
//                iter.remove();
//            }
//        }

        l.removeIf(s -> s.equals("b"));

        System.out.println(l);

    }
}
