/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mfgperez
 */
public class User {
    
    
    private String userName; 
    private String password; 
    
    
    public User() {
           this.userName = ""; 
         this.password = ""; 
    }
    public User(String username , String password) {
        
        this.userName = username; 
        this.password = password; 
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
