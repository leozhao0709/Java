package _001_040.romanToInt;

import java.util.HashMap;
import java.util.Map;

class RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int res = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if (map.get(curr) <= map.get(prev)) {
                res += map.get(curr);
            } else {
                res = res - 2 * map.get(prev) + map.get(curr);
            }
        }

        return res;
    }
}
