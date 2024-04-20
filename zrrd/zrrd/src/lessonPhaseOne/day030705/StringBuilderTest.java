package lessonPhaseOne.day030705;

public class StringBuilderTest {
    public static void main(String[] args) {
        String str = "zhang";
        StringBuilder stringBuilder = new StringBuilder(str);
        StringBuffer stringBuffer = new StringBuffer(str);

        stringBuilder.toString();
        stringBuffer.toString();

        StringBuffer s1 = new StringBuffer(stringBuilder.toString());
        StringBuilder s2 = new StringBuilder(stringBuffer.toString());

        System.out.println(s1);
        System.out.println(s2);

        String str10 = ",";
        String str11 = "zhang" + "san" + str10 +  "li" + "si" + str10 + "wang" + "wu";
        System.out.println(str11);

        StringBuilder sstr = new StringBuilder();
        System.out.println(sstr.capacity());

        StringBuilder sstr1 = new StringBuilder(10);
        System.out.println(sstr1.capacity());

        StringBuilder sstr2 = new StringBuilder("12阿巴");
        System.out.println(sstr2.capacity());

        sstr2.append("hao");
        sstr.append(str10);

        System.out.println(sstr.toString());
        sstr.reverse();
        sstr.append("zhang");
        sstr.append("san");
        sstr.append(str10);
        sstr.append("li");
        sstr.append("si");
        sstr.append(str10);
        sstr.append("wang");
        sstr.append("wu");
        sstr.delete(1,4);
        sstr.insert(4,"h");
//        sstr.insert(6," ");
//        System.out.println(sstr.toString());
//        sstr = new StringBuilder(40);
        System.out.println(sstr.capacity());
        StringBuilder sstr20 = new StringBuilder();
        System.out.println(sstr20.toString());

        // 修改指定位置字符
        sstr.setCharAt(0,'s');

        sstr.deleteCharAt(4);

    }
}
