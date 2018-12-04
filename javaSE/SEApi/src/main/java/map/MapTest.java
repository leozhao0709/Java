package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class MapTest {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> linkedMap = new LinkedHashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        addElements(hashMap);
        addElements(linkedMap);
        addElements(treeMap);

        System.out.println("hashMap: " + hashMap);
        System.out.println("linkedMap: " + linkedMap);
        System.out.println("treeMap: " + treeMap);
    }

    private static void addElements(Map<String, String> map) {
        map.put("ops", "a1");
        map.put("aac", "a1");
        map.put("bbs", "b1");
        map.put("xbs", "b1");
        map.put("ccx", "c1");
    }
}
