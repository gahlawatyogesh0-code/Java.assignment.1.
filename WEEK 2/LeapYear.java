import java.util.Scanner;

public class LeapYear {

    public boolean IsLeapYear() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = input.nextInt();

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }
    

}