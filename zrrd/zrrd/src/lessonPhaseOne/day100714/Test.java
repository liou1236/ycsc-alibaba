package lessonPhaseOne.day100714;

public class Test {
    public static void main(String[] args) {
        int count = 0;
        while (true){
            System.out.println("---------");
            count++;
            if (count == 100){
                break;
            }
        }
        System.out.println("");
        info(1);
    }

    public static void info(Integer num){
        System.out.println("Integer");
    }
}
class Num implements Comparable<Num>{
    int value;
    @Override
    public int compareTo(Num o){
        if (this.value > o.value) return -1;
        if (this.value < o.value) return 1;
        return 0;
    }
}
