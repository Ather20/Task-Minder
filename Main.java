/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskminder;
import java.util.Scanner;
import java.util.List;
/**
 *
 * 
 */
public class Main {
    
private User[] users;

    private Scanner scanner = new Scanner(System.in);

    public Main() {
        this.users = new User[0];
    }

    public void displayMenu() {
        System.out.println("\nTaskMinder Menu:");
        System.out.println("1. Create User");
        System.out.println("2. Manage Tasks and Reminders");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

   public void handleUserInput() {
    Scanner scanner = new Scanner(System.in);

    try {
        System.out.print("Enter username to manage tasks: ");
        String username = scanner.nextLine();

        User user = findUser(username);

        if (user != null) {
            // Check if the user is an admin
            if (user.isAdmin()) {
                // Admin-specific actions
                System.out.println("\nAdmin Menu for " + user.getUsername());

                boolean adminMenu = true;
                while (adminMenu) {
                    System.out.println("1. Manage User Accounts");
                    System.out.println("2. Ensure Data Security");
                    System.out.println("3. Provide Customer Support");
                    System.out.println("4. Show All Tasks");
                    System.out.println("5. Exit Admin Menu");
                    System.out.print("Enter your choice: ");

                    try {
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        switch (adminChoice) {
                            case 1:
                                System.out.print("Enter username to manage accounts: ");
                                String userToManage = scanner.nextLine();
                                User userToManageObj = findUser(userToManage);

                                if (userToManageObj != null) {
                                    System.out.println("User accounts managed for " + user.getUsername());
                                } else {
                                    System.out.println("User not found.");
                                }
                                break;

                            case 2:
                                ((Admin) user).ensureDataSecurity();
                                break;

                            case 3:
                                ((Admin) user).provideCustomerSupport();
                                break;
                            
                            case 4:
                                showAllTasks(user);
                                break;
                                
                            case 5:
                                adminMenu = false;
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        // Handle non-integer input
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scanner.nextLine();  // Consume invalid input
                    }
                }
            } else {
                // Regular user actions
                System.out.println("\nUser Menu for " + user.getUsername());

                boolean userMenu = true;
                while (userMenu) {
                    System.out.println("1. Create Task");
                    System.out.println("2. Modify Task");
                    System.out.println("3. Delete Task");
                    System.out.println("4. Set Reminder");
                    System.out.println("5. View Progress");
                    System.out.println("6. Show All Tasks");
                    System.out.println("7. Change Task Status");
                    System.out.println("8. Exit User Menu");
                    System.out.print("Enter your choice: ");

                    try {
                        int choice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        switch (choice) {
                            case 1:
                            System.out.print("Enter task name: ");
                            String taskName = scanner.nextLine();
                            System.out.print("Enter due date: ");
                            String dueDate = scanner.nextLine();
                            System.out.print("Enter duration (in hours): ");
                            int duration = scanner.nextInt();
                            user.createTask(taskName, dueDate, duration);
                            break;

                        case 2:
                            System.out.print("Enter task name to modify: ");
                            String taskToModify = scanner.nextLine();
                            Task task = findTask(user, taskToModify);
                            if (task != null) {
                                System.out.print("Enter new due date: ");
                                String newDueDate = scanner.nextLine();
                                System.out.print("Enter new duration (in hours): ");
                                int newDuration = scanner.nextInt();
                                user.modifyTask(task, newDueDate, newDuration);
                            } else {
                                System.out.println("Task not found.");
                            }
                            break;

                        case 3:
                            System.out.print("Enter task name to delete: ");
                            String taskToDelete = scanner.nextLine();
                            Task taskToDeleteObj = findTask(user, taskToDelete);
                            if (taskToDeleteObj != null) {
                                user.deleteTask(taskToDeleteObj);
                            } else {
                                System.out.println("Task not found.");
                            }
                            break;

                        case 4:
                            System.out.print("Enter reminder date: ");
                            String reminderDate = scanner.nextLine();
                            System.out.print("Enter reminder message: ");
                            String reminderMessage = scanner.nextLine();
                            user.setReminder(reminderDate, reminderMessage);
                            break;

                        case 5:
                            user.viewProgress();
                            break;

                        case 6:
                                showAllTasks(user);
                                break;
                                
                        case 7:
                                changeTaskStatus(user);
                                break;
                                
                        case 8:
                                userMenu = false;
                                break;
                                
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        // Handle non-integer input
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scanner.nextLine();  // Consume invalid input
                    }
                }
            }
        } else {
            System.out.println("User not found.");
        }
    } catch (Exception e) {
        // Handle any other exceptions
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
}


    public void addUser(User user) {
        users = addUserToArray(users, user);
        System.out.println("User added: " + user.getUsername());
    }

    public void handleError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
    
private User findUser(String username) {
    for (User user : users) {
        if ("Admin".equalsIgnoreCase(username)) {
            return new Admin("Admin");
        }
        if (user.getUsername().equalsIgnoreCase(username)) {
            return user;
        }
    }
    return null;
}

   public void changeTaskStatus(User user) {
        List<Task> tasks = user.getTasks();

        if (!tasks.isEmpty()) {
            // Display tasks for the user
            System.out.println("\nTasks for " + user.getUsername() + ":");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getName());
            }

            // Prompt user to enter the name of the task to change status
            System.out.print("Enter the name of the task to change status: ");
            String taskName = scanner.nextLine();

            // Find the task by name
            Task selectedTask = findTaskByName(tasks, taskName);

            if (selectedTask != null) {
                selectedTask.markAsComplete();
                System.out.println("Task status changed to Complete: " + selectedTask.getName());
            } else {
                System.out.println("Task not found. Please enter a valid task name.");
            }
        } else {
            System.out.println("No tasks found.");
        }
    }

    // Helper method to find a task by name
    private Task findTaskByName(List<Task> tasks, String taskName) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                return task;
            }
        }
        return null;
    }
    
    private void showAllTasks(User user) {
        System.out.println("\nAll Tasks for " + user.getUsername() + ":");
        List<Task> tasks = user.getTasks();
        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                System.out.println("Task: " + task.getName() +
                                   ", Due Date: " + task.getDueDate() +
                                   ", Duration: " + task.getDuration() + " hours" +
                                   ", Status: " + task.getStatus());
            }
        } else {
            System.out.println("No tasks found.");
        }
    }

    private Task findTask(User user, String taskName) {
        for (Task task : user.getTasks()) {
            if (task.getName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }

    private User[] addUserToArray(User[] users, User newUser) {
        User[] newArray = new User[users.length + 1];
        System.arraycopy(users, 0, newArray, 0, users.length);
        newArray[users.length] = newUser;
        return newArray;
    }
}
