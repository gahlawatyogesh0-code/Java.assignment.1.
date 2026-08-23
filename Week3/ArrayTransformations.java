import java.util.Scanner;

public class ArrayTransformations {
  public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayTransformations obj = new ArrayTransformations();

        int length = obj.arrayInputLength(scanner);
        int[] arr = obj.takeArrayInput(scanner, length);

        obj.ArrayTransformations_main(scanner, arr);

        scanner.close();}

  public void ArrayTransformations_main(Scanner scanner,int[] arr) {
    reverseInPlace(arr);
    System.out.print("Reversing in Place");
    printArray(arr);
    System.out.print("Reversing in Copy");
    printArray(reversedCopy(arr));
    System.out.print("Original Array");
    printArray(arr);
    System.out.print("Removing target");
    arr = removeValue(arr, targetInput(scanner));
    System.out.print("Final array");
    printArray(arr);
    System.out.print("Running Sum");
    printArray(runningSum(arr));
  }

  public int arrayInputLength(Scanner scanner) {
    System.out.print("Enter the length of the array: ");
    int length = scanner.nextInt();
    return length;
  }

  public int[] takeArrayInput(Scanner scanner, int length) {
    int[] array = new int[length];
    System.out.println("Enter the values of the array: ");
    for (int i = 0; i < length; i++) {
      array[i] = scanner.nextInt();
    }
    return array;
  }

  public void reverseInPlace(int[] values) {
    int arrayLength = values.length;
    for (int i = 0; i < arrayLength / 2; i++) {
      int temp;
      temp = values[i];
      values[i] = values[arrayLength - i - 1];
      values[arrayLength - i - 1] = temp;
    }
  }

  public int[] reversedCopy(int[] values) {
    int arrayLength = values.length;
    int reversedArray[] = new int[arrayLength];
    for (int i = 0; i < arrayLength; i++) {
      reversedArray[i] = values[arrayLength - i - 1];
    }
    return reversedArray;
  }

  public int targetInput(Scanner scanner) {
    System.out.print("Enter the target: ");
    int target = scanner.nextInt();
    return target;
  }

  public int[] removeValue(int[] values, int target) {
    int[] copy = new int[values.length - 1];
    for (int i = 0; i < target; i++) {
      copy[i] = values[i];
    }
    for (int i = target + 1; i < copy.length; i++) {
      copy[i - 1] = values[i];
    }
    return copy;
  }

  public int[] runningSum(int[] values) {
    int arrayLength = values.length;
    int[] runningArray = new int[arrayLength];
    runningArray[0] = values[0];
    for (int i = 1; i < values.length; i++) {
      runningArray[i] = runningArray[i - 1] + values[i];
    }
    return runningArray;
  }

  public void printArray(int[] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.print(matrix[i]);
      System.out.print(" ");
    }
    System.out.println();
  }

}