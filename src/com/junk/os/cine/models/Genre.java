package com.junk.os.cine.models;

import com.junk.os.utils.Generator;

import javax.persistence.*;

@Entity
@Table(name = "GENRES")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(length = 30)
    String name;

    public Genre() {
        this.id = Generator.generateId();
    }

    public Genre(String name) {
        this.name = name;
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
