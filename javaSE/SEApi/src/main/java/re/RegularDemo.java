package re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegularDemo {

    public static void main(String[] args) {
        String testStr = "8216-3514-qwd";
        Pattern pattern = Pattern.compile("(?<first>\\d+)(?<joinOper>.)(?<Second>\\d+)");
        Matcher matcher = pattern.matcher(testStr);

        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group("first"));
            System.out.println(matcher.group("joinOper"));
            System.out.println(matcher.group("Second"));
        }
    }
}
