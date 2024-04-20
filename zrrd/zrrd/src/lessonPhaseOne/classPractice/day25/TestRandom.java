package lessonPhaseOne.classPractice.day25;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TestRandom {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        while (true) {
        System.out.println("请输入随机的人数：");
        int num = sc.nextInt();
        test4(num);
//        }
    }

    // 编写一个随机器，先通过字符串或集合读取班级所有同学的名字，
    // 然后根据输入的个数n，随机出不重复的n个同学。
    public static void test3(int n) throws Exception {
        InputStream is = new FileInputStream("all.txt");
        byte[] arr = new byte[1024];
        is.read(arr);

        String allStu = new String(arr);
        String[] stuArr = allStu.split("、");

        int max = stuArr.length;
        HashSet<String> set = new HashSet<>(n);
        while (set.size() < n) {
            int random = (int) (Math.random() * max);
            set.add(stuArr[random]);
        }

        StringBuilder builder = new StringBuilder();
        for (String stu : set) {
            System.out.println(stu);
            builder.append(stu + "、");
        }
        String result = builder.substring(0, builder.length() - 1);

        OutputStream os = new FileOutputStream("random.txt");
        os.write(result.getBytes());

        is.close();
        os.close();
    }


    // 编写一个随机器，先通过文件，如“all.txt”读取班级所有同学的名字，
    // 然后根据输入的个数n，以及另一个文件，如“random.txt”中保存的随机后的同学名字。
    // 随机出没有随机过的n个同学名字，并将随机结果继续保存到“random.txt”中。
    public static void test4(int n) throws Exception {
        InputStream is = new FileInputStream("all.txt");
        byte[] arr = new byte[1024];
        is.read(arr);

        File file = new File("random.txt");
        InputStream iis = new FileInputStream(file);
        byte[] arrRan = new byte[(int) file.length()];
        iis.read(arrRan);

        String allStu = new String(arr);
        String[] allArr = allStu.split("、");

        String ranStu = new String(arrRan);
        String[] randomArr = ranStu.split("、");


        // 剔除法
        List<String> all = new ArrayList<>();
        for (int i = 0; i < allArr.length; i++) {
            all.add(allArr[i]);
        }
        List<String> random = new ArrayList<>();
        for (int i = 0; i < randomArr.length; i++) {
            random.add(randomArr[i]);
        }
        all.removeAll(random);


        int max = all.size();
        HashSet<String> set = new HashSet<>(n);
        while (set.size() < n) {
            int index = (int) (Math.random() * max);
            set.add(all.get(index));
        }

        StringBuilder builder = new StringBuilder();
        for (String stu : set) {
            System.out.println(stu);
            builder.append(stu + "、");
        }

        String result = null;
        if (ranStu == null || ranStu.length() == 0) {
            result = builder.substring(0, builder.length() - 1);
        } else {
            builder.append(ranStu);
            result = builder.toString();
        }

        System.out.println(result);
        OutputStream os = new FileOutputStream("random.txt");
        os.write(result.getBytes());

        is.close();
        os.close();
    }

    // 编写一个随机器，先通过文件，如“all.txt”读取班级所有同学的名字，
    // 然后根据输入的个数n，以及另两个文件，如“random.txt”中保存的随机后的同学名字，
    // 如“leave.txt”中保存的请假的同学名字。随机出没有被随机过也没有请假的n个同学名字，
    // 并将随机结果继续保存到“random.txt”中。
    public static void test5(int n) throws Exception {
        InputStream is = new FileInputStream("all.txt");
        byte[] arr = new byte[1024];
        is.read(arr);

        File file = new File("random.txt");
        InputStream iis = new FileInputStream(file);
        byte[] arrRan = new byte[(int) file.length()];
        iis.read(arrRan);

        File file1 = new File("leave.txt");
        InputStream iis1 = new FileInputStream(file1);
        byte[] arrLeave = new byte[(int) file1.length()];
        iis.read(arrLeave);


        String allStu = new String(arr);
        String[] allArr = allStu.split("、");

        String ranStu = new String(arrRan);
        String[] randomArr = ranStu.split("、");

        String leaveStu = new String(arrLeave);
        String[] leaveArr = leaveStu.split("、");


        // 剔除法
        List<String> all = new ArrayList<>();
        for (int i = 0; i < allArr.length; i++) {
            all.add(allArr[i]);
        }
        List<String> random = new ArrayList<>();
        for (int i = 0; i < randomArr.length; i++) {
            random.add(randomArr[i]);
        }
        List<String> leave = new ArrayList<>();
        for (int i = 0; i < leaveArr.length; i++) {
            leave.add(leaveArr[i]);
        }
        all.removeAll(random);
        all.removeAll(leave);


        int max = all.size();
        HashSet<String> set = new HashSet<>(n);
        while (set.size() < n) {
            int index = (int) (Math.random() * max);
            set.add(all.get(index));
        }

        StringBuilder builder = new StringBuilder();
        for (String stu : set) {
            System.out.println(stu);
            builder.append(stu + "、");
        }

        String result = null;
        if (ranStu == null || ranStu.length() == 0) {
            result = builder.substring(0, builder.length() - 1);
        } else {
            builder.append(ranStu);
            result = builder.toString();
        }

        System.out.println(result);
        OutputStream os = new FileOutputStream("random.txt");
        os.write(result.getBytes());

        is.close();
        os.close();
    }
}
