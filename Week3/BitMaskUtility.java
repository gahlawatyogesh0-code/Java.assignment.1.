import java.util.Scanner;

public class BitMaskUtility {

    public static boolean isBitSet(int number, int position) {
        return (number & (1 << position)) != 0;
    }

    public static int setBit(int number, int position) {
        return number | (1 << position);
    }

    public static int clearBit(int number, int position) {
        return number & ~(1 << position);
    }

    public static int toggleBit(int number, int position) {
        return number ^ (1 << position);
    }

    public static String toBinary32(int number) {
        String result = "";

        for (int i = 31; i >= 0; i--) {
            if ((number & (1 << i)) != 0) {
                result += "1";
            } else {
                result += "0";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = input.nextInt();

        System.out.print("Enter bit position (0-31): ");
        int position = input.nextInt();

        if (position < 0 || position > 31) {
            System.out.println("Invalid bit position.");
            input.close();
            return;
        }

        System.out.println("\n1. Check Bit");
        System.out.println("2. Set Bit");
        System.out.println("3. Clear Bit");
        System.out.println("4. Toggle Bit");
        System.out.print("Enter operation: ");
        int choice = input.nextInt();

        int result = number;

        System.out.println("\nBefore:");
        System.out.println("Decimal: " + number);
        System.out.println("Binary : " + toBinary32(number));

        switch (choice) {
            case 1:
                System.out.println("Bit is set: " + isBitSet(number, position));
                break;

            case 2:
                result = setBit(number, position);
                break;

            case 3:
                result = clearBit(number, position);
                break;

            case 4:
                result = toggleBit(number, position);
                break;

            default:
                System.out.println("Invalid operation.");
                input.close();
                return;
        }

        if (choice != 1) {
            System.out.println("\nAfter:");
            System.out.println("Decimal: " + result);
            System.out.println("Binary : " + toBinary32(result));
        }

        input.close();
    }
}