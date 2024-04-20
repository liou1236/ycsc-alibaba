package lessonPhaseOne.classPractice.day0713;

import java.util.HashSet;
import java.util.Set;

public class Fiver {
    public static void main(String[] args) {
        String[] strs = {"12345","67891","123478099","9876543","67891","12347809933","12809933","12347809933111","9876543","12809933"};
        Set<String> qqSet = new HashSet<>();// HashSet自动去重
        for (String str : strs){
            if (isQQNumber(str)){
                qqSet.add(str);// 符合长度加入
            }
        }
        System.out.println("Unique QQ Numbers:");
        for (String qq : qqSet){
            System.out.println(qq);
        }
    }
    public static boolean isQQNumber(String str){
        int length = str.length();

        return length >= 6 && length <= 9;
    }
}
