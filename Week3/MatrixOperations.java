public class MatrixOperations {
    public static void main(String[] args) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    MatrixOperations obj = new MatrixOperations();

    obj.run(input);

    input.close();
}

    public int[] rowSums(int[][] matrix) {

        int[] rSum = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int s = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                s += matrix[i][j];
            }

            rSum[i] = s;
        }

        return rSum;
    }

    public int[] columnSums(int[][] matrix) {

        int[] cSum = new int[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            int s = 0;

            for (int j = 0; j < matrix.length; j++) {
                s += matrix[j][i];
            }

            cSum[i] = s;
        }

        return cSum;
    }

    public int[][] add(int[][] first, int[][] second) {

        if (first.length != second.length ||
            first[0].length != second[0].length) {

            System.out.println("Dimensions are not same");

            int[][] garbage = new int[1][1];
            garbage[0][0] = -1;

            return garbage;
        }

        int[][] arrSum =
                new int[first.length][first[0].length];

        for (int i = 0; i < first.length; i++) {

            for (int j = 0; j < first[0].length; j++) {

                arrSum[i][j] =
                        first[i][j] + second[i][j];
            }
        }

        return arrSum;
    }

    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] tpose = new int[columns][rows];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                tpose[j][i] = matrix[i][j];
            }
        }

        return tpose;
    }

    public int[][] multiply(int[][] first, int[][] second) {

        if (first[0].length != second.length) {

            System.out.println("Multiplication not possible");

            int[][] garbage = new int[1][1];
            garbage[0][0] = -1;

            return garbage;
        }

        int[][] product =
                new int[first.length][second[0].length];

        for (int i = 0; i < first.length; i++) {

            for (int j = 0; j < second[0].length; j++) {

                for (int k = 0; k < first[0].length; k++) {

                    product[i][j] +=
                            first[i][k] * second[k][j];
                }
            }
        }

        return product;
    }

    public void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void run(java.util.Scanner input) {

        System.out.print("Enter rows of first matrix: ");
        int rows1 = input.nextInt();

        System.out.print("Enter columns of first matrix: ");
        int cols1 = input.nextInt();

        int[][] first = new int[rows1][cols1];

        System.out.println("Enter first matrix:");

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                first[i][j] = input.nextInt();
            }
        }

        System.out.print("Enter rows of second matrix: ");
        int rows2 = input.nextInt();

        System.out.print("Enter columns of second matrix: ");
        int cols2 = input.nextInt();

        int[][] second = new int[rows2][cols2];

        System.out.println("Enter second matrix:");

        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                second[i][j] = input.nextInt();
            }
        }

        System.out.println("First Matrix:");
        printMatrix(first);

        System.out.println("Second Matrix:");
        printMatrix(second);

        System.out.println("Row Sums:");

        int[] rSum = rowSums(first);

        for (int i = 0; i < rSum.length; i++) {
            System.out.print(rSum[i] + " ");
        }

        System.out.println("Column Sums:");

        int[] cSum = columnSums(first);

        for (int i = 0; i < cSum.length; i++) {
            System.out.print(cSum[i] + " ");
        }

        System.out.println("Addition:");

        int[][] added = add(first, second);
        printMatrix(added);

        System.out.println("Transpose:");

        int[][] tpose = transpose(first);
        printMatrix(tpose);

        System.out.println("Multiplication:");

        int[][] product = multiply(first, second);
        printMatrix(product);
    }
}