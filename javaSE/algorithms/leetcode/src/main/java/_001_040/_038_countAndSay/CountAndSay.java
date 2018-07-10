package _001_040._038_countAndSay;

class CountAndSay {

    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        int i = 1;
        StringBuilder sb = new StringBuilder("1");

        while (i < n) {
            StringBuilder prev = new StringBuilder(sb.toString());
            sb = new StringBuilder();
            for (int j = 0; j < prev.length(); j++) {
                int count = 1;
                char say = prev.charAt(j);

                while (j + 1 < prev.length() && prev.charAt(j) == prev.charAt(j+1)) {
                    count++;
                    j++;
                }

                sb.append(count).append(say);
            }

            i++;
        }

        return sb.toString();
    }

}
