package gui;

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.awt.event.*;
	import dao.EntityEDAO;
	import model.EntityE;

	public class EntityEPanel extends JPanel implements ActionListener {
	    private JTextField idField, categoryField, ownerField, locationField;
	    private JTextArea detailArea;
	    private JButton addBtn, updateBtn, deleteBtn, clearBtn, assignBtn;
	    private JTable table;
	    private DefaultTableModel tableModel;
	    private EntityEDAO entityEDAO;
	    
	    public EntityEPanel() {
	        entityEDAO = new EntityEDAO();
	        setLayout(new BorderLayout());
	        initializeForm();
	        initializeTable();
	        loadData();
	    }
	    
	    private void initializeForm() {
	        JPanel formPanel = new JPanel(new GridBagLayout());
	        formPanel.setBorder(BorderFactory.createTitledBorder("Resource Information"));
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5);
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        idField = new JTextField(10);
	        idField.setEditable(false);
	        categoryField = new JTextField(20);
	        ownerField = new JTextField(15);
	        locationField = new JTextField(20);
	        
	        detailArea = new JTextArea(3, 20);
	        detailArea.setLineWrap(true);
	        JScrollPane detailScroll = new JScrollPane(detailArea);
	        
	        // Form layout
	        gbc.gridx = 0; gbc.gridy = 0;
	        formPanel.add(new JLabel("Resource ID:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(idField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 1;
	        formPanel.add(new JLabel("Category:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(categoryField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 2;
	        formPanel.add(new JLabel("Owner:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(ownerField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 3;
	        formPanel.add(new JLabel("Location:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(locationField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 4;
	        formPanel.add(new JLabel("Details:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(detailScroll, gbc);
	        
	        // Buttons
	        JPanel buttonPanel = new JPanel(new FlowLayout());
	        addBtn = new JButton("Add Resource");
	        updateBtn = new JButton("Update");
	        deleteBtn = new JButton("Delete");
	        clearBtn = new JButton("Clear");
	        assignBtn = new JButton("Assign to Event");
	        
	        addBtn.addActionListener(this);
	        updateBtn.addActionListener(this);
	        deleteBtn.addActionListener(this);
	        clearBtn.addActionListener(this);
	        assignBtn.addActionListener(this);
	        
	        buttonPanel.add(addBtn);
	        buttonPanel.add(updateBtn);
	        buttonPanel.add(deleteBtn);
	        buttonPanel.add(clearBtn);
	        buttonPanel.add(assignBtn);
	        
	        add(formPanel, BorderLayout.NORTH);
	        add(buttonPanel, BorderLayout.CENTER);
	    }
	    
	    private void initializeTable() {
	        String[] columns = {"ID", "Category", "Details", "Owner", "Location"};
	        tableModel = new DefaultTableModel(columns, 0);
	        table = new JTable(tableModel);
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBorder(BorderFactory.createTitledBorder("Available Resources"));
	        add(scrollPane, BorderLayout.SOUTH);
	    }
	    
	    private void loadData() {
	        tableModel.setRowCount(0);
	        tableModel.addRow(new Object[]{"1", "Venue", "Conference hall for 500 people", "John Doe", "Main Convention Center"});
	        tableModel.addRow(new Object[]{"2", "Catering", "Food and beverages service", "Jane Smith", "Event Location"});
	        tableModel.addRow(new Object[]{"3", "Audio Visual", "Projector and sound system", "Mike Johnson", "Storage Room A"});
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == assignBtn) {
	            assignResource();
	        }
	        // Other button implementations
	    }
	    
	    private void assignResource() {
	        JOptionPane.showMessageDialog(this, "Resource assignment functionality would be implemented here");
	    }

}
