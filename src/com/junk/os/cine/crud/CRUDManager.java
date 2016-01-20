package com.junk.os.cine.crud;

import com.junk.os.cine.models.Film;
import com.junk.os.cine.models.Genre;
import com.junk.os.techsupport.models.Customer;
import com.junk.os.techsupport.models.SupportRequest;
import com.junk.os.utils.DB;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.sql.*;

public class CRUDManager implements Serializable {
    private Connection conn;
    private String url="jdbc:oracle:thin:@oracle-edu.ec-lille.fr:1521:ecli4";
    private String user="EBM18";
    private String pw="SQL4ever";

    private ResultSet rs;

    public CRUDManager(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,pw);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static class CRUDManagerSingleton {
        private final static CRUDManager INSTANCE = new CRUDManager();
    }

    public static CRUDManager getInstance() {
        return CRUDManagerSingleton.INSTANCE;
    }

    public List<Film> getFilms(String genre) throws SQLException {
        String req="SELECT * FROM FILMS where genre=?";
        PreparedStatement stmt=conn.prepareStatement(req);
        stmt.setString(1,genre);
        ResultSet rs=stmt.executeQuery();
        List<Film> result = new ArrayList<>();
        while (rs.next()) {
            Film film = new Film();
            film.setId(rs.getLong(1));
            film.setName(rs.getString(2));
            film.setGenre(rs.getString(3));
            result.add(film);
        }
        return result;
    }

    public List<Genre> getGenres() throws SQLException {
        String req="SELECT * FROM GENRES";
        Statement stmt= conn.createStatement();
        ResultSet rs=stmt.executeQuery(req);
        List<Genre> result = new ArrayList<>();
        while (rs.next()) {
            Genre genre = new Genre();
            genre.setId(rs.getLong(1));
            genre.setName(rs.getString(2));
            result.add(genre);
        }
        return result;
    }

    public void createTableFilms() throws SQLException{
        String req = "CREATE TABLE FILMS " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " genre VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        DB.createDB(req,conn);
    }

    public void createTableGenres() throws SQLException{
        String req = "CREATE TABLE GENRES " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        DB.createDB(req,conn);
    }
}