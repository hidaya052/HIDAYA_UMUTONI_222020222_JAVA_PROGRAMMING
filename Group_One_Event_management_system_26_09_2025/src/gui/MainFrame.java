package gui;

	import javax.swing.*;

import model.EntityA;
import model.EntityB;
import model.EntityC;
import model.EntityD;
import model.EntityE;
import model.User;

import java.awt.*;

	public class MainFrame extends JFrame {
	    private JTabbedPane tabbedPane;
	    
	    public MainFrame() {
	        setTitle("Event Management System");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(1200, 700);
	        setLocationRelativeTo(null);
	        
	        // Create menu bar
	        createMenuBar();
	        
	        // Create tabbed pane
	        tabbedPane = new JTabbedPane();
	        
	        // Add tabs for each entity
	        tabbedPane.addTab("Users", new User());
	        tabbedPane.addTab("Event Categories", new EntityA());
	        tabbedPane.addTab("Events", new EntityB());
	        tabbedPane.addTab("Event Details", new EntityC());
	        tabbedPane.addTab("Payments", new EntityD());
	        tabbedPane.addTab("Resources", new EntityE());
	        
	        add(tabbedPane, BorderLayout.CENTER);
	        
	        // Status bar
	        add(new JLabel(" Event Management System - Ready", JLabel.LEFT), BorderLayout.SOUTH);
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
	        summaryItem.addActionListener(e -> showSummaryReport());
	        reportsMenu.add(summaryItem);
	        
	        menuBar.add(fileMenu);
	        menuBar.add(reportsMenu);
	        
	        setJMenuBar(menuBar);
	    }
	    
	    private void showSummaryReport() {
	        JOptionPane.showMessageDialog(this, 
	            "Event Summary Report:\n\n" +
	            "Total Events: 15\n" +
	            "Active Events: 8\n" +
	            "Revenue: $125,000", 
	            "Summary Report", 
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


