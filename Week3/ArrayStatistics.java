import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    ArrayStatistics obj = new ArrayStatistics();

    obj.runAS(input);

    input.close();
}
    public void runAS(Scanner input) {
        System.out.print("enter array size: ");
        int n = input.nextInt();
        int[] values = new int[n];
        System.out.println("enter elements of array: ");
        for (int i = 0; i < n; i++) {
            values[i]= input.nextInt();
        }
        if (n==0) {
            System.out.println("empty array");
            return;
        }
        System.out.println("SUM = "+ sum(values));
        System.out.println("AVERAGE = "+average(values));
        System.out.println("MINIMUM = "+minimum(values));
        System.out.println("MAXIMUM = "+ maximum(values));
        int even=countEven(values);
        int odd= n-even;
        System.out.println("even numbers = "+ even);
        System.out.println("odd numbers = "+ odd);
        printSignCounts(values);
    }

    public int sum(int[] values) {
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total;
    }

    public double average(int[] values) {
        return (double) sum(values) / values.length;
    }

    public int minimum(int[] values) {
        int min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public int maximum(int[] values) {
        int max= values[0];
        for(int i=1; i < values.length; i++) {
            if(values[i]> max){
                max = values[i];
            }
        }
        return max;
    }

    public int countEven(int[] values) {
        int count= 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public void printSignCounts(int[] values) {
        int positive=0;
        int negative=0;
        int zero= 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] > 0){
                positive++;
            }
            else if(values[i] < 0){
                negative++;
            }
            else {
                zero++;
            }
        }
        System.out.println("positive numbers : "+ positive);
        System.out.println("negative numbers : "+ negative);
        System.out.println("zero : "+ zero);
    }
}