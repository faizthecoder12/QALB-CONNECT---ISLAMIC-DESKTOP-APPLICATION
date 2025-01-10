package qalbconnect_dsa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Authentication {
    private final Scanner scanner;
    private String currentUsername; // To store logged in user's username
    public Authentication() {
        scanner = new Scanner(System.in);
    }
    public boolean signUp(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password); // In a real application, you should hash the password
            
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.err.println("Error during signup: " + e.getMessage());
            return false;
        }
    }

    public boolean logIn(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password); // In a real application, you should hash the password
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                currentUsername = username;
                return true;
            }
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return false;
        }
    }

    public String getCurrentUsername() {
        return currentUsername;
    }

    // Test method
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        auth.signUp("testuser", "testpass");
        boolean loginSuccess = auth.logIn("testuser", "testpass");
        System.out.println("Login success: " + loginSuccess);
    }
}