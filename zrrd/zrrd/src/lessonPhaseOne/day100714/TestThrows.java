package lessonPhaseOne.day100714;

public class TestThrows {

    public static void main(String[] args){
//        try{
//            throwException();
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("yichang");
//            throw new RuntimeException(e);
//
//        }
//
//            System.out.println("想要打印的信息");
        try{
            throwSelfException();
        }catch (SelfException e){
            e.printStackTrace();
            System.out.println("这是OtherSelfException");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("这是Exception");
            throw new RuntimeException();
        }finally {
            System.out.println("一定执行");
        }

    }
    public static void throwException() throws Exception{
        throw new NumberFormatException();
    }
    public static void throwSelfException() throws SelfException{
        throw new SelfException();
    }
    public static void throwSubSelfException() throws SubSelfException{
        throw new SubSelfException();
    }
}
