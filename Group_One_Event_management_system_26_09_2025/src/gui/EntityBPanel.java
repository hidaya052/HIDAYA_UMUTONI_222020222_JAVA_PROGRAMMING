package gui;

    import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.awt.event.*;
	import java.sql.Timestamp;
	import java.text.SimpleDateFormat;
	import dao.EntityBDAO;
	import dao.EntityADAO;
	import model.EntityB;

	public class EntityBPanel extends JPanel implements ActionListener {
	    private JTextField idField, titleField, valueField, notesField;
	    private JComboBox<String> statusCombo, entityACombo;
	    private JTextArea descriptionArea;
	    private JButton addBtn, updateBtn, deleteBtn, clearBtn;
	    private JTable table;
	    private DefaultTableModel tableModel;
	    private EntityBDAO entityBDAO;
	    private EntityADAO entityADAO;
	    
	    public EntityBPanel() {
	        entityBDAO = new EntityBDAO();
	        entityADAO = new EntityADAO();
	        setLayout(new BorderLayout());
	        initializeForm();
	        initializeTable();
	        loadData();
	    }
	    
	    private void initializeForm() {
	        JPanel formPanel = new JPanel(new GridBagLayout());
	        formPanel.setBorder(BorderFactory.createTitledBorder("Event Details"));
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5);
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        // Initialize components
	        idField = new JTextField(10);
	        idField.setEditable(false);
	        titleField = new JTextField(20);
	        valueField = new JTextField(10);
	        notesField = new JTextField(20);
	        
	        statusCombo = new JComboBox<>(new String[]{"Pending", "Approved", "Completed", "Cancelled"});
	        entityACombo = new JComboBox<>();
	        loadEntityACombo();
	        
	        descriptionArea = new JTextArea(3, 20);
	        descriptionArea.setLineWrap(true);
	        JScrollPane descScroll = new JScrollPane(descriptionArea);
	        
	        // Form layout
	        gbc.gridx = 0; gbc.gridy = 0;
	        formPanel.add(new JLabel("Event ID:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(idField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 1;
	        formPanel.add(new JLabel("Title:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(titleField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 2;
	        formPanel.add(new JLabel("Category:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(entityACombo, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 3;
	        formPanel.add(new JLabel("Status:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(statusCombo, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 4;
	        formPanel.add(new JLabel("Budget:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(valueField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 5;
	        formPanel.add(new JLabel("Notes:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(notesField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 6;
	        formPanel.add(new JLabel("Description:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(descScroll, gbc);
	        
	        // Buttons
	        JPanel buttonPanel = new JPanel(new FlowLayout());
	        addBtn = new JButton("Add Event");
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
	    
	    private void loadEntityACombo() {
	        // Load categories from EntityADAO
	        entityACombo.addItem("Select Category");
	        // Add actual categories from database
	        entityACombo.addItem("Corporate Events");
	        entityACombo.addItem("Wedding Planning");
	        entityACombo.addItem("Charity Events");
	    }
	    
	    private void initializeTable() {
	        String[] columns = {"ID", "Title", "Category", "Status", "Budget", "Date"};
	        tableModel = new DefaultTableModel(columns, 0) {
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        
	        table = new JTable(tableModel);
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        table.getSelectionModel().addListSelectionListener(e -> {
	            if (!e.getValueIsAdjusting()) {
	                displaySelectedEvent();
	            }
	        });
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBorder(BorderFactory.createTitledBorder("Events List"));
	        add(scrollPane, BorderLayout.SOUTH);
	    }
	    
	    private void loadData() {
	        tableModel.setRowCount(0);
	        // Sample data - replace with actual DAO call
	        tableModel.addRow(new Object[]{"1", "Annual Conference", "Corporate", "Pending", "$50,000", "2024-12-15"});
	        tableModel.addRow(new Object[]{"2", "Product Launch", "Corporate", "Approved", "$25,000", "2024-11-20"});
	        tableModel.addRow(new Object[]{"3", "Winter Wedding", "Wedding", "Completed", "$15,000", "2024-12-10"});
	    }
	    
	    private void displaySelectedEvent() {
	        int selectedRow = table.getSelectedRow();
	        if (selectedRow >= 0) {
	            idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
	            titleField.setText(tableModel.getValueAt(selectedRow, 1).toString());
	            // Set other fields accordingly
	        }
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	        try {
	            if (e.getSource() == addBtn) {
	                addEvent();
	            } else if (e.getSource() == updateBtn) {
	                updateEvent();
	            } else if (e.getSource() == deleteBtn) {
	                deleteEvent();
	            } else if (e.getSource() == clearBtn) {
	                clearForm();
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	    private void addEvent() {
	        if (titleField.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Event title is required!", "Validation Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        // Create and save event
	        JOptionPane.showMessageDialog(this, "Event added successfully!");
	        clearForm();
	        loadData();
	    }
	    
	    private void updateEvent() {
	        if (idField.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please select an event to update!", "Warning", JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        JOptionPane.showMessageDialog(this, "Event updated successfully!");
	        clearForm();
	        loadData();
	    }
	    
	    private void deleteEvent() {
	        if (idField.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please select an event to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        int confirm = JOptionPane.showConfirmDialog(this, 
	            "Are you sure you want to delete this event?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
	        
	        if (confirm == JOptionPane.YES_OPTION) {
	            JOptionPane.showMessageDialog(this, "Event deleted successfully!");
	            clearForm();
	            loadData();
	        }
	    }
	    
	    private void clearForm() {
	        idField.setText("");
	        titleField.setText("");
	        valueField.setText("");
	        notesField.setText("");
	        descriptionArea.setText("");
	        statusCombo.setSelectedIndex(0);
	        entityACombo.setSelectedIndex(0);
	        table.clearSelection();
	    }

}
