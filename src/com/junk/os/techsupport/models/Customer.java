package com.junk.os.techsupport.models;

import com.junk.os.utils.Generator;

public class Customer{
    protected long id;
    private String email;
    private String firstname;
    private String lastname;

    public Customer() {
        id = Generator.generateId();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
