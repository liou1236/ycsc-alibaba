package lessonPhaseOne.classPractice.day0713;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入金字塔层数：");
        int layer = scanner.nextInt();
        for (int i = 0 ;i <= layer;i++){

            for (int j = layer-i;j > 0;j--){
                System.out.print("  ");
            }
            for (int k = i ;k >= 1;k--){
                System.out.print(" "+k);
            }
            for (int k = 2 ;k <= i;k++){
                System.out.print(" "+k);
            }

            System.out.println();
        }
    }
}
