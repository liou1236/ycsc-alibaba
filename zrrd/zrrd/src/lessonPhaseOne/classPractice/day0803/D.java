package lessonPhaseOne.classPractice.day0803;

public class D implements Comparable{
    int age;
    public D(int age){
        this.age = age;
    }

    public int compareTo(Object o) {
        D d = (D) o;
        if (this.age > d.age) {
//            this.age = this.age + d.age;
//            d.age = this.age - d.age;
//            this.age = this.age - d.age;
            return 1;
        } else if (this.age < d.age) {
            return -1;
        } else {
            return 0;
        }
    }
//    @Override
//    public boolean equals(){
//        return true;
//    }
//    @Override
//    public int hashCode(){
//        return 1;
//    }
    @Override
    public String toString(){
        return "age:"+ age;
    }

}
