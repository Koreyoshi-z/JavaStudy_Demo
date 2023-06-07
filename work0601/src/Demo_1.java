public class Demo_1 {
    public static void main(String[] args) {
        //题目：要求封装方法实现判断某年是否闰年。调用方法实现打印1900年到2100年之间的闰年，一行打印4个。
        int count = 0;
        for (int year = 1900; year <= 2100; year++) {
            if (isLeapYear(year)) {
                System.out.print(year + "\t");
                count++;
                //每行打印四个结果
                if (count % 4 == 0) {
                    System.out.println();
                }
            }

        }
    }
    //判断年份是否为闰年
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
