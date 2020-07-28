package duing.domain;

public class Admin {
    private String username;
    private String passoword;

    public Admin(){

    }

    public Admin(String username, String passoword) {
        this.username = username;
        this.passoword = passoword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", passoword='" + passoword + '\'' +
                '}';
    }
}
