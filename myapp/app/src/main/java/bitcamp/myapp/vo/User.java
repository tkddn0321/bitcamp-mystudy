package bitcamp.myapp.vo;

import java.util.Objects;

public class User {

    private static int seqNo; // 매번 초기화 되면 안되고 한번만 선언되기 위해 statuc 으로 선언

    private int no;            // 매번 호출될때마다 선언되기 위해 non-static
    private String name;
    private String email;
    private String password;
    private String tel;

    public User() {

    }

    public User(int no) {
        this.no = no;
    }

    public static int getNextSeqNo() {

        return ++seqNo;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return no == user.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

