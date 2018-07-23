package _041_080._066_plusOne;

import java.util.Arrays;

class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] + carry == 10) {
                carry = 1;
                res[i+1] = 0;
            } else {
                res[i+1] = digits[i] + carry;
                carry = 0;
            }
        }

        if (carry == 1) {
            res[0] = 1;
            return res;
        }

        return Arrays.copyOfRange(res, 1, res.length);
    }
}
