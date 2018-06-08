package stringToInteger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringToInteger {

    public int myAtoi(String str) {
        Pattern pattern = Pattern.compile("^\\s*(?<sign>[+|-]?)[0]*(?<number>\\d+)");
        Matcher matcher = pattern.matcher(str);

        long res = 0;
        int sign = 1;

        if (matcher.find()) {
            StringBuilder sb = new StringBuilder(matcher.group("number"));


            if (matcher.group("sign").equals("-")) {
                sign = -1;

                if (matcher.group("number").length() > 10) {
                    return Integer.MIN_VALUE;
                }
            }

            if (matcher.group("number").length() > 10) {
                return Integer.MAX_VALUE;
            }

            for (int i = 0; i < sb.length(); i++) {
                res = res * 10 + (sb.charAt(i) - '0');
            }

            res = res * sign;

            if (res >= Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
            }

            if (res <= Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
            }
        }
        
        return (int)res;
    }
}
