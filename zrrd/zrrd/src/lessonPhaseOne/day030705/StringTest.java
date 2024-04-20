package lessonPhaseOne.day030705;

public class StringTest {
    public static void main(String[] args) {
        String str1 = new String("zhang");
        String str = "zhang";
        String str2 = "zhang";

        String str99 = new String("zhang");
        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str1 == str99);
        str = "san";
        // 创建几个对象
        String str3 = "";// 0
        String str4 = "zhang";
        String str5 = "zhang" + "san";
        String str6 = new String("zhang");
        String str7 = str4 + "san";
        String str8 = "hi" + "," + "boy" + str4 + "san" + "!";// 5




    }
}
