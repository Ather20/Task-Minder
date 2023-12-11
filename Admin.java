/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskminder;

/**
 *
 * 
 */
public class Admin extends User{
       
public Admin(String username) {
        super(username);
    }

     @Override
    public boolean isAdmin() {
        return true;
    }
    public void manageUserAccounts(User user) {
        // Implement user account management logic
        System.out.println("User accounts managed for " + user.getUsername());
    }

    public void ensureDataSecurity() {
        // Implement data security logic
        System.out.println("Data security ensured");
    }

    public void provideCustomerSupport() {
        // Implement customer support logic
        System.out.println("Customer support provided");
    }
}
