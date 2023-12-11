/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskminder;
import java.util.Scanner;
/**
 *
 * 
 */
public class TaskMinder {
    
    public static void main(String[] args) {
        TaskMinder taskMinder = new TaskMinder();
        taskMinder.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Main mainApp = new Main();

        while (true) {
            mainApp.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    User newUser = new User(username);
                    mainApp.addUser(newUser);
                    break;

                case 2:
                    mainApp.handleUserInput();
                    break;

                case 3:
                    System.out.println("Exiting TaskMinder. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

