package demo;

import java.util.ArrayList;
import java.util.Scanner;

//主界面展示 UI层
public class Menu {
    private Scanner scanner = new Scanner(System.in);//作为成员属性
    private String choice;
    private StuManager stuManager = new StuManager();//作为成员属性


    //主菜单
    public void mainMenu(){
        while (true){
            System.out.println("======================学生管理系统======================");
            System.out.println("1.添加学生信息");
            System.out.println("2.删除学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.查询学生信息");
            System.out.println("0.退出");
            choice = scanner.next();;
            switch (choice){
                case "1":
                    addMenu();
                    break;
                case "2":
                    removeMainMenu();
                    break;
                case "3":
                    updateMainMenu();
                    break;
                case "4":
                    selectMainMenu();
                    break;
                case "0":
                    return;//退出当前循环
                default:
                    break;
            }
        }
    }

    //添加学生信息
    public void addMenu(){
        while (true){
            //从键盘输入需要添加的学生信息
            System.out.println("请输入学生的id:");
            int id = scanner.nextInt();
            System.out.println("请输入学生的name:");
            String name = scanner.next();
            System.out.println("请输入学生的age:");
            int age = scanner.nextInt();
            System.out.println("请输入学生的grade:");
            double grage = scanner.nextDouble();
            System.out.println("请输入学生的status:");
            String status = scanner.next();

            //将这些属性加入到你的实体类对象中形成一个的存储元素
            Stu stu = new Stu(id,name,age,grage,status);//通过构造方法创建Stu类的对象
            if (stuManager.add(stu)){
                System.out.println("添加成功...");
            }else {
                System.out.println("添加失败,ID已经存在");
            }

            System.out.println("是否继续添加？ 输入n退出");
            choice = scanner.next();
            if (choice.equals("n")){
                break;
            }
        }
    }

    //查询学生信息主界面
    public void selectMainMenu(){
        while (true){
            System.out.println("1.查询所有学生信息");
            System.out.println("2.根据id查询学生信息");
            System.out.println("3.根据name查询学生信息");
            System.out.println("4.查询所有在读学生信息");
            System.out.println("5.查询所有退学学生信息");
            System.out.println("6.成绩排行前5位学生信息");
            System.out.println("0.返回上一级");
            choice = scanner.next();
            switch (choice){
                case "1":
                    selectAllMenu();
                    break;
                case "2":
                    selectByIdMenu();
                    break;
                case "3":
                    selectByNameMenu();
                    break;
                case "4":
                    selectByStatusIsOkMenu();
                    break;
                case "5":
                    selectByStatusIsNoMenu();
                    break;
                case "6":
                    selectByGradeMenu();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }

    //1.查询所有学生信息
    public void selectAllMenu(){
        ArrayList<Stu> al = stuManager.selectAll();
        if (al.isEmpty()){
            System.out.println("抱歉,没有学生信息");
        }else {
            MyUtil.showList(al,"所有学生信息");
        }
    }

    //2.根据id查询学生信息
    public void selectByIdMenu(){
        System.out.println("请输入你要查询的学生的id");
        int id = scanner.nextInt();
        Stu stu = stuManager.selectById(id);
        if (stu == null){
            System.out.println("没有该id的学生");
        }else {
            System.out.println("该学生的信息为:" + stu);
        }
    }

    //3.根据name查询学生信息
    public void selectByNameMenu(){
        System.out.println("请输入要查询的学生name");
        String name = scanner.next();
        ArrayList<Stu> byName = stuManager.selectByName(name);
        if(byName.isEmpty()){
            System.out.println("没有该name的学生信息");
        }else {
            MyUtil.showList(byName,"name为" + name + "的学生信息");
        }
    }

    //4.查询所有在读学生信息
    public void selectByStatusIsOkMenu(){
        ArrayList<Stu> al = stuManager.selectByStatus("在读");
        if (al.isEmpty()){
            System.out.println("没有在读学生信息");
        }else {
            MyUtil.showList(al,"所有在读学生信息");
        }
    }

    //5.查询所有退学学生信息
    public void selectByStatusIsNoMenu(){
        ArrayList<Stu> al = stuManager.selectByStatus("退学");
        if (al.isEmpty()){
            System.out.println("没有退学学生信息");
        }else {
            MyUtil.showList(al,"所有退学学生信息");
        }
    }

    //6.成绩排行前5位学生信息
    public void selectByGradeMenu(){
        ArrayList<Stu> al = stuManager.sortByGrade(5);
        if (al.isEmpty()){
            System.out.println("没有学生信息");
        }else {
            MyUtil.showList(al,"成绩排行前5的学生信息");
        }
    }


    //删除学生信息主界面
    public void removeMainMenu(){
        while (true){
            System.out.println("1.根据id删除学生信息");
            System.out.println("2.根据name删除学生信息");
            System.out.println("0.返回上一级");
            choice = scanner.next();
            switch (choice){
                case "1":
                    removeByIdMenu();
                    break;
                case "2":
                    removeByNameMenu();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }

    //1.根据id删除学生信息
    public void removeByIdMenu(){
        System.out.println("请输入要删除的学生的id");
        int id = scanner.nextInt();
        Stu stu = stuManager.removeById(id);
        if (stu == null){
            System.out.println("删除失败");
        }else {
            System.out.println("您删除的学生信息为:"+ stu);
        }
    }

    //2.根据name删除学生信息
    public void removeByNameMenu(){
        System.out.println("请输入要删除的学生的name");
        String name = scanner.next();
        ArrayList<Stu> byName = stuManager.removeByName(name);
        if (byName.isEmpty()){
            System.out.println("删除失败");
        }else {
            MyUtil.showList(byName,"您删除的学生的信息");
        }
    }


    //修改学生状态主界面
    public void updateMainMenu(){
        while (true){
            System.out.println("1.学生退学");
            System.out.println("2.学生复学");
            System.out.println("0.返回上一级");
            choice = scanner.next();
            switch (choice){
                case "1":
                    updateStatusNoMenu();
                    break;
                case "2":
                    updateStatusOkMenu();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }

    //1.学生退学
    public void updateStatusNoMenu(){
        //先给用户看到所有在读学生的信息
        ArrayList<Stu> al = stuManager.selectByStatus("在读");
        if (al.isEmpty()){
            System.out.println("没有在读的学生信息");
        }else {
            MyUtil.showList(al,"所有在读学生信息");
            System.out.println("请输入您要退学的学生的id");
            int id = scanner.nextInt();
            int result = stuManager.updateStatusById(id,"退学");
            if (result == -1){
                System.out.println("该学生不存在");
            }
            if (result == -2) {
                System.out.println("该学生已经退学");
            }
            if (result == 1){
                System.out.println("退学成功");
            }
        }
    }

    //2.学生复学:和退学正好是相反的
    public void updateStatusOkMenu(){
        ArrayList<Stu> al = stuManager.selectByStatus("退学");
        if (al.isEmpty()){
            System.out.println("没有退学的学生信息");
        }else {
            MyUtil.showList(al,"所有退学学生信息");
            System.out.println("请输入您要复学的学生的id");
            int id = scanner.nextInt();
            int result = stuManager.updateStatusById(id,"在读");
            if (result == -1){
                System.out.println("该学生不存在");
            }
            if (result == -2) {
                System.out.println("该学生已在读");
            }
            if (result == 1){
                System.out.println("复学成功");
            }
        }
    }

}
