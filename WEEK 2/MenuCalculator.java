import java.util.Scanner;

public class MenuCalculator {

    Scanner input = new Scanner(System.in);

    public double Menu() {

        int choice;
        double num1, num2, result = 0;

        do {

            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter first number: ");
                num1 = input.nextDouble();

                System.out.print("Enter second number: ");
                num2 = input.nextDouble();

                switch (choice) {

                    case 1:
                        result = num1 + num2;
                        break;

                    case 2:
                        result = num1 - num2;
                        break;

                    case 3:
                        result = num1 * num2;
                        break;

                    case 4:
                        if (num2 == 0) {
                            System.out.println("Cannot divide by zero.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                }

                System.out.println("Result = " + result);

            } else if (choice != 0) {

                System.out.println("Invalid choice.");

            }

        } while (choice != 0);

        return result;
    }
}