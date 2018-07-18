package _041_080._058_lengthOfLastWord;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        Pattern pattern = Pattern.compile("\\s*(\\w+)$");
        Matcher matcher = pattern.matcher(s);

        String find = "";
        if (matcher.find()) {
            find = matcher.group(1);
        }

        return find.length();
    }
}
