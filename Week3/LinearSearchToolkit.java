import java.util.Scanner;
public class LinearSearchToolkit {
    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    LinearSearchToolkit obj = new LinearSearchToolkit();

    obj.toolkit(input);

    input.close();
}
    public void toolkit(Scanner input) {
        System.out.print("enter size of array: ");
        int n = input.nextInt();
        int [] values = new int [n];
        System.out.println("enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            values[i]= input.nextInt();
        }
        System.out.print("enter target value: ");
        int target= input.nextInt();

        if(n==0) {
            System.out.println("ooopsss empty array :(");
            return;
        }

        System.out.println("Contains: "+ contains(values,target));
        System.out.println("First index no. : "+ firstIndexOf(values,target));
        System.out.println("Last Index no. : "+lastIndexOf(values, target));
        System.out.println("Occurences : "+ countOccurences(values,target));
        
    }

    public boolean contains(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if(values[i]==target){
                return true;
            }
        }
        return false;
    }

    public int firstIndexOf(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if(values[i]==target) {
                return i;
            }
        }
        return -1;
    }

     public int lastIndexOf(int[] values, int target) {
        for (int i = values.length -1; i >=0 ; i--) {
            if(values[i]==target) {
                return i;
            }
        }
        return -1;
    }

    public int countOccurences(int[] values, int target) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i]==target){
                count++;
            }
        }
        return count;
    } 
}