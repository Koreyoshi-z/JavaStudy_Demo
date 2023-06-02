public class Demo_3 {
    public static void main(String[] args) {
        //封装一份方法，接收两个整数和一个操作符，根据操作符做相应的和差积商，并返回结果。
        int result = calculate(5,3,'+');
        System.out.println(result);
    }
    public static int calculate(int num1, int num2, char operator){
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        return result;
    }
}
