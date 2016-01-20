package com.junk.os.login.controllers;


import com.junk.os.login.models.Login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name ="ctrl")
@RequestScoped
public class ControlLogin {
    private Login login;

    public ControlLogin(){
        this.login = new Login();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String doControle(){
        return login.isKnown() ? "connu.xhtml" : "inconnu.xhtml";
    }
}
