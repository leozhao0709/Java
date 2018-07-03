package _001_040._003_longestSubstringWithoutRepeatingChar;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepreat {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int start = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i]) && map.get(chars[i]) >= start) {
                maxLength = Math.max(maxLength, i - start);
                start =  map.get(chars[i]) + 1;
            }
            map.put(chars[i], i);
        }
        maxLength = Math.max(maxLength, chars.length - start);
        return maxLength;
    }
}
