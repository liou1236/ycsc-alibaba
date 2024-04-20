package lessonPhaseOne.day0802;

public class Test01 {
    public static void main(String[] args) {
        // 创建 Dog 对象
        Dog dog = new Dog();

        // 上转型：将 Dog 对象转换为 Animal 类型
        Animal animal = dog;

        // 调用父类的方法
        animal.makeSound(); // 输出 "狗狗汪汪叫"


        // 注意：上转型后，只能调用父类中的方法，无法调用子类特有的方法
        // animal.fetch(); // 编译错误，Animal 类中没有 fetch() 方法

        Animal animal1 = new Dog();
        animal1.makeSound();

        Animal animal2 = new Animal();
        Dog dog1 = new Dog();

        animal2.makeSound();
    }
}
class Animal {
    void makeSound() {
        System.out.println("动物发出声音");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("狗狗汪汪叫");
    }

    void fetch() {
        System.out.println("狗狗在接飞盘");
    }
}
