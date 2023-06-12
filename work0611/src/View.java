import java.util.Arrays;
import java.util.Random;

public class View {
    private int option;//选项
    private User user;
    private UserBus ub = new UserBus();
    private UserDao ud = new UserDao();
    private String[] gusses = {"石头", "剪刀", "布"};
    private Random random = new Random();
    private int ranNum;
    //主菜单
    public void mainMenu(){
        do {
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("0.退出");
            System.out.println("请选择：");
            option = GameTools.input.nextInt();
            switch (option){
                case 1:
                    user = inputUser();//返回的值后续需要再次使用就需要用变量接收
                    if (ub.register(user)) {
                        System.out.println("注册成功！");
                    } else {
                        System.out.println("注册失败");
                    }
                    break;
                case 2:
                    user = inputUser();
                    if (!ub.login(user)) {
                        System.out.println("登陆失败！");
                        continue;
                    }
                    System.out.println("登陆成功！");
                    gameMenu();
                    break;
                case 0:
                    System.out.println("欢迎下次再来");
                    System.exit(0);
                    break;
                default:
                    System.out.println("选择有误！");
                    break;
            }
        }while (option!=0);
    }
    //游戏菜单
    public void gameMenu(){
        int opt = 0;
        do {
            int score = 0;
            System.out.println("1.新游戏");
            System.out.println("2.排行榜");
            System.out.println("3.返回");
            System.out.println("请选择：");
            option = GameTools.input.nextInt();
            switch (option){
                case 1:
                    for (int i = 0; i < gusses.length; i++) {
                        System.out.println((i + 1) + "、" + gusses[i]);
                    }
                    System.out.println("请输入猜拳：");//判断是否超过数组的下标
                    opt = GameTools.input.nextInt() - 1;//opt-1是数组下标
                    ranNum = random.nextInt(3);//0~2
                    if (opt == ranNum) {//平局
                        System.out.println("加油哟，平局");
                    } else if (opt == 0 && ranNum == 1 || opt == 1 && ranNum == 2 || opt == 2 && ranNum == 0) {//赢
                        System.out.println("恭喜您，赢了！");
                        score += 3;
                    } else {//剩余：输
                        System.out.println("真遗憾，输了！");
                    }
                    int index = ud.select(user.getName());
                    DB.users[index].setScore(DB.users[index].getScore() + score);
                    break;
                case 2:
                    //排序
                    Arrays.sort(DB.users);
                    //输出所有的元素
                    for (User user : DB.users) {
                        System.out.println(user);
                    }
                    break;
                case 3:
                    System.out.println("用户正在登出...");
                    break;
                default:
                    System.out.println("选择有误！");
                    break;
            }
        }while (option!=3);
    }

    /**
     * 用户信息输入
     *
     * @return
     */
    public User inputUser(){
        System.out.println("请输入用户名:");
        String name = GameTools.input.next();
        System.out.println("请输入密码:");
        String pwd = GameTools.input.next();
        return new User(name, pwd);
    }
}
