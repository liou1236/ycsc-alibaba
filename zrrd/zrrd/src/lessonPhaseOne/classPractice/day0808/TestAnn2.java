package lessonPhaseOne.classPractice.day0808;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnn2 {
String desc();
}

class TestAnn2Test{
    @TestAnn2(desc = "value")
    String desc;
}
