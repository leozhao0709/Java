package poke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

class Poke {

    public static void main(String[] args) {
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] colors = {"♥️", "♦️", "♠️", "♣️"};

        ArrayList<String> poke = new ArrayList<>();

        for(String color: colors) {
            for (String num: nums) {
                poke.add(color + num);
            }
        }

        poke.add("小王");
        poke.add("大王");
        Collections.shuffle(poke);
//        System.out.println(poke);

        TreeSet<String> player1 = new TreeSet<>((o1, o2) -> {
            if (Arrays.asList(colors).indexOf(o1.substring(0, 1)) > Arrays.asList(colors).indexOf(o2.substring(0, 1))) {
                return 1;
            } else if (Arrays.asList(colors).indexOf(o1.substring(0, 1)) < Arrays.asList(colors).indexOf(o2.substring(0, 1))) {
                return -1;
            } else {
                System.out.println(o1.substring(1));
                System.out.println(Arrays.asList(nums));
                System.out.println(Arrays.asList(nums).indexOf(o1.substring(1)));
                if (Arrays.asList(nums).indexOf(o1.substring(1)) > Arrays.asList(nums).indexOf(o2.substring(1))) {
                    return 1;
                }
                else if (Arrays.asList(nums).indexOf(o1.substring(1)) < Arrays.asList(nums).indexOf(o2.substring(1))) {
                    return -1;
                }
                return 0;
            }
        });
        TreeSet<String> player2 = new TreeSet<>();
        TreeSet<String> player3 = new TreeSet<>();
        TreeSet<String> dipai = new TreeSet<>();

        for (int i = 0; i < poke.size(); i++) {
            if (i >= poke.size() - 3) {
                dipai.add(poke.get(i));
            } else if (i % 3 == 0) {
                player1.add(poke.get(i));
            } else if (i % 3 == 1) {
                player2.add(poke.get(i));
            } else {
                player3.add(poke.get(i));
            }
        }

        System.out.println("底牌: " + dipai);
        System.out.println("player1: " + player1);
        System.out.println("player2: " + player2);
        System.out.println("player3: " + player3);

    }
}
