import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(); //获取Calendar类的对象实例
        System.out.println(calendar.get(Calendar.YEAR)); //获取当前年份
        System.out.println(calendar.get(Calendar.MONTH) + 1); //获取当前月份 这是一个特定于日历的值，在格里高利历和罗马儒略历中一年中的第一个月是 JANUARY，它为 0，所以最要 +1。
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //获取当前月份的天数
        System.out.println(calendar.get(Calendar.HOUR)); //获取当前小时数
        System.out.println(calendar.get(Calendar.MINUTE)); //获取当前分钟数
        System.out.println(calendar.get(Calendar.SECOND)); //获取当前秒数
        System.out.println(calendar.get(Calendar.DATE)); //获取当前日期
        System.out.println("------------分割线-----------");

        //也可以使用set方法自定义日期
        calendar.set(Calendar.YEAR, 2048);
        System.out.println(calendar); //打印calendar对象信息
    }
}
