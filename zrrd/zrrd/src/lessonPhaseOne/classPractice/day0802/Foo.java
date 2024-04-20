package lessonPhaseOne.day0802;

public class Foo {


    public static void main(String[] args) {
        Foo foo = new Foo();
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        System.out.println(foo.operator(a,b));
        int r = 1;
        int t = 2;
        System.out.println(foo.Operator1(r,t));
    }
    public  String operator(StringBuffer x,StringBuffer y){
        x.append(y);
        y = x;
        return x + " " +y;
    }
    public  int Operator1(int a,int b){

        a = a + 3;

            b = a;

        return b;
    }
}
