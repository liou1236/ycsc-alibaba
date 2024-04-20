package lessonPhaseOne.classPractice.day0713;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入一个整数（1-20）；");
            int n = scanner.nextInt();

            if (n < 1 || n > 20) {
                System.out.println("输入超出范围");
                continue;
            }
            int[][] matrix = generateSpiralMatrix(n);
            generateSpiralMatrix(n);
            printMatrix(matrix);
        }
    }
    public static int[][] generateSpiralMatrix(int n){
        int[][] matrix = new int[n][n];
        int num = 1;
        int left = 0,right = n - 1, top = 0,bottom = n - 1;

        while (num <= n * n){
            for (int i = left;i <= right;i++){
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top;i <= bottom;i++){
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right;i >= left;i--){
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom;i >= top;i--){
                matrix[i][left] = num++;
            }
            left++;

        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix){
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length;j++){
                System.out.printf("%5d",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
