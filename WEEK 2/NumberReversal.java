import java.util.Scanner;

public class NumberReversal {

    Scanner input = new Scanner(System.in);

    public int getNumber() {

        System.out.print("Enter a non-negative number: ");
        int number = input.nextInt();

        return number;
    }

    public int reverseNumber(int number) {

        int reversed = 0;

        while (number != 0) {

            int digit = number % 10;

            reversed = reversed * 10 + digit;

            number = number / 10;
        }

        return reversed;
    }
}