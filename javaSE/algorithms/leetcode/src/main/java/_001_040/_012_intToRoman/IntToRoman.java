package _001_040._012_intToRoman;

class IntToRoman {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) {
            if (num >= nums[i]) {
                sb.append(symbol[i]);
                num -= nums[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
