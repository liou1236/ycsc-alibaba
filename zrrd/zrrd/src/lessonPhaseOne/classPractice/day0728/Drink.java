package lessonPhaseOne.classPractice.day0728;

public abstract class Drink {
    private double price;
    private String desc;

    public abstract double cost();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
