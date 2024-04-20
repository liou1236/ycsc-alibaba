package lessonPhaseOne.classPractice.day0713;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入金字塔层数：");
        int layer = scanner.nextInt();
        for (int i = 0 ;i < layer;i++){
            for (int j = layer-i;j > 0;j--){
                System.out.print(" ");
            }
            for (int k = 0 ;k <= 2*i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0;i < layer/2;i++){
            for (int j = 0;j <= layer-Math.sqrt(layer)+1;j++){
                System.out.print(" ");
            }
            for (int k = 0;k < layer/3-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
