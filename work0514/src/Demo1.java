public class Demo1 {
    public static void main(String[] args) {
        /* 题目要求：定义多个变量存储信息，并打印信息，按以下两种格式显示
         * 姓名:Lisi;
         * 性别:男;
         * 年龄:25;
         * 工资:3000;
         * 社保：314.59

         * 姓名     性别 年龄 工资 社保
         * Lisi       男     25     3000  314.59
         */

        //定义变量
        String name = "Lisi";
        char gender = '男';
        int age = 25;
        int salary = 3000;
        double social_security = 314.59;

        //控制台打印信息
        //方式一
        System.out.println("姓名:"+name);
        System.out.println("性别:"+gender);
        System.out.println("年龄:"+age);
        System.out.println("工资:"+salary);
        System.out.println("社保:"+social_security);
        //方式二
        System.out.println("姓名\t"+"性别\t"+"年龄\t"+"工资\t"+"社保\t\n"+name+"\t"+gender+"\t"+age+"\t"+salary+"\t"+social_security);
    }
}
