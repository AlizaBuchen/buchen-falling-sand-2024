package buchen.fallingsand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);
        sand.randomSand(50);
        Scanner kb = new Scanner(System.in);
        String enter = "";
        do {
            enter = kb.nextLine();
            sand.fall();
            System.out.println(sand.toString());
        } while (enter.isEmpty());
    }
}