public class Main {
    public static void main(String[] args) {
        String[] names = {"aaa", "bbb"};
        String name = "ccc";

        int len = names.length;
        String[] newNames = new  String[len+1];
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }

        names = newNames;
        names[len] = name;

        for (String sname:newNames) {
            System.out.println(sname);
        }
    }
}