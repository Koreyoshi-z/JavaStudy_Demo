import java.util.ArrayList;
import java.util.HashMap;

//测试类
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.remove("a");
        System.out.println(list);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a",1);
        System.out.println(map);
    }
}
