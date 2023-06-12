import java.util.Objects;

public class User implements Comparable<User>{
    private String name;
    private String pwd;
    private int score;

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public User(String name, String pwd, int score) {
        this.name = name;
        this.pwd = pwd;
        this.score = score;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return score == user.score && Objects.equals(name, user.name) && Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pwd, score);
    }

    public String toString() {
        return "User{name = " + name + ", pwd = " + pwd + ", score = " + score + "}";
    }

    @Override
    public int compareTo(User o) {
        return o.score - score;//降序
    }
}
