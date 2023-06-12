public class UserBus {
    private UserDao ud = new UserDao();

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        //一个方法只干一件事，但是可以调用多个其他的方法来完成目标
        //查询是否重复
        int index = ud.select(user.getName());
        if (index != -1) {
            return false;
        }
        //如果不重复则添加
        return ud.insert(user);
    }

    /**
     * 登陆
     * @param user
     * @return
     */
    public boolean login(User user) {
        int index = ud.select(user);
        if (index != -1) {
            return true;
        }
        return false;
    }
}
