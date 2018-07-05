package _001_040._028_strStr;

class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }


        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for (j = i; j < i+ needle.length(); j++) {
                    if (j >= haystack.length() || haystack.charAt(j) != needle.charAt(j - i)) {
                        break;
                    }
                }

                if (j == i + needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
