package lessonPhaseOne.classPractice.day0728;

import java.io.File;

public class TestRecu1 {
    public static void main(String[] args) {
//        System.out.print("请输入阶层数：");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("result:" + fib(scanner.nextInt()));
        listAll(new File("src\\lesson"));
    }

//    public static int fib(int n) {
//        if (n == 1) return 1;
//        return (n * fib(n - 1));
//    }
    public static void listAll(File file){
        if (!file.exists())return;
        File[] files = file.listFiles();
        if (files == null || files.length == 0)return;
        for (File tmpFile : files) {
            if (tmpFile.isDirectory()){
                System.out.println(file.getName() + "-" + tmpFile.getName());
                listAll(tmpFile);
            }
            if (tmpFile.isFile()){
                System.out.println(file.getName() + "->" + tmpFile.getName());
                continue;
            }

        }
    }
}
