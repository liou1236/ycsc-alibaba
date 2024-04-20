package lessonPhaseOne.classPractice.day0808;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws NoSuchFieldException {
        Class ccc = superLotto.class;
        System.out.println(ccc);
        Field[] files = ccc.getFields();
        for (Field field : files){
            System.out.println(field.getName());
        }

        Method[] methods = ccc.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
//        Field f1 = ccc.getField("arr1");
//        System.out.println(f1);

    }
}
