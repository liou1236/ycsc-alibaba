package lessonPhaseOne.classPractice.day0808Test;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("player.txt")
        );
        Scanner scanner = new Scanner(System.in);
        System.out.println("需要输入几位同学的信息：");
        int n = scanner.nextInt();
        String str = " 姓名   语文成绩  数学成绩   总成绩";
        bufferedWriter.write(str + "\n");

        for (int i = 0; i < n; i++) {
            System.out.println("请输入学生信息：");
            LinkedList student = new LinkedList();
            addStudent(student);
            bufferedWriter.write( String.valueOf(student) + "\n");
        }
        System.out.println("添加完成");
        bufferedWriter.close();
    }

    public static void addStudent(LinkedList student){
        Scanner scanner = new Scanner(System.in);
        System.out.print("姓名：");
        String name = scanner.next();
        student.add(name + "\t");

        System.out.print("语文成绩：");
        int languageNum = scanner.nextInt();
        student.add(languageNum +"\t");

        System.out.print("数学成绩：");
        int mathNum = scanner.nextInt();
        student.add(mathNum + "\t");

        int allNum = languageNum + mathNum;
        student.add(allNum + "\t");
        System.out.println(student);
    }
}

