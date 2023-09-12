package com.authtools;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        jdbc_dao userDao = new jdbc_dao();
        List<user> userList = userDao.getAllUsers();

        // Now, you can iterate through the userList and print the users
        for (user user : userList) {
            System.out.println("User ID: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("Phone No.: " + user.getPhone());
        }
    }
}
