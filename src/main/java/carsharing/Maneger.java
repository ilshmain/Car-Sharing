package carsharing;

import carsharing.Company.*;

import java.util.List;
import java.util.Scanner;

public class Maneger {
    public static void action() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Company list");
            System.out.println("2. Create a company");
            System.out.println("0. Back");
            switch (scanner.nextInt()) {
                case 0: return;
                case 1: PrintCompany.printTable();
                    break;
                case 2: InsertCompany.insertValueTable();
                    break;
                default:
                    System.out.println("Please enter a valid value");
            }
        }
    }

    private static  void printCompanies(List<Company> companies) {
        int num = 1;
        System.out.println("\nChoose the company:");
        for (Company company : companies) {
            System.out.print(num);
            System.out.println(". " + company.getName());
            num++;
        }
        System.out.println("0. Back");
    }

    private static int printSelectedCompany(List<Company> companies) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        while (true) {
            if (num == 0)
                return 0;
            for (Company company : companies) {
                if (company.getId() == num) {
                    System.out.println("'" + company.getName() + "'" + " company");
                    return num;
                } else {
                    System.out.println("Please enter correct data");
                }
            }
        }
    }


    public static void carAction(List<Company> companies) {
        int num;
        Scanner scanner = new Scanner(System.in);

        printCompanies(companies);
        num = printSelectedCompany(companies);

        if (num == 0) {
            return;
        } else {
            while (true) {
                System.out.println("\n1. Car list");
                System.out.println("2. Create a car");
                System.out.println("0. Back");
                switch (scanner.nextInt()) {
                    case 0: return;
                    case 1: PrintCar.printCar(num);
                        break;
                    case 2: InsertCar.insertValueCar(num);
                        break;
                    default:
                        System.out.println("Please enter a valid value");
                }
            }
        }
    }
}
