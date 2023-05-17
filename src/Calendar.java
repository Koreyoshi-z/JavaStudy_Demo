import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {

        /*
        1.实现从控制台接收年和月，判断是否是闰年
        2.编程计算输入月份所对应的天数
         */
        int year;            //保存输入的年
        int month;           //保存输入的月
        int days = 0;        //保存指定月的天数
        boolean isRn;        //闰年保存true，否则为false

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        year = sc.nextInt();
        System.out.println("请输入月份：");
        month = sc.nextInt();

        /*
        普通闰年：公历年份是4的倍数且不是100的倍数为普通闰年（如2004、2020年就是闰年）。
        世纪闰年：公历年份是整百数的，必须是400的倍数才是世界闰年（如2000是世纪闰年，1900不是世纪闰年）。
        总结：能被4整除却不能被100整除或能被400整除的年份就是闰年！
         */

        //判断年份是否为闰年
        isRn = (year % 4 == 0 || year % 100 != 0) && year % 400 == 0;

        if (isRn){
            System.out.println(year+"是闰年！");
        }else {
            System.out.println(year+"不是闰年！");
        }

        //根据月份判断天数
        //方法一：使用if-else语句实现
        /*
        *
        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            days=31;
        } else if (month==2) {
            if (isRn){
                days=29;
            }else {
                days=28;
            }
        } else if (month==4||month==6||month==9||month==11) {
            days=30;
        }else {
            System.out.println("月份输入有误！");
        }
        */

        //方法二：使用switch语句实现
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days=31;
                break;
            case 2:
                if (isRn){
                    days=29;
                }else {
                    days=28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days=30;

        }

        System.out.println(year+"年"+month+"月对应的天数为:"+days);

    }
}
