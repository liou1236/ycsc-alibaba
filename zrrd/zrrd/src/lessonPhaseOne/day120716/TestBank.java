package lessonPhaseOne.day120716;


public class TestBank extends Thread{

    Account account;
    double money;
    Object obj = new Object();
    public TestBank(String name,Account account,double money){
        super(name);
        this.account = account;
        this.money = money;
    }
    synchronized
    @Override
    public void run(){
        synchronized (account) {
            if (account.balance < money) {
                System.out.println("余额不足");
                return;
            }
            System.out.println(getName() + "可以取钱");
            account.balance = account.balance - money;
            System.out.println("取钱后的余额为：" + account.balance);
        }
    }

    public static void main(String[] args) {
        Account account = new Account("123456",888);
        new TestBank("zhangsan",account,666).start();
        new TestBank("lisi",account,444).start();
    }
}
    class Account{
        String accountId;
        double balance;
        public Account(String accountId,double balance){
            this.accountId = accountId;
            this.balance = balance;
        }
    }

