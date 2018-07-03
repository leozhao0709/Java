package _001_040._014_longestCommonPrefix;

class LongestCommonPrefix {

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            sb = new StringBuilder(this.commonPrefix(sb.toString(), strs[i]));
        }

        return sb.toString();
    }

    private String commonPrefix(String str1, String str2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
