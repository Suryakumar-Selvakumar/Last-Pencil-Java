package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many pencils would you like to use:");
        int count;
        while (true) {
            String input = sc.nextLine().trim();

            try {
                count = Integer.parseInt(input);
                if (count == 0) {
                    System.out.println("The number of pencils should be positive");
                } else if (count < 0) {
                    System.out.println("The number of pencils should be numeric");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        System.out.println("Who will be the first (John, Jack):");
        String player;
        while (true) {
            if (sc.hasNext()) {
                player = sc.next();
                if (player.equals("John") || player.equals("Jack")) {
                    break;
                } else {
                    System.out.println("Choose between 'John' and 'Jack'");
                }
            }
        }

//        Game Logic
        while (count > 0) {
            System.out.println(getPencils(count));
            System.out.println(player + "'s turn!");

            if (player.equals("Jack")) {
                count = botPlay(count);
                player = "John";
                continue;
            }

            do {
                String turnCountStr = sc.next();

                int turnCount;
                try {
                    turnCount = Integer.parseInt(turnCountStr);
                    if (turnCount > 0 && turnCount < 4) {
                        if (turnCount > count) {
                            System.out.println("Too many pencils were taken");
                            continue;
                        }
                        count -= turnCount;
                        player = "Jack";
                        break;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Possible values: '1', '2' or '3'");

                }
            } while (true);
        }

        System.out.printf("%s won!\n", player);
    }

    static String getPencils(int count) {
        String pencils = "";
        for (int i = 0; i < count; i++) {
            pencils += "|";
        }

        return pencils;
    }

    static int getRandom() {
        Random random = new Random();
        return random.nextInt(3 - 1 + 1) + 1;
    }

    static int botPlay(int count) {
        int turnCount = 0;

        if (count == 1) { // Final turn, bot loses
            turnCount = 1;
        } else if (isPartOfSequence(count, 5, 4)) { // Losing strategy - take random pencils
            turnCount = getRandom();
        } else if (isPartOfSequence(count, 4, 4)) { // Winning strategy - take 3 pencils
            turnCount = 3;
        } else if (isPartOfSequence(count, 3, 4)) { // Winning strategy - take 2 pencils
            turnCount = 2;
        } else if (isPartOfSequence(count, 2, 4)) { // Winning strategy - take 1 pencil
            turnCount = 1;
        }
        System.out.println(turnCount);
        return count - turnCount;
    }

    static boolean isPartOfSequence(int count, int a1, int d) {
        double n = (double) (count - a1) / d + 1;
        return n > 0 && n == (int) n;
    }
}
