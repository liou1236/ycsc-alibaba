public class TalkProxy implements Italk{

    Italk italk;

    public TalkProxy(Italk italk) {
        this.italk = italk;
    }

    @Override
    public void talk(String msg) {
        italk.talk(msg);
    }

    void talk(String msg, String songName){
        italk.talk(msg);
        sing(songName);
    }

    private void sing(String songName){
        System.out.println("唱歌" + songName);
    }

}
