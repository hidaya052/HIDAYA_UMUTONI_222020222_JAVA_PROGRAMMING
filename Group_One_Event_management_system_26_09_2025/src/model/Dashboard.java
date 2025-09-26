package model;
import gui.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Dashboard extends JPanel {
    private User currentUser;
    
    public Dashboard(User user) {
        this.currentUser = user;
        createDashboard();
    }
    
    private void createDashboard() {
        setLayout(new BorderLayout());
        
        // Welcome panel
        JPanel welcomePanel = createWelcomePanel();
        
        // Stats panel
        JPanel statsPanel = createStatsPanel();
        
        // Recent activity panel
        JPanel activityPanel = createActivityPanel();
        
        // Add components
        add(welcomePanel, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.CENTER);
        add(activityPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));
        
        String welcomeText = "<html><h1>Welcome back, " + User.getUsername() + "!</h1>" +
                           "<p>Role: <b>" + User.getRole() + "</b> | " +
                           "Email: " + User.getEmail() + "</p></html>";
        
        JLabel welcomeLabel = new JLabel(welcomeText);
        panel.add(welcomeLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createStatsPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Create statistic cards based on user role
        if (currentUser.getRole().equalsIgnoreCase("admin") || 
            currentUser.getRole().equalsIgnoreCase("manager")) {
            // Full statistics for admin/manager
            panel.add(createStatCard("Total Events", "15", Color.BLUE, "events"));
            panel.add(createStatCard("Active Events", "8", Color.GREEN, "active"));
            panel.add(createStatCard("Total Revenue", "$125K", Color.CYAN, "revenue"));
            panel.add(createStatCard("Pending Payments", "3", Color.ORANGE, "payments"));
            panel.add(createStatCard("System Users", "24", Color.MAGENTA, "users"));
            panel.add(createStatCard("Resources", "12", Color.RED, "resources"));
        } else {
            // Limited statistics for staff/client
            panel.add(createStatCard("My Events", "5", Color.BLUE, "events"));
            panel.add(createStatCard("Upcoming", "2", Color.GREEN, "upcoming"));
            panel.add(createStatCard("Completed", "3", Color.CYAN, "completed"));
            panel.add(createStatCard("Tasks", "7", Color.ORANGE, "tasks"));
            panel.add(createStatCard("Messages", "3", Color.MAGENTA, "messages"));
            panel.add(createStatCard("Notifications", "5", Color.RED, "notifications"));
        }
        
        return panel;
    }
    
    private JPanel createStatCard(String title, String value, Color color, String icon) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        card.setBackground(Color.WHITE);
        
        JLabel titleLabel = new JLabel(getIconForType(icon) + " " + title, JLabel.CENTER);
        JLabel valueLabel = new JLabel(value, JLabel.CENTER);
        
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valueLabel.setForeground(color);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        
        return card;
    }
    
    private String getIconForType(String type) {
        switch (type) {
            case "events": return "📅";
            case "active": return "🟢";
            case "revenue": return "💰";
            case "payments": return "💳";
            case "users": return "👥";
            case "resources": return "🛠️";
            case "upcoming": return "⏳";
            case "completed": return "✅";
            case "tasks": return "📝";
            case "messages": return "✉️";
            case "notifications": return "🔔";
            default: return "📊";
        }
    }
    
    private JPanel createActivityPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Recent Activity"));
        
        String activityText = getActivityBasedOnRole();
        JTextArea activityArea = new JTextArea(activityText, 5, 50);
        activityArea.setEditable(false);
        activityArea.setFont(new Font("Arial", Font.PLAIN, 12));
        
        panel.add(new JScrollPane(activityArea), BorderLayout.CENTER);
        return panel;
    }
    
    private String getActivityBasedOnRole() {
        String role = currentUser.getRole().toLowerCase();
        
        switch (role) {
            case "admin":
                return "• System maintenance completed\n" +
                       "• New user 'john_doe' registered\n" +
                       "• Financial report generated\n" +
                       "• Database backup successful";
                       
            case "manager":
                return "• Event 'Tech Summit' approved\n" +
                       "• Payment received for Product Launch\n" +
                       "• Resource allocation updated\n" +
                       "• Team meeting scheduled";
                       
            case "staff":
                return "• Event setup completed\n" +
                       "• Vendor coordination in progress\n" +
                       "• Client meeting notes updated\n" +
                       "• Equipment checklist verified";
                       
            case "client":
                return "• Your event registration confirmed\n" +
                       "• Payment status: Completed\n" +
                       "• Next event: Team Building Workshop\n" +
                       "• Support ticket #1234 resolved";
                       
            default:
                return "No recent activity";
        }
    }
}








