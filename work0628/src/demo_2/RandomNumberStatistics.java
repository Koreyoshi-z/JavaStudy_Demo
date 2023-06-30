package demo_2;

import java.util.*;

/*
    随机产生50个30到35的整数，统计每个数字出现的次数（TreeMap实现），输出时按照数字的降序排列，并且统计出现次数最多的数字和它的次数。
    PS：如果有两个数字出现的次数一样，则只需输出其中一个。
*/
public class RandomNumberStatistics {
    public static void main(String[] args) {
        //创建一个TreeMap用来存储数字及其出现次数
        //Collections.reverseOrder() -> 返回一个比较器，它强行逆转实现了 Comparable 接口的对象 collection 的自然顺序。
        TreeMap<Integer,Integer> numberOccurrences = new TreeMap<>(Collections.reverseOrder());//输出时按照数字的降序排列


        //随机产生50个30到35的整数
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int randomNumber = random.nextInt(6) + 30;
            //getOrDefault()方法 -> 获取 Map 中指定 key 的值，如果该 key 不存在，则返回默认值(自定义)
            numberOccurrences.put(randomNumber,numberOccurrences.getOrDefault(randomNumber,0)+1);
        }


        //统计每个数字出现的次数（TreeMap实现）
        Set<Map.Entry<Integer, Integer>> entries = numberOccurrences.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println("key: "+entry.getKey()+"  value: "+entry.getValue());
        }


        //统计出现次数最多的数字和它的次数
        //如果有两个数字出现的次数一样，则只需输出其中一个
        int maxNumber = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (maxCount < entry.getValue()){
                maxNumber = entry.getValue();
                maxCount = entry.getKey();
            }
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("出现最多的数字: " + maxNumber + "  出现的次数: " + maxCount);

    }
}
