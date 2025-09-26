package main;

import gui.EntityAPanel;
import gui.EntityBPanel;
import gui.EntityCPanel;
import gui.EntityDPanel;
import gui.EntityEPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    
    public MainFrame() {
        setTitle("Event Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        
        createMenuBar();
        
        tabbedPane = new JTabbedPane();
        
        // Add tabs - Dashboard first
        tabbedPane.addTab("Dashboard", new DashboardPanel());
        tabbedPane.addTab("Users", new UserPanel());
        tabbedPane.addTab("Event Categories", new EntityAPanel());
        tabbedPane.addTab("Events", new EntityBPanel());
        tabbedPane.addTab("Event Details", new EntityCPanel());
        tabbedPane.addTab("Payments", new EntityDPanel());
        tabbedPane.addTab("Resources", new EntityEPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
        
        // Status bar
        JLabel statusBar = new JLabel(" Ready - Event Management System v1.0");
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        add(statusBar, BorderLayout.SOUTH);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        // Reports Menu
        JMenu reportsMenu = new JMenu("Reports");
        JMenuItem summaryItem = new JMenuItem("Event Summary");
        JMenuItem financialItem = new JMenuItem("Financial Report");
        reportsMenu.add(summaryItem);
        reportsMenu.add(financialItem);
        
        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAbout());
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(reportsMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
    }
    
    private void showAbout() {
        JOptionPane.showMessageDialog(this, 
            "Event Management System\nVersion 1.0\n\n" +
            "A comprehensive event management solution\n" +
            "with user management, event planning, and\n" +
            "resource allocation capabilities.",
            "About", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}






	import model.*;
import dao.*;
import java.util.List;
import java.util.Scanner;
package gui;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    private JTabbedPane tabbedPane;
    
    public MainApp() {
        setTitle("Event Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        
        createMenuBar();
        
        tabbedPane = new JTabbedPane();
        
        // Add tabs - Dashboard first
        tabbedPane.addTab("Dashboard", new Dashboard());
        tabbedPane.addTab("Users", new UserPanel());
        tabbedPane.addTab("Event Categories", new EntityAPanel());
        tabbedPane.addTab("Events", new EntityBPanel());
        tabbedPane.addTab("Event Details", new EntityCPanel());
        tabbedPane.addTab("Payments", new EntityDPanel());
        tabbedPane.addTab("Resources", new EntityEPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
        
        // Status bar
        JLabel statusBar = new JLabel(" Ready - Event Management System v1.0");
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        add(statusBar, BorderLayout.SOUTH);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        // Reports Menu
        JMenu reportsMenu = new JMenu("Reports");
        JMenuItem summaryItem = new JMenuItem("Event Summary");
        JMenuItem financialItem = new JMenuItem("Financial Report");
        reportsMenu.add(summaryItem);
        reportsMenu.add(financialItem);
        
        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAbout());
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(reportsMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
    }
    
    private void showAbout() {
        JOptionPane.showMessageDialog(this, 
            "Event Management System\nVersion 1.0\n\n" +
            "A comprehensive event management solution\n" +
            "with user management, event planning, and\n" +
            "resource allocation capabilities.",
            "About", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
	