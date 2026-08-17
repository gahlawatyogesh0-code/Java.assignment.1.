import java.util.Scanner;

public class FinalValueOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

       
        int X = 0;

     
        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            if (operation.contains("+")) {
                X++;
            } else {
                X--;
            }
        }

       
        System.out.println(X);

        sc.close();
    }
}