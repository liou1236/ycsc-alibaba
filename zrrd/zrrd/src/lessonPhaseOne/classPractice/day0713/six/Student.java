package lessonPhaseOne.classPractice.day0713.six;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int score;
    public Student(String name,int age,int score){
        this.age = age;
        this.name = name;
        this.score = score;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }

    @Override
    public int compareTo(Student other){
        int scoreComparison = Integer.compare(other.score,this.score);
        return (scoreComparison != 0) ? scoreComparison : Integer.compare(this.age, other.age);
    }
    @Override
    public String toString(){
        return name + "\t" + age + "\t" + score;
    }
}
