import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int[][] arrayMatrix(int matrixDimension, int mainDiagValue, int sndDiagValue, int centerValue,
                                       int leftValue, int upValue, int rightValue, int bottomValue) {

        int[][] result = new int[matrixDimension][matrixDimension];


        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                if (i == j) {
                    result[i][j] = mainDiagValue;
                } else if (i + j == matrixDimension - 1) {
                    result[i][j] = sndDiagValue;
                } else if (i > j && i + j < matrixDimension - 1) {
                    result[i][j] = leftValue;
                } else if (i < j && i + j < matrixDimension - 1) {
                    result[i][j] = upValue;
                } else if (i < j && i + j > matrixDimension - 1) {
                    result[i][j] = rightValue;
                } else if (i > j && i + j > matrixDimension - 1) {
                    result[i][j] = bottomValue;
                }
            }

            if (matrixDimension % 2 == 1) {
                result[matrixDimension / 2][matrixDimension / 2] = centerValue;
            }
        }

        return result;
    }

    private static ArrayList<ArrayList<Integer>> arrayListMatrix(int matrixDimension, int mainDiagValue, int sndDiagValue,
                                                                 int centerValue, int leftValue, int upValue, int rightValue, int bottomValue) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < matrixDimension; i++) {
            ArrayList<Integer> row = new ArrayList<>(matrixDimension);

            for (int j = 0; j < matrixDimension; j++) {
                row.add(0);
            }

            result.add(row);
        }

        for (int i = 0; i < matrixDimension; i++) {
            ArrayList<Integer> row = new ArrayList<>(matrixDimension);

            for (int j = 0; j < matrixDimension; j++) {
                if (i == j) {
                    result.get(i).set(j, mainDiagValue);
                } else if (i + j == matrixDimension - 1) {
                    result.get(i).set(j, sndDiagValue);
                } else if (i > j && i + j < matrixDimension - 1) {
                    result.get(i).set(j, leftValue);
                } else if (i < j && i + j < matrixDimension - 1) {
                    result.get(i).set(j, upValue);
                } else if (i < j && i + j > matrixDimension - 1) {
                    result.get(i).set(j, rightValue);
                } else if (i > j && i + j > matrixDimension - 1) {
                    result.get(i).set(j, bottomValue);
                }
            }
        }

        if (matrixDimension % 2 == 1) {
            result.get(matrixDimension / 2).set(matrixDimension / 2, centerValue);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseV = scanner.nextInt();

        int matrixDimension = scanner.nextInt();
        int mainDiagValue = scanner.nextInt();
        int sndDiagValue = scanner.nextInt();
        int centerValue = 0;
        if (matrixDimension % 2 != 0)
            centerValue = scanner.nextInt();
        int leftValue = scanner.nextInt();
        int upValue = scanner.nextInt();
        int rightValue = scanner.nextInt();
        int bottomValue = scanner.nextInt();

        switch (caseV) {
            case 1:
                // arrays
                int[][] array = arrayMatrix(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);
                for (int[] row : array) {
                    for (int elem : row) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                // ArrayList
                ArrayList<ArrayList<Integer>> arrayList =
                        arrayListMatrix(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);
                for (ArrayList<Integer> row : arrayList) {
                    for (Integer elem : row) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
