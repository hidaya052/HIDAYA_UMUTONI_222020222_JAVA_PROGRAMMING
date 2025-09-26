package gui;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import dao.EntityADAO;
import model.EntityA;

public class EntityAPanel extends JPanel implements ActionListener {
    private JTextField idField, nameField, descField, attr1Field, attr2Field;
    private JButton addBtn, updateBtn, deleteBtn, clearBtn;
    private JTable table;
    private DefaultTableModel tableModel;
    private EntityADAO entityADAO;
    
    public EntityAPanel() {
        entityADAO = new EntityADAO();
        setLayout(new BorderLayout());
        initializeForm();
        initializeTable();
        loadData();
    }
    
    private void initializeForm() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Event Category Details"));
        
        idField = new JTextField();
        idField.setEditable(false);
        nameField = new JTextField();
        descField = new JTextField();
        attr1Field = new JTextField();
        attr2Field = new JTextField();
        
        formPanel.add(new JLabel("Category ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(descField);
        formPanel.add(new JLabel("Attribute 1:"));
        formPanel.add(attr1Field);
        formPanel.add(new JLabel("Attribute 2:"));
        formPanel.add(attr2Field);
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        addBtn = new JButton("Add Category");
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
        String[] columns = {"ID", "Name", "Description", "Attribute 1", "Attribute 2"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event Categories"));
        add(scrollPane, BorderLayout.SOUTH);
    }
    
    private void loadData() {
        tableModel.setRowCount(0);
        // Load data from EntityADAO
    }
    
    public void actionPerformed(ActionEvent e) {
        // Implementation similar to UserPanel
    }


}
