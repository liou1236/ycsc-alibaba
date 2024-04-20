package lessonPhaseOne.classPractice.day0724;

public class TestGroup {
    public static void main(String[] args) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parentGroup = currentGroup.getParent();

        System.out.println(currentGroup.getName());
        System.out.println(parentGroup.getName());

        System.out.println("=====================");
        ThreadGroup group1 = new ThreadGroup("subThreadGroup_1");
        ThreadGroup group2 = new ThreadGroup(group1,"subThreadGroup_2");
        System.out.println(group1.getParent().getName());
        System.out.println(group2.getParent().getName());

    }
}
