package big;

import java.math.BigDecimal;

class BigDecimalTest {

    public static void main(String[] args) {
        System.out.println(2.0 - 1.1);

        BigDecimal b1 = new BigDecimal(2.0);
        BigDecimal b2 = new BigDecimal(1.1);
        System.out.println(b1.subtract(b2));

        BigDecimal b3 = new BigDecimal("2.0");
        BigDecimal b4 = new BigDecimal("1.1");
        System.out.println(b3.subtract(b4));

        BigDecimal b5 = BigDecimal.valueOf(2.0);
        BigDecimal b6 = BigDecimal.valueOf(1.1);
        System.out.println(b5.subtract(b6));
    }
}
