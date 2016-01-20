package com.junk.os.techsupport.crud;

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

    public Customer getCustomer(String email) throws SQLException {
        String req="SELECT * FROM CUSTOMERS where email=?";
        PreparedStatement stmt=conn.prepareStatement(req);
        stmt.setString(1,email);
        ResultSet rs=stmt.executeQuery();
        if(rs.next()) {
            Customer customer = new Customer();
            customer.setEmail(rs.getString(1));
            return customer;
        }
        return null;
    }

    public void createSupportRequest(SupportRequest request) throws SQLException{
        String req="INSERT INTO SUPPORT_REQUESTS(id,email,logiciel,os,incident) values(?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement stmt=conn.prepareStatement(req);
            stmt.setLong(1,request.getId());
            stmt.setString(2,request.getEmail());
            stmt.setString(3,request.getLogiciel());
            stmt.setString(4,request.getOs());
            stmt.setString(5,request.getIncident());
            stmt.executeUpdate();
            conn.commit();
        } catch(SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
    }

    public void registerCustomer(Customer customer) throws SQLException{
        String req="INSERT INTO CUSTOMERS VALUES(?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement stmt=conn.prepareStatement(req);
            stmt.setLong(1,customer.getId());
            stmt.setString(2,customer.getEmail());
            stmt.setString(3,customer.getFirstname());
            stmt.setString(4,customer.getLastname());
            stmt.executeUpdate();
            conn.commit();
        } catch(SQLException err) {
            conn.rollback();
            err.printStackTrace();
        }
    }

    public List<SupportRequest> getAllSupportRequest() throws SQLException {
        String req = "SELECT * FROM SUPPORT_REQUESTS";
        PreparedStatement stmt = conn.prepareStatement(req);
        ResultSet rs = stmt.executeQuery();
        List<SupportRequest> result = new ArrayList<>();
        while (rs.next()) {
            SupportRequest request = new SupportRequest();
            request.setId(rs.getLong(1));
            request.setEmail(rs.getString(2));
            request.setLogiciel(rs.getString(3));
            request.setOs(rs.getString(4));
            request.setIncident(rs.getString(5));
            result.add(request);
        }
        return result;
    }

    public void createTableCustomer() throws SQLException{
        String req = "CREATE TABLE CUSTOMERS " +
                "(id INTEGER not NULL, " +
                " email VARCHAR(255), " +
                " firstname VARCHAR(255), " +
                " lastname VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        DB.createDB(req,conn);
    }

    public void createTableSupportRequest() throws SQLException{
        String req = "CREATE TABLE SUPPORT_REQUESTS " +
                "(id INTEGER not NULL, " +
                " email VARCHAR(255), " +
                " logiciel VARCHAR(255), " +
                " os VARCHAR(255), " +
                " incident VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        DB.createDB(req,conn);
    }
}