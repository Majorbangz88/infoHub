package Services;

import Data.Models.MyContactList;
import Data.Repositories.MyContactListRepositoryImpl;

import javax.swing.*;

import static java.lang.System.exit;


public class ContactListMethods {


    private static final MyContactListRepositoryImpl listRepository = new MyContactListRepositoryImpl();


    public static void mainMenu() {
        display("""
                ----------------------------------------
                Thank you for downloading this app.\s
                It is my hope that you find it useful...
                ----------------------------------------
                What would you like to do?
                1. Create account
                2. Login
                3. Exit
                """);
        String userInput = input("Enter:");
        switch (userInput) {
            case "1" -> createAccount();
            case "2" -> userLogin();
            case "3" -> exitApp();
        }
    }

    public static void contactLogger() {
        display("""
                What would you do next:
                1. Save contact
                2. Delete contact
                3. Delete all
                4. Search contact
                5. Display all
                6. Logout
                """);
        String userInput = input("Enter choice here: ");
        switch (userInput) {
            case "1" -> userEntry();
            case "2" -> deleteContact();
            case "3" -> deleteAll();
            case "4" -> findContactById();
            case "5" -> displayAll();
            case "6" -> exitApp();
        }
    }

    public static void displayAll() {
        String foundContact = listRepository.findAll().toString();
        display(foundContact);
        contactLogger();
    }

    public static void findContactById() {
        int userId = Integer.parseInt(input("Enter contact id: "));
        String foundContact = listRepository.findById(userId).toString();
        display(foundContact);
        contactLogger();
    }

    public static void deleteAll() {
        listRepository.findAll();
        listRepository.clear();
        display("Your storage is brand new.");
        contactLogger();
    }

    public static void deleteContact() {
        int userId = Integer.parseInt(input("Enter entry id: "));
        MyContactList foundId = listRepository.findById(userId);
        listRepository.delete(foundId);
        display("Contact deleted successfully");
        contactLogger();
    }

    public static void userEntry() {
        String entryName = input("Name: ");
        String address = input("Address: ");
        String telephone = input("Telephone: ");
        String email = input("Email: ");

        MyContactList contactLog = new MyContactList();

        contactLog.setName(entryName); contactLog.setAddress(address);
        contactLog.setTelephone(telephone); contactLog.setEmail(email);
        MyContactList savedContact = listRepository.save(contactLog);
        display("Contact saved successfully\n" + savedContact.toString());
        contactLogger();
    }

    public static void exitApp() {
        display("Thank you and see you again soon.");
        exit(69);
    }

    public static void userLogin() {
        try {
            String username = input("Enter your username: ");
//            validateUsername(username);
            String password = input("Enter your password: ");
            validatePassword(password);
            display("Login successful");
            contactLogger();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            userLogin();
        }
    }
    public static void createAccount() {
        try {
            String username = input("Enter preferred username: ");
//            validateUsername(username);
            String password = input("Enter preferred password: ");
            validatePassword(password);
            display("Account created successfully" +
                    "\nKindly log in.");
            mainMenu();
        } catch (IllegalArgumentException e) {
            display(e.getMessage());
            createAccount();
        }
    }

    private static void validatePassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";
        if (!password.matches(regex) || password.length() < 7)
            throw new IllegalArgumentException("Password must contain at least an uppercase letter, " +
                    "lowercase letter, a special character and a number.");
    }

//    private static void validateUsername(String username) {
//
//        String isCorrectUsername = "^[a-z]+[0-9]*[a-z0-9]*$";
//        if (!isCorrectUsername.matches(username))
//            throw new IllegalArgumentException("Username must contain lowercase letters and at least a number.");
//    }

    public static String input(String prompt) {
        return JOptionPane.showInputDialog(null, prompt);
//        display(prompt);
//        return keyBoardInput.nextLine();
    }
    public static void display(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
//        System.out.println(prompt);
    }

}
