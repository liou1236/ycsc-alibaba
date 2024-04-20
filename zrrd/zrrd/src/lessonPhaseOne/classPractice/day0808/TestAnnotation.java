package lessonPhaseOne.classPractice.day0808;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
//@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.SOURCE)
//@Retention(RetentionPolicy.CLASS)
//@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

}
