package _041_080._076_minimumWindowSubstring;


class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] tMap = new int[127];
        int[] sMap = new int[127];

        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }
        
        int i = 0;
        int count = 0;
        int start = 0;
        int begin = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        while (i < s.length()) {
            sMap[s.charAt(i)]++;

            if (tMap[s.charAt(i)] >= sMap[s.charAt(i)]) {
                count++;
            }

            // if find a t
            if (count == t.length()) {
//                while (start < s.length() && tMap[s.charAt(start)] == 0) { // this is bad!!!
                while (start < s.length() && tMap[s.charAt(start)] < sMap[s.charAt(start)]) {
                    sMap[s.charAt(start)]--;
                    start++;
                }

                if (i - start + 1 < min) {
                    min = i - start + 1;
                    begin = start;
                    end = i;
                }

                sMap[s.charAt(start)]--;
                start++;
                count--;
            }

            i++;
        }
        System.out.println(begin);
        System.out.println(end);
        return min == Integer.MAX_VALUE? "" : s.substring(begin, end+1);
    }
}
