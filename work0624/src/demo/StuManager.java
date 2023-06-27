package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

//负责对学生的增删改查操作(业务逻辑)
public class StuManager {
    //其实就是对ArrayList的再次封装
    private ArrayList<Stu> al = new ArrayList<>();//作为成员属性

    //在构造方法中初始化一些学生信息，不用每次都要我们手动输入信息
    public StuManager() {
        al.add(new Stu(1, "a", 21, 43, "在读"));
        al.add(new Stu(2, "a", 24, 94, "在读"));
        al.add(new Stu(4, "c", 22, 91, "退学"));
        al.add(new Stu(3, "b", 25, 95, "在读"));
        al.add(new Stu(5, "b", 26, 90, "退学"));
    }

    //下面所有的方法都是围绕着同一个集合,数据共享

    //添加学生信息
    public boolean add(Stu stu){
        //添加学生需要根据id做判重操作，如果添加的学生信息的id重复，就不调用add方法。
        if (al.equals(stu)){//需要根据id重写equals方法
            return false;
        }
        al.add(stu);
        return true;
    }

    //1.获取所有的学生信息
    public ArrayList<Stu> selectAll(){
        //ArrayList再初始化的时候可以通过构造方法传入一个集合的所有数据的复制品
        return new ArrayList<Stu>(al);
    }

    //2.根据id查询
    public Stu selectById(int id){//这里只有id参与到算法中
        //先找到这个id值的对象所在的下标位置
        int index = al.indexOf(new Stu(id));
        if (index == -1){
            return null;//表示没找到
        }
        return al.get(index);
    }

    //3.根据name查询 name是允许重复的
    public ArrayList<Stu> selectByName(String name){
        //需要循环去匹配
        //新建一个容器负责装载匹配的数据
        ArrayList<Stu> byName = new ArrayList<>();
        for (Stu stu : al) {
            if (stu.getName().equals(name)){
                byName.add(stu);//符合要求的元素添加进新的集合中
            }
        }
        return byName;
    }

    //4.根据状态查询学生的信息(无论是在读还是退学都是根据状态查询,只是换了字段而已)
    public ArrayList<Stu> selectByStatus(String status){
        ArrayList<Stu> byStatus = new ArrayList<>();
        for (Stu stu : al) {
            if (stu.getStatus().equals(status)){
                byStatus.add(stu);
            }
        }
        return byStatus;
    }

    //5.成绩排行前n位的学生信息
    public ArrayList<Stu> sortByGrade(int limitCount){
        //排序的过程不能影响原来的数据顺序
        ArrayList<Stu> sort = new ArrayList<>(al);
        Collections.sort(sort, new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                return Double.compare(o1.getGrade(),o2.getGrade());
            }
        });
        //再建立一个容器循环添加指定个数的元素
        ArrayList<Stu> sortByLimit = new ArrayList<>();
        //通过循环，截取 sort.size() 条数据的前 limitCount 条数据
        for (int i = 0; i < sort.size(); i++) {
            if (i == limitCount){
                break;
            }
            sortByLimit.add(sort.get(i));
        }
        return sortByLimit;
    }

    //根据学生id删除学生信息
    public Stu removeById(int id){
        //如果这里要告诉用户删除的对应的id的学生完整信息,那么就不能使用remove(E e)
        //要使用remove(int index)方法
        int index = al.indexOf(new Stu(id));
        if (index == -1){
            return null;//删除失败
        }
        Stu stu = al.remove(index);
        return stu;// 通过下标删除一个元素,并且保存删除元素的信息
    }

    //根据name删除学生信息
    public ArrayList<Stu> removeByName(String name){
        //删除的重复name的学生信息都进行返回
        ArrayList<Stu> byName = new ArrayList<>();
        //删除多个元素 首选迭代器
        Iterator<Stu> it = al.iterator();
        while (it.hasNext()) {
            Stu stu =  it.next();
            if (name.equals(stu.getName())){
                it.remove();
                byName.add(stu);
            }
        }
        return byName;
    }

    //修改学生的状态
    public int updateStatusById(int id,String status){
        //当你的方法的操作结果有多种情况的时候 boolean的返回值true false就不能明确的给与结果
        //这个学生不存在
        int index = al.indexOf(new Stu(id));
        if (index == -1){
            return -1;//-1就表示学生不存在
        }
        //学生存在
        Stu stu = al.get(index);
        //这个学生要修改的状态和他原来的状态是一样的,没必要修改
        if (status.equals(stu.getStatus())){
            return -2;
        }
        stu.setStatus(status);//修改元素的状态
        return 1;
    }

}
