package practice.RandomMachine;

import java.io.*;
import java.util.*;

public class TxtCall {
    public static void main(String[] args) throws Exception{
//        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入读取同学的个数：");
//        int n = scanner.nextInt();

        File file = new File("all.txt");
        file.createNewFile();
        try(InputStream is = new FileInputStream("all.txt")){
            while (true){
                byte[] arr = new byte[1024];
                int len = is.read(arr,0,arr.length);
                if (len == -1){
                    break;
                }
//                String content = new String(arr);
//                System.out.println(content);
            }
        }

        Set<String> allClassmates = new HashSet<>();

        int n = 0;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(inputReader.readLine());

        List<String> randomClassmates = new ArrayList<>();
        Random random = new Random();

        List<String> allClassmatesList = new ArrayList<>(allClassmates);
        while (randomClassmates.size() < n) {
            int index = random.nextInt(allClassmatesList.size());
            randomClassmates.add(allClassmatesList.get(index));
        }

        // 输出随机出的 n 个同学名字
        System.out.println("随机出的" + n + "个同学名字：");
        for (String name : randomClassmates) {
            System.out.println(name);
        }
    }
}
