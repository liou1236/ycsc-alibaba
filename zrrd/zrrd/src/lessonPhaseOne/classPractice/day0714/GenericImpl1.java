package lessonPhaseOne.classPractice.day0714;

public class GenericImpl1 extends GenericInterface<String> {
    @Override
    public void info(String value){
        System.out.println(value);
    }
    // 泛型，是方法、类和接口使用的形参，
    // 这个形参在声明变量时、创建对象时、调用方法时，
    // 动态的指定了参数类型，变成了实参.
}
