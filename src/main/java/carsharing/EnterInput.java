package carsharing;

import java.util.Scanner;

public class EnterInput {
    static public void input() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Log in as a manager");
            System.out.println("0. Exit");
            switch (scanner.nextInt()) {
                case 0: System.exit(1);
                case 1: Maneger.action();
                    break;
                default:
                    System.out.println("Please enter a valid value");
            }
        }
    }
}
