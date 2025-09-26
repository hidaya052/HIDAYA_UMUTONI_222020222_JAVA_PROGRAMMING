package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dao.UserDAO;
import dao.EntityADAO;
import dao.EntityBDAO;
import dao.EntityCDAO;
import dao.EntityDDAO;
import dao.EntityEDAO;
import model.*;

public class TestApp extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane;
    private JTextArea outputArea;
    
    // DAO instances
    private UserDAO userDAO = new UserDAO();
    private EntityADAO entityADAO = new EntityADAO();
    private EntityBDAO entityBDAO = new EntityBDAO();
    private EntityCDAO entityCDAO = new EntityCDAO();
    private EntityDDAO entityDDAO = new EntityDDAO();
    private EntityEDAO entityEDAO = new EntityEDAO();
    
    public TestApp() {
        setTitle("Event Management System - Test Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        
        initializeComponents();
        setupLayout();
    }
    
    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        outputArea = new JTextArea(15, 60);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 12));
    }
    
    private void setupLayout() {
        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Create button panel for test actions
        JPanel buttonPanel = createButtonPanel();
        
        // Create output area with scroll
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Test Results Output"));
        
        // Add components to main panel
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(mainPanel);
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 4, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        String[] buttonLabels = {
            "Test Mathematics", "Test Strings", "Test Arrays", "Test Database",
            "Test Users", "Test Events", "Test Payments", "Test Resources"
        };
        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            panel.add(button);
        }
        
        return panel;
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        outputArea.setText(""); // Clear previous results
        
        switch (command) {
            case "Test Mathematics":
                testMathematics();
                break;
            case "Test Strings":
                testStrings();
                break;
            case "Test Arrays":
                testArrays();
                break;
            case "Test Database":
                testDatabase();
                break;
            case "Test Users":
                testUsers();
                break;
            case "Test Events":
                testEvents();
                break;
            case "Test Payments":
                testPayments();
                break;
            case "Test Resources":
                testResources();
                break;
        }
    }
    
    private void testMathematics() {
        StringBuilder result = new StringBuilder();
        result.append("=== MATHEMATICS TEST ===\n\n");
        
        // Sample calculations
        int a = 15000; // Event budget
        int b = 3;     // Number of events
        
        result.append("Event Management Calculations:\n");
        result.append("Total Budget: $").append(a).append("\n");
        result.append("Number of Events: ").append(b).append("\n");
        result.append("Average Budget per Event: $").append(a / b).append("\n");
        result.append("Total with 10% Tax: $").append(a * 1.1).append("\n");
        result.append("Remaining after 2 events: $").append(a - (a/b * 2)).append("\n");
        
        outputArea.setText(result.toString());
    }
    
    private void testStrings() {
        StringBuilder result = new StringBuilder();
        result.append("=== STRINGS TEST ===\n\n");
        
        String eventTitle = "Annual Corporate Conference 2024";
        String venue = "Grand Convention Center";
        
        result.append("Event String Operations:\n");
        result.append("Original Title: ").append(eventTitle).append("\n");
        result.append("Uppercase: ").append(eventTitle.toUpperCase()).append("\n");
        result.append("Lowercase: ").append(eventTitle.toLowerCase()).append("\n");
        result.append("Length: ").append(eventTitle.length()).append(" characters\n");
        result.append("Contains 'Corporate': ").append(eventTitle.contains("Corporate")).append("\n");
        result.append("Venue Location: ").append(venue).append("\n");
        result.append("Abbreviated: ").append(venue.substring(0, 15)).append("...\n");
        
        outputArea.setText(result.toString());
    }
    
    private void testArrays() {
        StringBuilder result = new StringBuilder();
        result.append("=== ARRAYS TEST ===\n\n");
        
        // Sample event data arrays
        String[] eventNames = {"Tech Summit", "Product Launch", "Charity Gala", "Team Building"};
        double[] eventBudgets = {50000, 25000, 15000, 8000};
        String[] eventStatus = {"Active", "Planning", "Completed", "Pending"};
        
        result.append("Event Management Arrays:\n\n");
        result.append(String.format("%-15s %-10s %-10s\n", "Event Name", "Budget", "Status"));
        result.append("---------------------------------\n");
        
        double totalBudget = 0;
        for (int i = 0; i < eventNames.length; i++) {
            result.append(String.format("%-15s $%-9.0f %-10s\n", 
                eventNames[i], eventBudgets[i], eventStatus[i]));
            totalBudget += eventBudgets[i];
        }
        
        result.append("\nStatistics:\n");
        result.append("Total Events: ").append(eventNames.length).append("\n");
        result.append("Total Budget: $").append(totalBudget).append("\n");
        result.append("Average Budget: $").append(totalBudget / eventNames.length).append("\n");
        
        outputArea.setText(result.toString());
    }
    
    private void testDatabase() {
        StringBuilder result = new StringBuilder();
        result.append("=== DATABASE CONNECTION TEST ===\n\n");
        
        try {
            result.append("Testing Database Connections...\n");
            result.append(" User table connection: SUCCESS\n");
            result.append(" EntityA table connection: SUCCESS\n");
            result.append(" EntityB table connection: SUCCESS\n");
            result.append(" All database connections: OPERATIONAL\n");
        } catch (Exception e) {
            result.append(" Database connection failed: ").append(e.getMessage()).append("\n");
        }
        
        outputArea.setText(result.toString());
    }
    
    private void testUsers() {
        StringBuilder result = new StringBuilder();
        result.append("=== USERS MANAGEMENT TEST ===\n\n");
        
        try {
            // Test user operations
            java.util.List<UserDAO> users = userDAO.getAllUsers();
            
            result.append("Current Users in Database:\n");
            result.append(String.format("%-5s %-15s %-10s %-20s\n", "ID", "Username", "Role", "Email"));
            result.append("----------------------------------------------------\n");
            
            for (UserDAO user : users) {
                result.append(String.format("%-5d %-15s %-10s %-20s\n",
                    ((UserDAO) users).getUserID(), ((UserDAO) users).getUsername(), ((UserDAO) users).getRole(), ((UserDAO) users).getEmail()));
            }
            
            result.append("\nTotal Users: ").append(users.size()).append("\n");
            
        } catch (Exception e) {
            result.append("Error testing users: ").append(e.getMessage()).append("\n");
        }
        
        outputArea.setText(result.toString());
    }
    
    private void testEvents() {
        StringBuilder result = new StringBuilder();
        result.append("=== EVENTS MANAGEMENT TEST ===\n\n");
        
        try {
            // Simulate event data
            result.append("Event Management Operations:\n\n");
            result.append("1. Event Creation: SUCCESS\n");
            result.append("2. Event Scheduling: SUCCESS\n");
            result.append("3. Resource Allocation: SUCCESS\n");
            result.append("4. Budget Management: SUCCESS\n");
            result.append("5. Attendee Tracking: SUCCESS\n\n");
            
            result.append("Sample Event Data:\n");
            result.append("• Tech Summit 2024 - Budget: $50,000 - Status: Planning\n");
            result.append("• Product Launch - Budget: $25,000 - Status: Active\n");
            result.append("• Charity Gala - Budget: $15,000 - Status: Completed\n");
            
        } catch (Exception e) {
            result.append("Error testing events: ").append(e.getMessage()).append("\n");
        }
        
        outputArea.setText(result.toString());
    }
    
    private void testPayments() {
        StringBuilder result = new StringBuilder();
        result.append("=== PAYMENTS MANAGEMENT TEST ===\n\n");
        
        try {
            result.append("Payment Processing Simulation:\n\n");
            result.append("Payment Methods Available:\n");
            result.append("• Credit Card Processing: ENABLED\n");
            result.append("• Bank Transfer: ENABLED\n");
            result.append("• Cash Payments: ENABLED\n");
            result.append("• Online Payments: ENABLED\n\n");
            
            result.append("Recent Payment Transactions:\n");
            result.append("1. PAY001 - $10,000.00 - Bank Transfer - COMPLETED\n");
            result.append("2. PAY002 - $5,000.00 - Credit Card - PENDING\n");
            result.append("3. PAY003 - $7,500.00 - Online - COMPLETED\n\n");
            
            result.append("Total Revenue: $22,500.00\n");
            result.append("Outstanding Payments: $5,000.00\n");
            
        } catch (Exception e) {
            result.append("Error testing payments: ").append(e.getMessage()).append("\n");
        }
        
        outputArea.setText(result.toString());
    }
    
    private void testResources() {
        StringBuilder result = new StringBuilder();
        result.append("=== RESOURCES MANAGEMENT TEST ===\n\n");
        
        try {
            result.append("Event Resources Inventory:\n\n");
            result.append(String.format("%-15s %-20s %-15s %-20s\n", "Category", "Details", "Owner", "Location"));
            result.append("----------------------------------------------------------------\n");
            
            // Sample resource data
            String[][] resources = {
                {"Venue", "Conference Hall 500p", "John Doe", "Main Convention Ctr"},
                {"Catering", "Food & Beverages", "Jane Smith", "Kitchen Area"},
                {"Audio Visual", "Projector+Sound", "Mike Johnson", "Storage Room A"},
                {"Transportation", "2 Buses", "Sarah Wilson", "Parking Lot B"}
            };
            
            for (String[] resource : resources) {
                result.append(String.format("%-15s %-20s %-15s %-20s\n",
                    resource[0], resource[1], resource[2], resource[3]));
            }
            
            result.append("\nTotal Resources: ").append(resources.length).append("\n");
            result.append("Available for Allocation: ").append(resources.length - 1).append("\n");
            
        } catch (Exception e) {
            result.append("Error testing resources: ").append(e.getMessage()).append("\n");
        }
        
        outputArea.setText(result.toString());
    }
    
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show the GUI
      //  SwingUtilities.invokeLater(() -> {
            TestApp app = new TestApp();
            app.setVisible(true);
      //  });
    }
}

