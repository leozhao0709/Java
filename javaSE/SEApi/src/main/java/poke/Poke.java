package poke;

import java.util.*;

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

        TreeSet<String> player1 = new TreeSet<>(getStringComparator(nums, colors));
        TreeSet<String> player2 = new TreeSet<>(getStringComparator(nums, colors));
        TreeSet<String> player3 = new TreeSet<>(getStringComparator(nums, colors));
        TreeSet<String> dipai = new TreeSet<>(getStringComparator(nums, colors));

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

    private static Comparator<String> getStringComparator(String[] nums, String[] colors) {
        return (o1, o2) -> {
            if (indexOf(colors, o1.substring(0,2)) > indexOf(colors, o2.substring(0, 2))) {
                return 1;
            } else if (indexOf(colors, o1.substring(0,2)) < indexOf(colors, o2.substring(0, 2))) {
                return -1;
            } else {
                if (indexOf(nums, o1.substring(2)) > indexOf(nums, o2.substring(2))) {
                    return 1;
                }
                else if (indexOf(nums, o1.substring(2)) < indexOf(nums, o2.substring(2))) {
                    return -1;
                }
                return 0;
            }
        };
    }

    private static int indexOf(String[] array, String target) {
        for (int i= 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
