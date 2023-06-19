import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 综合案例：统计字符串出现的次数
 * 需求：给定一个字符串数组，数组中内容有重复，现要求打印输出各个字符串出现的次数。
 * 解题思路：使用hashMap设计
 * key可以存放出现的内容，value存放出现的次数，每一次出现我都让value+1，那么value是几就出现了几次。
 */
public class HashMapDemo3 {
    public static void main(String[] args) {
        String[] strs = {"a","b","e","g","f","s","s","g","a","d","c","b","s","f","d","g"};
        Map<String,Integer> data = AccountUtil.account(strs);
        AccountUtil.printData(data);
    }
}

class AccountUtil{
    public static Map<String,Integer> account(String[] strs){
        Map<String,Integer> data = new HashMap<String,Integer>();
        //遍历数组
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (data.get(str) == null){//如果是第一次出现的单词，我们就将value设置为1
                data.put(str,1);
            }else {//如果不是第一次出现这个单词，我们就让value+1
                data.put(str,data.get(str)+1);
            }
        }
        return data;
    }

    public static void printData(Map<String,Integer> data){
        Set<Map.Entry<String,Integer>> entrySet = data.entrySet();
        Iterator<Map.Entry<String,Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> next =  it.next();
            System.out.println(next.getKey()+"出现的次数为："+next.getValue());
        }
        
    }

}