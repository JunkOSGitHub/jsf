package com.junk.os.techsupport.controllers;

import com.junk.os.techsupport.crud.CRUDManager;
import com.junk.os.techsupport.models.Customer;
import com.junk.os.techsupport.models.SupportRequest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;

@ManagedBean(name ="techSupportBean")
@SessionScoped
public class TechSupportBean {
    SupportRequest supp_request;
    Customer customer;

    public TechSupportBean(){
        supp_request = new SupportRequest();
        customer = new Customer();
    }

    public SupportRequest getSupp_request() {
        return supp_request;
    }

    public void setSupp_request(SupportRequest supp_request) {
        this.supp_request = supp_request;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String doRegister(){
        try {
            CRUDManager.getInstance().registerCustomer(customer);
            System.out.println("Not Create DB customer");
            return "thanks";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "index";
    }

    public String doReport(){
        createTables();
        try{
            CRUDManager.getInstance().createTableCustomer();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            CRUDManager.getInstance().createTableSupportRequest();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try {
            CRUDManager.getInstance().createSupportRequest(supp_request);
            Customer customer = CRUDManager.getInstance().getCustomer(supp_request.getEmail());
            System.out.println("Not Create DB support");
            if(customer != null){
                return "thanks";
            }
            else{
                customer = new Customer();
                customer.setEmail(supp_request.getEmail());
                return "register";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "register";
    }

    public void createTables(){
        try{
            CRUDManager.getInstance().createTableCustomer();
        }
        catch (SQLException e){
        }
        try{
            CRUDManager.getInstance().createTableSupportRequest();
        }
        catch (SQLException e){
        }
    }
}
