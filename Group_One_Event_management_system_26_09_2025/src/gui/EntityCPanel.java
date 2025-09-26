package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import dao.EntityCDAO;
import model.EntityC;

public class EntityCPanel extends JPanel implements ActionListener {
    private JTextField idField, nameField;
    private JComboBox<String> typeCombo, statusCombo;
    private JSpinner startDateSpinner, endDateSpinner;
    private JTextArea detailsArea;
    private JButton addBtn, updateBtn, deleteBtn, clearBtn;
    private JTable table;
    private DefaultTableModel tableModel;
    private EntityCDAO entityCDAO;
    
    public EntityCPanel() {
        entityCDAO = new EntityCDAO();
        setLayout(new BorderLayout());
        initializeForm();
        initializeTable();
        loadData();
    }
    
    private void initializeForm() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Event Schedule Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        idField = new JTextField(10);
        idField.setEditable(false);
        nameField = new JTextField(20);
        
        typeCombo = new JComboBox<>(new String[]{"Conference", "Workshop", "Seminar", "Social", "Meeting"});
        statusCombo = new JComboBox<>(new String[]{"Planning", "Active", "Completed", "Cancelled"});
        
        startDateSpinner = new JSpinner(new SpinnerDateModel());
        endDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor startEditor = new JSpinner.DateEditor(startDateSpinner, "yyyy-MM-dd HH:mm");
        JSpinner.DateEditor endEditor = new JSpinner.DateEditor(endDateSpinner, "yyyy-MM-dd HH:mm");
        startDateSpinner.setEditor(startEditor);
        endDateSpinner.setEditor(endEditor);
        
        detailsArea = new JTextArea(3, 20);
        detailsArea.setLineWrap(true);
        JScrollPane detailsScroll = new JScrollPane(detailsArea);
        
        // Form layout
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Detail ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(idField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Event Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Event Type:"), gbc);
        gbc.gridx = 1;
        formPanel.add(typeCombo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Start Date:"), gbc);
        gbc.gridx = 1;
        formPanel.add(startDateSpinner, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("End Date:"), gbc);
        gbc.gridx = 1;
        formPanel.add(endDateSpinner, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        formPanel.add(statusCombo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 6;
        formPanel.add(new JLabel("Details:"), gbc);
        gbc.gridx = 1;
        formPanel.add(detailsScroll, gbc);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addBtn = new JButton("Add Schedule");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        
        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        
        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);
        
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
    
    private void initializeTable() {
        String[] columns = {"ID", "Event Name", "Type", "Start Date", "End Date", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event Schedules"));
        add(scrollPane, BorderLayout.SOUTH);
    }
    
    private void loadData() {
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"1", "Tech Summit 2024", "Conference", "2024-12-10 09:00", "2024-12-12 17:00", "Planning"});
        tableModel.addRow(new Object[]{"2", "Marketing Workshop", "Workshop", "2024-11-15 10:00", "2024-11-15 16:00", "Active"});
    }
    
    public void actionPerformed(ActionEvent e) {
        // Implementation similar to other panels
    }
    
    private void clearForm() {
        idField.setText("");
        nameField.setText("");
        typeCombo.setSelectedIndex(0);
        statusCombo.setSelectedIndex(0);
        table.clearSelection();
    }

}
