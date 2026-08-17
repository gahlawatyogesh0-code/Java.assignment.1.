public class NumberAnalyzer {

    public static int readNumber(java.util.Scanner input) {

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        return number;
    }

    public static boolean isEven(int number) {

        return number % 2 == 0;
    }

    public static boolean isPositive(int number) {

        return number > 0;
    }

    public static int absoluteValue(int number) {

        return Math.abs(number);
    }

    public static int countDigits(int number) {

        if (number == 0) {
            return 1;
        }

        int count = 0;

        while (number != 0) {

            number = number / 10;
            count++;
        }

        return count;
    }

    public static int sumDigits(int number) {

        if (number == 0) {
            return 0;
        }

        int sum = 0;

        while (number != 0) {

            int digit = number % 10;

            sum = sum + digit;

            number = number / 10;
        }

        return sum;
    }

    public static void printReport(
            int number,
            boolean even,
            boolean positive,
            int digitCount,
            int digitSum) {

        System.out.println("\n===== NUMBER ANALYSIS REPORT =====");
        System.out.println("Number: " + number);
        System.out.println("Even: " + even);
        System.out.println("Positive: " + positive);
        System.out.println("Number of digits: " + digitCount);
        System.out.println("Sum of digits: " + digitSum);
    }
}