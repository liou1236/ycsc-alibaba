package lessonPhaseOne.classPractice.day0713;

import java.util.Arrays;
import java.util.Scanner;

public class Twelve {
    public static void main(String[] args) {
        while (true) {
            int[] one = new int[5];
            int[] two = new int[5];

            Scanner scannerX = new Scanner(System.in);
            Scanner scannerY = new Scanner(System.in);
            System.out.println("请输入棋子坐标（0~4，0~4）：");
            int x = scannerX.nextInt();
            int y = scannerY.nextInt();
            int[][] chessBoard = new int[5][5];
            for (int i = 0; i < chessBoard.length; i++) {
                System.out.println(Arrays.toString(chessBoard[i]));
//            for (int j = 0;j < chessBoard[i].length;j++){
//                System.out.println(chessBoard[i][j]);
//            }
            }
        }
    }
    public int[][] playChessOne(int x,int y){

        int[][] chessBoard = new int[5][5];
        chessBoard[x][y] = 2;

        return chessBoard;
    }
}

