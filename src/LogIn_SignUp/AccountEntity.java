package LogIn_SignUp;

public class AccountEntity {
    //الگوی طراحی builder
    private String username;
    private String password;
    private String semat;

    public String getSemat() {
        return semat;
    }

    public AccountEntity setSemat(String semat) {
        this.semat = semat;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AccountEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AccountEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
