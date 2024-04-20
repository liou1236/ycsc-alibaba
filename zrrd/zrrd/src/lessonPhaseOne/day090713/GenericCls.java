package lessonPhaseOne.day090713;

public class GenericCls<T> {
    private T value;
    public GenericCls(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
    public <T> T genericMethod(T value1){
        System.out.println(value1);
        return value1;
    }


}
