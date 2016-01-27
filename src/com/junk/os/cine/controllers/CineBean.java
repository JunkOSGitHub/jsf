package com.junk.os.cine.controllers;

import com.junk.os.cine.crud.Facade;
import com.junk.os.cine.models.Film;
import com.junk.os.cine.models.Genre;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name ="cineBean")
@SessionScoped
public class CineBean {
    @EJB
    private Facade facade;
    List<Genre> genres;
    List<Film> films;
    Film film;
    Genre genre;

    public String doSearch(){
        films = facade.getFilms(genre.getName());
        return "films";
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
        genres = new ArrayList<Genre>();
        films = new ArrayList<Film>();
        film = new Film();
        genre = new Genre();
    }

    public List<Genre> getGenres() {
        if(genres.isEmpty()) {
            System.out.println("Genres is null");
            genres = facade.getGenres();
            System.out.println("Size : "+genres.size());
            return genres;
        }
        System.out.println("Genres is not null");
        System.out.println("Size : "+genres.size());
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
