package lessonPhaseOne.classPractice.day0728.Decorator;

import lessonPhaseOne.classPractice.day0728.Drink;

public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        super.setDesc("加牛奶");
        super.setPrice(2.45);
    }
}
