package util;

import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Try again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Try again: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); // Consume newline
        return scanner.nextLine();
    }
}
