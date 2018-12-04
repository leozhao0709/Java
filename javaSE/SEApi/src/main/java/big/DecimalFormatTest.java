package big;

import java.text.DecimalFormat;

class DecimalFormatTest {
    public static void main(String[] args) {
        String money = DecimalFormat.getCurrencyInstance().format(1234567);
        System.out.println(money);

        DecimalFormat df1 = new DecimalFormat("###, ###");
        System.out.println(df1.format(123456));

        DecimalFormat df2 = new DecimalFormat("###, ###.##");
        System.out.println(df2.format(123456.123));

        DecimalFormat df3 = new DecimalFormat("###, ###.0000");
        System.out.println(df3.format(123456.123));
    }
}
