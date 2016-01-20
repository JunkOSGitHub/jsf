package com.junk.os.techsupport.models;


import com.junk.os.utils.Generator;

public class SupportRequest {
    protected long id;
    private String email;
    private String os;
    private String logiciel;
    private String incident;

    public SupportRequest() {
        id = Generator.generateId();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(String logiciel) {
        this.logiciel = logiciel;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}