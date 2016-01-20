package com.junk.os.cine.controllers;

import com.junk.os.cine.crud.CRUDManager;
import com.junk.os.cine.models.Film;
import com.junk.os.cine.models.Genre;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name ="cineBean")
@SessionScoped
public class CineBean {
    List<Genre> genres;
    List<Film> films;
    Film film;
    Genre genre;

    public String doSearch(){
        try {
            films = CRUDManager.getInstance().getFilms(genre.getName());
            return "films";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String doView(Film film){
        this.film = film;
        return "view";
    }

    public String doBackHome(){
        return "genre";
    }

    public String doBackList(){
        return "films";
    }

    public CineBean(){
        try {
            genres = CRUDManager.getInstance().getGenres();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        films = new ArrayList<Film>();
        film = new Film();
        genre = new Genre();
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
