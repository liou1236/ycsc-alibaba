package practice.first.one;

public class Addition {
    public int twoSum(int a, int b){
        System.out.println("int");
        int result = a + b;
        return result;
    }
    public byte twoSum(byte a,byte b){
        byte result = (byte) (a + b);
        return result;
    }
    public short twoSum(short a,short b){
        short result = (short) (a + b);
        return result;
    }
    public long twoSum(long a,long b){
        long result =  (a + b);
        return result;
    }
    public float twoSum(float a,float b){
        float result = (float) (a + b);
        return result;
    }
    public double twoSum(double a,double b){
        System.out.println("double");
        double result =  (a + b);
        return result;
    }
    public static void main(String[] args) {
        Addition addition = new Addition();
        System.out.println(addition.twoSum(1,1));
        System.out.println(addition.twoSum((byte) 1,(byte) 1));
        System.out.println(addition.twoSum((short) 1,(short) 1));
        System.out.println(addition.twoSum(1L,1L));
        System.out.println(addition.twoSum(1.0F,1.0F));
        System.out.println(addition.twoSum(1.0,1.0));

    }
}
