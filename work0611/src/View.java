public class View {
    private int option;
    User user = new User();
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
                    user = inputUser();
                    break;
                case 2:

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
        do {
            System.out.println("1.新游戏");
            System.out.println("2.排行榜");
            System.out.println("3.返回");
            option = GameTools.input.nextInt();
            switch (option){
                case 1:

                    break;
                case 2:

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

    public User inputUser(){
        System.out.println("请输入用户名:");
        String name = GameTools.input.next();
        System.out.println("请输入密码:");
        String pwd = GameTools.input.next();

        return null;
    }
}
