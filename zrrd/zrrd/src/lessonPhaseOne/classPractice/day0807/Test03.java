package lessonPhaseOne.classPractice.day0807;

import java.io.Serializable;

public class Test03 implements Serializable {

    private static final long serialVersionUID = 8037148171234942794L;
    static int i = 0;
    public int aMethod() {
        i++;
        return i;
    }
    public static void main(String args[]) {
        Test03 Test03 = new Test03();
        Test03.aMethod();
        int j = Test03.aMethod();
        System.out.println(j);
        Test03 Test031 = new Test03();
        System.out.println(Test031.i);
    }
}

