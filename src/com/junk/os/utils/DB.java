package com.junk.os.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    public static void createDB(String req,Connection conn) throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(req);
            conn.commit();
        } catch(SQLException err) {
            conn.rollback();
            err.printStackTrace();
        }
    }
}
