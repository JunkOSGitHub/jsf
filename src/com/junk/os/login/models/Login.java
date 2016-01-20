package com.junk.os.login.models;

public class Login {
    protected String user;
    protected String password;

    public Login() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isKnown(){
        return this.user.equals("scott") && this.password.equals("tiger");
    }
}
