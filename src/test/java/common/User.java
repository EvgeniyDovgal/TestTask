package common;

public class User {
    String email = "";
    String password = "";

    public User(String newEmail, String newPass){
        this.email = newEmail;
        this.password = newPass;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
