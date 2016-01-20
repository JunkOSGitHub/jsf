package com.junk.os.cine.models;

import com.junk.os.utils.Generator;

public class Film {
    long id;
    String name;
    String genre;

    public Film() {
        this.id = Generator.generateId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
