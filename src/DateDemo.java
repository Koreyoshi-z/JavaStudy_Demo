import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        //使用Date类
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); //返回自 1970年1月1日 00:00:00 GMT 以来此Date对象表示的毫秒数。
        date.setTime(23545768768L); //自定义时间
        System.out.println(date);
        System.out.println("------------分割线-----------");

        //使用DateFormat类
        //DateFormat是抽象类，不能被实例化，我们可以调用getInstance()静态方法来获取实例。
        DateFormat df1 = DateFormat.getInstance();
        System.out.println(df1.format(date));
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, new Locale("zh","CN"));
        System.out.println(df2.format(date));
        DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
        System.out.println(df3.format(date));
        System.out.println("------------分割线-----------");


        //使用SimpleDateFormat日期格式类
        //文本->日期
        String strDate = "2000-2-22 12:13:14.555";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//设置转换的格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss.SSS");
        Date d = null;
        try {
            d = sdf1.parse(strDate); //转换时可能会出错
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(d);
        //日期->文本
        String str = sdf2.format(d);
        System.out.println(str);
    }
}
