public class Test {
    public static void main(String[] args) {
        Italk people = new People("张三",22);
        people.talk("没有代理");
        System.out.println(people);
        System.out.println("-------------------");

        TalkProxy talkProxy = new TalkProxy(people);
        talkProxy.talk("代理了","七里香");

    }
}
