package lessonPhaseOne.day060710;

public class TStudent {
    public String name;
    public String dept;
    public String cla;
    public String comment;
    public int age;
    public TStudent(){

    }
    public TStudent(String name,String dept,String cla,
                    String comment,int age){
        this.name = name;
        this.dept = dept;
        this.cla = cla;
        this.comment = comment;
        this.age = age;
    }
    public String toString(){
        return "{ 姓名是:" + name + " 年龄:" +
                age + " 班级:" + cla + " 专业:"
                + dept + " 备注:"+ comment +" }";
    }
}
