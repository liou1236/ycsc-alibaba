package lessonPhaseOne.day020704.str;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "zhang";
//        str2 = "san";
        String str3 = new String("zhang");
//        str3 = "san";
        String str4 = new String(new char[]{'z','h','a','n','g'});

        System.out.println(str3 == str2);
        System.out.println(str2.equals(str3));
        System.out.println(str3 == str4);
        System.out.println("===============");

        int a = 10;
        String aStr = "" + 10;
        String iStr = "10";
        int i = Integer.parseInt(aStr);
        int j = Integer.parseInt(iStr);
        System.out.println(aStr);
        System.out.println(aStr == iStr);
        System.out.println(i == j);
        System.out.println("-==============");

        System.out.println(str1.isEmpty());
        System.out.println(str2.startsWith("z"));
        System.out.println(str2.endsWith("g"));
        System.out.println(str2.contains("a"));
        System.out.println(str3.length());
        String str5 = "san";
        String str6 = str2 + str5;
        str2 = "san";
        String str7 = str2.concat("");
        System.out.println(str6);
        System.out.println(str7);
        System.out.println("================");

        char[] cArr = str2.toCharArray();
        for (int h = 0;h < cArr.length;h++){
            System.out.println(cArr[h]);
        }
        for (char c : cArr){
            System.out.println(c);
        }
        System.out.println("=============");

        System.out.println(str2.charAt(0));
        System.out.println(str2.indexOf('n'));
        System.out.println(str6.length());
        char[] ccArr = str6.toCharArray();
        for (int k  = 0;k < ccArr.length;k++){
            System.out.println(ccArr[k]+ " ");
        }
        System.out.println("==============");
        System.out.println(str6.substring(5));
        System.out.println(str6.substring(0,5));

        String str11 = "1,2,3,4,5";
        String[] strArr = str11.split(",",3);
        for (int g = 0;g < strArr.length;g++){
            System.out.println(strArr[g]);
        }

        String str12 = "  12  ";
        System.out.println(str12.trim());
        String str13 = "zhangssan";
        System.out.println(str13.replace('s',' '));
    }
}
