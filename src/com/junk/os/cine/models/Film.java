package com.junk.os.cine.models;

import com.junk.os.utils.Generator;

import javax.persistence.*;

@Entity
@Table(name = "FILMS")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(length = 30)
    String name;
    @Column(length = 30)
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
