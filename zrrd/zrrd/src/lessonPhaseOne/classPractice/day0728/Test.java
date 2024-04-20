//package lessonPhaseOne.classPractice.day0728;
//
//import lessonPhaseOne.classPractice.day0728.Coffee.NaTie;
//import lessonPhaseOne.classPractice.day0728.Decorator.Decorator;
//import lessonPhaseOne.classPractice.day0728.Decorator.Milk;
//import lessonPhaseOne.classPractice.day0728.Decorator.Sugar;
//
//public class Test {
//    public static void main(String[] args) {
//
//        Drink coffer = new NaTie();
//        System.out.println(coffer.getDesc());
//        System.out.println(coffer.getPrice());
//        System.out.println(coffer.cost());
//        System.out.println("------------");
//        Decorator milk = new Milk(coffer);
//        System.out.println(milk.cost());
//        System.out.println(milk.getDesc());
//        System.out.println("____________");
//        Decorator order = new Sugar(coffer);
//        System.out.println(order.getDesc());
//        System.out.println(order.cost());
//
//    }
//}
