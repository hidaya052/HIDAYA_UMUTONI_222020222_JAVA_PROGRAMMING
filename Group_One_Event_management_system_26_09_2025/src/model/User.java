package model;

package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import dao.UserDAO;
import model.User;

public class UserPanel extends JPanel implements ActionListener {
    private JTextField idField, usernameField, emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleCombo;
    private JButton addBtn, updateBtn, deleteBtn, clearBtn;
    private JTable userTable;
    private DefaultTableModel tableModel;
    private UserDAO userDAO;
    
    public UserPanel() {
        userDAO = new UserDAO();
        setLayout(new BorderLayout());
        initializeForm();
        initializeTable();
        loadUserData();
    }
    
    private void initializeForm() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("User Information"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Initialize components
        idField = new JTextField(10);
        idField.setEditable(false);
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        emailField = new JTextField(15);
        roleCombo = new JComboBox<>(new String[]{"Admin", "Manager", "Staff", "Client"});
        
        // Add components to form
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("User ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(idField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Role:"), gbc);
        gbc.gridx = 1;
        formPanel.add(roleCombo, gbc);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addBtn = new JButton("Add User");
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
        String[] columns = {"ID", "Username", "Email", "Role", "Created At"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        userTable = new JTable(tableModel);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                displaySelectedUser();
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Users List"));
        add(scrollPane, BorderLayout.SOUTH);
    }
    
    private void loadUserData() {
        tableModel.setRowCount(0);
        java.util.List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            tableModel.addRow(new Object[]{
                user.getUserID(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
            });
        }
    }
    
    private void displaySelectedUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
            usernameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
            emailField.setText(tableModel.getValueAt(selectedRow, 2).toString());
            roleCombo.setSelectedItem(tableModel.getValueAt(selectedRow, 3).toString());
            passwordField.setText(""); // Don't display password
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addBtn) {
                addUser();
            } else if (e.getSource() == updateBtn) {
                updateUser();
            } else if (e.getSource() == deleteBtn) {
                deleteUser();
            } else if (e.getSource() == clearBtn) {
                clearForm();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addUser() {
        if (usernameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username is required!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        User user = new User();
        user.setUsername(usernameField.getText().trim());
        user.setPasswordHash("hashed_" + new String(passwordField.getPassword()));
        user.setEmail(emailField.getText().trim());
        user.setRole(roleCombo.getSelectedItem().toString());
        
        if (userDAO.createUser(user)) {
            JOptionPane.showMessageDialog(this, "User added successfully!");
            clearForm();
            loadUserData();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add user!");
        }
    }
    
    private void updateUser() {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a user to update!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        UserDAO user = new UserDAO();
        user.setUserID(Integer.parseInt(idField.getText()));
        user.setUsername(usernameField.getText().trim());
        user.setEmail(emailField.getText().trim());
        user.setRole(roleCombo.getSelectedItem().toString());
        
        // Only update password if provided
        if (passwordField.getPassword().length > 0) {
            user.setPasswordHash("hashed_" + new String(passwordField.getPassword()));
        } else {
            // Keep existing password - you might want to handle this differently
            user.setPasswordHash("");
        }
        
        if (userDAO.updateUser(user)) {
            JOptionPane.showMessageDialog(this, "User updated successfully!");
            clearForm();
            loadUserData();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update user!");
        }
    }
    
    private void deleteUser() {
        if (idField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (userDAO.deleteUser(Integer.parseInt(idField.getText()))) {
                JOptionPane.showMessageDialog(this, "User deleted successfully!");
                clearForm();
                loadUserData();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete user!");
            }
        }
    }
    
    private void clearForm() {
        idField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");
        roleCombo.setSelectedIndex(0);
        userTable.clearSelection();
    }
}







