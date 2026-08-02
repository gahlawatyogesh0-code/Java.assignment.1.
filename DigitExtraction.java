import java.util.Scanner;

public class DigitExtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a three-digit number: ");
        int number = sc.nextInt();

        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int units = number % 10;

        System.out.println("Hundreds: " + hundreds);
        System.out.println("Tens: " + tens);
        System.out.println("Units: " + units);

        sc.close();
    }
}