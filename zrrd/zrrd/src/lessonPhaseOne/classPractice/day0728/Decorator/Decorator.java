package lessonPhaseOne.classPractice.day0728.Decorator;

import lessonPhaseOne.classPractice.day0728.Drink;

public class Decorator extends Drink {
    private Drink drink;
    public Decorator(Drink drink){
        this.drink = drink;
    }
    @Override
    public double cost() {
        return super.getPrice() + drink.getPrice();
    }
    @Override
    public String getDesc(){
        return super.getDesc() + "的" + drink.getDesc();
    }
}
