package com.junk.os.cine.crud;

import com.junk.os.cine.models.Film;
import com.junk.os.cine.models.Genre;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class Facade {

    @PersistenceContext(unitName = "CINE_PU")
    private EntityManager em;

    public List<Film> getFilms(String genre) {
        return em.createQuery("select m from Film as m where m.genre = '"+genre+"'",Film.class).getResultList();
    }

    public List<Genre> getGenres(){
        return em.createQuery("select m from Genre as m",Genre.class).getResultList();
    }


}
