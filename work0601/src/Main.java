public class Main {
    public static void main(String[] args) {
        double a = 3;
        double b = 9;
        System.out.println(getResult(a,b)); //传入的是值，并不是变量a，b
    }

    public static double getResult(double a,double b){
        return a * b;
    }
}