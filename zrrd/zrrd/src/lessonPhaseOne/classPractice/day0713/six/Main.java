package lessonPhaseOne.classPractice.day0713.six;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List student = new ArrayList();
        student.add(new Student("liusan",20,90));
        student.add(new Student("lisi", 22, 90));
        student.add(new Student("wangwu", 20, 99));
        student.add(new Student("sunliu", 22, 100));

        Collections.sort(student);
        System.out.println("使用Comparable接口排序（成绩降序，年龄升序）");
        printStudent(student);

    }
    private static void printStudent(List<Student> student){
        for (Student student1 : student){
            System.out.println(student1);
        }
    }
}
