/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskminder;

/**
 *
 * @author mohma
 */
public class Task {
    
  
    private String name;
    private String dueDate;
    private int duration;
    private String status;

    public Task(String name, String dueDate, int duration) {
        this.name = name;
        this.dueDate = dueDate;
        this.duration = duration;
        this.status = "Incomplete";
    }
    
    public void markAsComplete() {
        this.status = "Complete";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
