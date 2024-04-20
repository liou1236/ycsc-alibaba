package lessonPhaseOne.classPractice.day25.serial;

import java.io.Serializable;

public class Health implements Serializable {

    private static final long serialVersionUID = -5564481076646804249L;
    String desc;

    public Health(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Health{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
