package lessonPhaseOne.classPractice.day0807;

public class Demo {

        int x;
        public static void main(String[] args) 	{
            Demo d = new Demo();
            d.x = 8;
            d.show(d);
            System.out.println("x="+d.x);
        }
        public void show(Demo d)	{
            d.x = 7;
        }
    }

