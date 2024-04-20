package service;

public class UserServiceProxy implements UserService{

    private UserService userService;


    @Override
    public void add() {
        System.out.println("add");

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void check() {

    }

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
        userService.add();
    }

    private void log(String msg){
        System.out.println("我是日志" + msg);
    }
}
