package lessonPhaseOne.day030705;

public class StringTest1 {
    public static void main(String[] args) {
        String str = new String("zhang");
        str = str.intern();
        String str1 = "zhang";
        System.out.println(str == str1);

        String str2 = new String("zhang") + new String("san");
        str2.intern();
        String str3 = "zhangsan";
        // str2.intern();
        System.out.println(str2 == str3);



    }
}
