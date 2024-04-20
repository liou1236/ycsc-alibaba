package lessonPhaseOne.classPractice.day0807;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir");
        String path =filePath + "/" + "testForDelete";
        listAll(new File(path));
        System.out.println(path + " 文件夹及其路径全部删除成功！");
    }
    public static void listAll(File file){
        if (!file.exists())return;
        File[] files = file.listFiles();
        if (files == null || files.length == 0){
            file.delete();
            System.out.println(file.getName() + "文件夹为空");
            return;
        }
        {
            for ( File tmpFile : files){
                if (tmpFile.isFile()){
                    System.out.println(tmpFile.getName() + "文件已删除");
                    tmpFile.delete();
                    continue;
                }
                if (tmpFile.isDirectory()){
                    listAll(tmpFile);
                    System.out.println(tmpFile.getName() + "文件夹已删除");
                    tmpFile.delete();
                }
            }
            file.delete();

        }

    }
}
