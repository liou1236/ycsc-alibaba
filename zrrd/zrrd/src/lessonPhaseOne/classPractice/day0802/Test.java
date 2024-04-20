package lessonPhaseOne.day0802;

public class Test {

        public static void main(String[] args) {
            SonTest parent = (SonTest) new FatherTest(); // 编译时类型为 Parent，运行时类型为 Child
            parent.display(); // 调用的是子类 Child 的 display() 方法吗？
        }


}
