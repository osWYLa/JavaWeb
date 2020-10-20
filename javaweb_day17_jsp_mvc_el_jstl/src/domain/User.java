package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wyl
 * @create 2020-10-19
 * @Description
 * @Version
 */
public class User {
    private String username;
    private String password;
    private Date birthday;

    public User(String username, String password, Date birthday) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public User() {
    }


    /*
     * @Author wyl
     * @function  逻辑视图 在EL表达式提取属性的时候，若需要对原始的成员变量进行处理，一般使用这种逻辑视图的方式，提供get方法，使用时使用 birStr
     * @Param []
     * @return java.lang.String
     */
    public String getBirStr(){
        if (birthday != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(birthday);
        }else {
            return "";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
