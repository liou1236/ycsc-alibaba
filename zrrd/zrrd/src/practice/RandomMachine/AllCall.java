package practice.RandomMachine;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

    public class AllCall {
        public static void main(String[] args) {
            // 存储所有同学名字的集合
            Set<String> allClassmates = new HashSet<>();

            // 读取文件中的同学名字
            try (BufferedReader reader = new BufferedReader(new FileReader("all.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    allClassmates.add(line);
                }
            } catch (IOException e) {
                System.err.println("读取文件失败：" + e.getMessage());
                return;
            }

            // 读取用户输入的 n
            int n = 0;
            try {
                System.out.print("请输入要随机出的同学个数n：");
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
                n = Integer.parseInt(inputReader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("输入无效：" + e.getMessage());
                return;
            }

            // 确保 n 不超过同学总数
            if (n > allClassmates.size()) {
                System.err.println("随机个数不能超过班级总人数！");
                return;
            }

            // 使用随机数生成器随机选择 n 个同学
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


