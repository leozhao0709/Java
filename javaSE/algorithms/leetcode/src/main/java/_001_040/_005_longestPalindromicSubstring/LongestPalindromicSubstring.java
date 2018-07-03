package _001_040._005_longestPalindromicSubstring;

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        boolean[][] table = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            table[i][i] = true;

            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }

        for (int i = s.length() - 1; i >= 1; i--) {
            for (int j = i; j < s.length() - 1; j++) {
                if (table[i][j] && s.charAt(i-1) == s.charAt(j+1)) {
                    table[i-1][j+1] = true;

                    if (j+1 - (i-1) > end - start) {
                        end = j+1;
                        start = i-1;
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }
}
