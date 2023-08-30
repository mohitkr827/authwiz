package com.authtools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    private JFrame loginFrame;
    private JFrame signupFrame;

    public gui() {
        createLoginWindow();
    }

    private void createLoginWindow() {
        loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 200);
        loginFrame.setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel emailLabel = new JLabel("Email:");
        final JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        final JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle login here
                String email = emailField.getText();
                char[] password = passwordField.getPassword();
                // Perform authentication
                // Show a message based on authentication result
                JOptionPane.showMessageDialog(loginFrame, "Login successful for email: " + email);
            }
        });

        JButton signupButton = new JButton("New User? Signup Here");
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the login window
                loginFrame.dispose();
                // Open the signup window
                showSignupWindow();
            }
        });

        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.add(signupButton, BorderLayout.SOUTH);
        loginFrame.setVisible(true);
    }

    private void showSignupWindow() {
        signupFrame = new JFrame("Signup");
        signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signupFrame.setSize(400, 300);
        signupFrame.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        final JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        final JTextField emailField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone Number:");
        final JTextField phoneField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        final JPasswordField passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        final JPasswordField confirmPasswordField = new JPasswordField();

        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle signup here
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();
                // Perform signup operation
                // Show a message based on signup result
                if (new String(password).equals(new String(confirmPassword))) {
                    JOptionPane.showMessageDialog(signupFrame, "Signup successful for email: " + email);
                } else {
                    JOptionPane.showMessageDialog(signupFrame, "Password and Confirm Password do not match.");
                }
            }
        });

        signupFrame.add(nameLabel);
        signupFrame.add(nameField);
        signupFrame.add(emailLabel);
        signupFrame.add(emailField);
        signupFrame.add(phoneLabel);
        signupFrame.add(phoneField);
        signupFrame.add(passwordLabel);
        signupFrame.add(passwordField);
        signupFrame.add(confirmPasswordLabel);
        signupFrame.add(confirmPasswordField);
        signupFrame.add(new JLabel());
        signupFrame.add(signupButton);

        signupFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new gui();
            }
        });
    }
}