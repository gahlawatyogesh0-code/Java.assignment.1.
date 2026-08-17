import java.util.Scanner;

public class MarksProcessor {

    Scanner input = new Scanner(System.in);

    public boolean isValidMark(int mark) {

        if (mark >= 0 && mark <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public void processMarks() {

        int mark;
        int count = 0;
        int sum = 0;
        int highest = 0;
        int passes = 0;
        int failures = 0;

        while (true) {

            System.out.print("Enter mark (-1 to stop): ");
            mark = input.nextInt();

            if (mark == -1) {
                break;
            }

            if (!isValidMark(mark)) {
                System.out.println("Invalid mark. Enter a value from 0 to 100.");
                continue;
            }

            count++;
            sum += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark >= 50) {
                passes++;
            } else {
                failures++;
            }
        }

        System.out.println("Number of valid marks = " + count);
        System.out.println("Sum = " + sum);

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Average = " + average);
            System.out.println("Highest mark = " + highest);
        } else {
            System.out.println("Average = 0");
            System.out.println("Highest mark = 0");
        }

        System.out.println("Number of passes = " + passes);
        System.out.println("Number of failures = " + failures);
    }
}