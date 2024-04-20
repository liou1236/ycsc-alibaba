package lessonPhaseOne.classPractice.day0714;

public class GenericCls<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericCls(T value){
        this.value = value;
    }


}
