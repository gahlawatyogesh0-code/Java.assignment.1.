import java.util.Scanner;

public class GreatestCommonDivisor {

    Scanner input = new Scanner(System.in);

    public int gcd(int first, int second) {

        first = Math.abs(first);
        second = Math.abs(second);

        while (second != 0) {

            int remainder = first % second;

            first = second;
            second = remainder;
        }

        return first;
    }

    public int getFirstNumber() {

        System.out.print("Enter first number: ");
        int first = input.nextInt();

        return first;
    }

    public int getSecondNumber() {

        System.out.print("Enter second number: ");
        int second = input.nextInt();

        return second;
    }
}