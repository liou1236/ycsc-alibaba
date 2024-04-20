package lessonPhaseOne.classPractice.day0718;

public class TestBank extends Thread{
    // 银行类需要有账户来取钱
    // Bank has a Account 构成一个类的组合关系
    double balance;
    Account account;
    double money;

    public static void main(String[] args) {
        TestBank testBank = new TestBank();

    }

    @Override
    public void run(){
        if (account.getBalance() >= money){
            System.out.println(getName() + " 可以取钱");
            double balance = account.getBalance();
//            balance -= money;
            account.setBalance(balance - money);
        }
    }


}
// 创建一个账户类
class Account{
    // 属性设置为账户id和余额
   private String accountId;
   private double balance;

    public static void main(String[] args) {
        Account account =new Account("zhanng",123334);

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
}
