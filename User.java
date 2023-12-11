/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskminder;

import java.util.ArrayList;
import java.util.List;

/**
 *

 */

class User {
 private String username;
    private List<Task> tasks;
    private List<Reminder> reminders;
    private int completionProgress;

    public User(String username) {
        this.username = username;
        this.tasks = new ArrayList<>();
        this.reminders = new ArrayList<>();
        this.completionProgress = 0;
    }
    
   public boolean isAdmin() {
        return false;
    }

    public void createTask(String taskName, String dueDate, int duration) {
        Task newTask = new Task(taskName, dueDate, duration);
        tasks.add(newTask);
        System.out.println("Task created: " + taskName);
    }

    public void modifyTask(Task task, String newDueDate, int newDuration) {
        task.setDueDate(newDueDate);
        task.setDuration(newDuration);
        System.out.println("Task modified: " + task.getName());
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
        System.out.println("Task deleted: " + task.getName());
    }

    public void setReminder(String date, String message) {
        Reminder newReminder = new Reminder(date, message);
        reminders.add(newReminder);
        System.out.println("Reminder set for " + date);
    }

    public void viewProgress() {
    List<Task> tasks = getTasks();
    if (!tasks.isEmpty()) {
        int completedTasks = 0;

        for (Task task : tasks) {
            if ("Complete".equals(task.getStatus())) {
                completedTasks++;
            }
        }

        // Calculate progress as a percentage
        int totalTasks = tasks.size();
        int progress = (int) (((double) completedTasks / totalTasks) * 100);

        System.out.println("Completion Progress: " + progress + "%");
    } else {
        System.out.println("No tasks found. Progress: N/A");
    }
    }

    public String getUsername() {
        return username;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Reminder> getReminders() {
        return reminders;
    }
}
