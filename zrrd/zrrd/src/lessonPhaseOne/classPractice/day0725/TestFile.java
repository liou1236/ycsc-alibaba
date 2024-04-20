package lessonPhaseOne.classPractice.day0725;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
//        String projectPath = System.getProperty("user.dir");
//
//        System.out.println(projectPath);
//        String filePath = projectPath + "/" + "test.txt";
//        String filePath1 = projectPath + File.pathSeparator + "test.txt";
//        File file = new File(filePath);
//        System.out.println(file);
//        System.out.println("+++++++++++++++++++++++++");
//        System.out.println(file.getPath());
//        System.out.println("--------------");
//        System.out.println(file.getAbsoluteFile());
//        try {
//            System.out.println(file.getCanonicalFile());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        String projectPath1 = System.getProperty("user.dir");
//        System.out.println(projectPath1);
//
//        File file2 = new File(projectPath1 + "/" + "file2");
//        System.out.println(file.getAbsoluteFile());
//        Boolean re = file2.mkdir();
//        if (re){
//            System.out.println("创建成功");
//        }else System.out.println("失败");
////        file2.delete();




//
//
//
//
//
//        String projectPath = System.getProperty("user.dir");
//        System.out.println(projectPath);
//        File dir1 = new File(projectPath + "/" + "f1");
//        dir1.mkdir();
//        File dir2 = new File(projectPath + "/" + "f2");
//        dir2.mkdir();
//        System.out.println(dir1.getAbsoluteFile());
//        System.out.println(dir1.isDirectory());
//        System.out.println(dir1.isFile());
//        System.out.println(dir2.isDirectory());
//
//        File file1 = new File(dir1.getAbsolutePath() + "/" + "t1");
//        try {
//            file1.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        File file2 = new File(dir1.getAbsolutePath() + "/" + "t2");
//
////        File file2 = new File(dir2 + "/" + "t3");
////        file2 = new File(dir2 + "/" + "t4");
//        File file3 = new File("/" + "t3");
//
//        try {
//            file1.createNewFile();
//
//            file2.createNewFile();
//            file3.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(file1.isFile());
//        System.out.println(file2.isFile());
//
//        boolean result = t3.renameTo(t4);
////        boolean result1 = file3.delete();
//        System.out.println(result);
////        System.out.println(result1);
//
//        String[] strList1 = dir1.list();
//        for (String s : strList1){
//            System.out.println(s + " ");
//        }
//        String[] strList2 = dir2.list();
//        for (String s : strList2){
//            System.out.println(s + " ");
//        }
        String projectPath = System.getProperty("user.dir");
        File file1 = new File(projectPath + "/" + "s1");
        File file2 = new File(projectPath + "/" + "file2");
        try {
            file1.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        file1.renameTo(file2);
//        file1.delete();
//        String[] str = file2.list();
//        for (String s : str){
//            System.out.println(s);
//        }
        System.out.println(file1);

    }
}
