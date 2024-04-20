package lessonPhaseOne.classPractice.day0728.Decorator;

import lessonPhaseOne.classPractice.day0728.Drink;

public class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
        super.setDesc("加糖");
        super.setPrice(1.23);
    }
}
