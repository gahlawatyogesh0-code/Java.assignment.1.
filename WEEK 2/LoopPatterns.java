import java.util.Scanner;

public class LoopPatterns {

    Scanner input = new Scanner(System.in);

    public static void patternA(int size) {

        for (int i = 1; i <= size; i++) {

            for (int j = 1; j <= size; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void patternC(int size) {

        for (int i = 1; i <= size; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }

    public void run() {

        System.out.print("Enter size: ");
        int size = input.nextInt();

        if (size < 1) {
            System.out.println("Invalid size.");
            return;
        }

        System.out.println("\nPattern A:");

        patternA(size);

        System.out.println("\nPattern C:");

        patternC(size);
    }
}