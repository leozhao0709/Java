package _041_080._049_groupAnagrams;

import java.util.*;

class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            char[] chars = curr.toCharArray();
            Arrays.sort(chars);
            if (map.containsKey(String.valueOf(chars))) {
                map.get(String.valueOf(chars)).add(curr);
            } else {
                map.put(String.valueOf(chars), new ArrayList<String>(){{
                    add(curr);
                }});
            }
        }

        for(String key: map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }
}
