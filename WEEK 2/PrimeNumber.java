import java.util.Scanner;

public class PrimeNumber {

    public boolean isPrime() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 2) {
            return false;
        }

        for (int divisor = 2; divisor * divisor <= number; divisor++) {

            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}