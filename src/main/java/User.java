import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private String name;
    private String email;
    private int age;
    private String password;
    private LocalDateTime lastLoginTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public User(String name, String email, int age, String password, LocalDateTime lastLoginTime) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
        this.lastLoginTime = lastLoginTime;

        System.out.println();

    }
    public User() {

    }
}
