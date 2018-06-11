package _001_040.zigzagConversion;

class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            // 第一列
            for (int j = 0; j < numRows && i < s.length(); j++) {
                sbs[j].append(s.charAt(i++));
            }
            // other column
            for (int j = numRows-2; j >= 1 && i < s.length() ; j--) {
                sbs[j].append(s.charAt(i++));
            }
        }

        for (int j = 1; j < sbs.length; j++) {
            sbs[0].append(sbs[j]);
        }

        return sbs[0].toString();
    }
}
