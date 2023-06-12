import java.util.Arrays;

//对容器最基本的操作
public class UserDao {
    /**
     * 名字查询是否存在
     * 返回为-1表示不存在
     *
     * @param name
     * @return
     */
    public int select(String name){
        for (int i = 0; i < DB.users.length; i++) {
            if (name.equals(DB.users[i].getName())){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查询用户对象是否存在
     * @param user
     * @return
     */
    public int select(User user) {
        for (int i = 0; i < DB.users.length; i++) {
            if (user.equals(DB.users[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加
     * @param user
     * @return
     */
    public boolean insert(User user) {
        DB.users = Arrays.copyOf(DB.users, DB.users.length + 1);
        DB.users[DB.users.length-1] = user;
        return true;
    }

}
