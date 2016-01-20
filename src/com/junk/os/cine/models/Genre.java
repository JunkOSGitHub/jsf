package com.junk.os.cine.models;

import com.junk.os.utils.Generator;

public class Genre {
    long id;
    String name;

    public Genre() {
        this.id = Generator.generateId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
