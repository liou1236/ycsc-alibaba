package lessonPhaseOne.classPractice.day0810;

public class CreatListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;
        int n = 5;
        for (int i = 2; i <= n; i++) {
            System.out.println(pre);
            ListNode listNode = new ListNode(i);
            pre.next = listNode;
            pre = listNode;

        }

    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
    @Override
    public String toString(){
        return val + "";
    }
}
