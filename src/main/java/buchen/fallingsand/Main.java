package buchen.fallingsand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Sand sand = new Sand(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            sand.randomSand(Integer.parseInt(args[2]));

            Scanner kb = new Scanner(System.in);

            do {
                kb.nextLine();
                sand.fall();
                System.out.println(sand.toString());
            } while (kb.equals(""));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}