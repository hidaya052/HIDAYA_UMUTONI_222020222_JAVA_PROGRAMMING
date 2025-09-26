package gui;

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.awt.event.*;
	import java.text.SimpleDateFormat;
	import dao.EntityDDAO;
	import model.EntityD;

	public class EntityDPanel extends JPanel implements ActionListener {
	    private JTextField idField, refField, amountField;
	    private JComboBox<String> methodCombo, statusCombo;
	    private JSpinner dateSpinner;
	    private JButton addBtn, updateBtn, deleteBtn, clearBtn, printBtn;
	    private JTable table;
	    private DefaultTableModel tableModel;
	    private EntityDDAO entityDDAO;
	    
	    public EntityDPanel() {
	        entityDDAO = new EntityDDAO();
	        setLayout(new BorderLayout());
	        initializeForm();
	        initializeTable();
	        loadData();
	    }
	    
	    private void initializeForm() {
	        JPanel formPanel = new JPanel(new GridBagLayout());
	        formPanel.setBorder(BorderFactory.createTitledBorder("Payment Information"));
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5);
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        idField = new JTextField(10);
	        idField.setEditable(false);
	        refField = new JTextField(15);
	        amountField = new JTextField(10);
	        
	        methodCombo = new JComboBox<>(new String[]{"Cash", "Credit Card", "Bank Transfer", "Online", "Check"});
	        statusCombo = new JComboBox<>(new String[]{"Pending", "Completed", "Failed", "Refunded"});
	        
	        dateSpinner = new JSpinner(new SpinnerDateModel());
	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd HH:mm");
	        dateSpinner.setEditor(dateEditor);
	        
	        // Form layout
	        gbc.gridx = 0; gbc.gridy = 0;
	        formPanel.add(new JLabel("Payment ID:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(idField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 1;
	        formPanel.add(new JLabel("Reference No:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(refField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 2;
	        formPanel.add(new JLabel("Amount:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(amountField, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 3;
	        formPanel.add(new JLabel("Method:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(methodCombo, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 4;
	        formPanel.add(new JLabel("Status:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(statusCombo, gbc);
	        
	        gbc.gridx = 0; gbc.gridy = 5;
	        formPanel.add(new JLabel("Date:"), gbc);
	        gbc.gridx = 1;
	        formPanel.add(dateSpinner, gbc);
	        
	        // Buttons
	        JPanel buttonPanel = new JPanel(new FlowLayout());
	        addBtn = new JButton("Add Payment");
	        updateBtn = new JButton("Update");
	        deleteBtn = new JButton("Delete");
	        clearBtn = new JButton("Clear");
	        printBtn = new JButton("Print Receipt");
	        
	        addBtn.addActionListener(this);
	        updateBtn.addActionListener(this);
	        deleteBtn.addActionListener(this);
	        clearBtn.addActionListener(this);
	        printBtn.addActionListener(this);
	        
	        buttonPanel.add(addBtn);
	        buttonPanel.add(updateBtn);
	        buttonPanel.add(deleteBtn);
	        buttonPanel.add(clearBtn);
	        buttonPanel.add(printBtn);
	        
	        add(formPanel, BorderLayout.NORTH);
	        add(buttonPanel, BorderLayout.CENTER);
	    }
	    
	    private void initializeTable() {
	        String[] columns = {"ID", "Reference", "Amount", "Method", "Status", "Date"};
	        tableModel = new DefaultTableModel(columns, 0);
	        table = new JTable(tableModel);
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBorder(BorderFactory.createTitledBorder("Payment Records"));
	        add(scrollPane, BorderLayout.SOUTH);
	    }
	    
	    private void loadData() {
	        tableModel.setRowCount(0);
	        tableModel.addRow(new Object[]{"1", "PAY001", "$10,000.00", "Bank Transfer", "Completed", "2024-10-01"});
	        tableModel.addRow(new Object[]{"2", "PAY002", "$5,000.00", "Credit Card", "Pending", "2024-10-02"});
	        tableModel.addRow(new Object[]{"3", "PAY003", "$7,500.00", "Online", "Completed", "2024-10-03"});
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == printBtn) {
	            printReceipt();
	        }
	        // Other button implementations
	    }
	    
	    private void printReceipt() {
	        JOptionPane.showMessageDialog(this, 
	            "Payment Receipt\n\n" +
	            "Reference: " + refField.getText() + "\n" +
	            "Amount: " + amountField.getText() + "\n" +
	            "Method: " + methodCombo.getSelectedItem() + "\n" +
	            "Thank you for your payment!", 
	            "Payment Receipt", 
	            JOptionPane.INFORMATION_MESSAGE);
	    }

}
