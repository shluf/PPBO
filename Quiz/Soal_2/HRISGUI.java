import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class HRISGUI extends JFrame {
    private JFrame frame;
    private JComboBox<String> departementComboBox;
    private JComboBox<String> positionComboBox;
    private JTextField nameField;
    private JTextField dobField;
    private JButton addEmployeeButton;
    private JButton cancelButton;
    private JTextArea displayArea;
    private JTextField findIdField;
    private JButton addButton;
    private JButton showAllButton;
    private ArrayList<Employee> employees;

    public HRISGUI() {
        employees = new ArrayList<>();
        frame = new JFrame("HRIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(showMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JPanel showMainPanel() {
        addButton = new JButton("Add Data");
        showAllButton = new JButton("Show Data");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showInputPanel());
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showAllDataPanel());
            }
        });

        return buttonPanel;
    }

    private JPanel showAllDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(1, 1));

        findIdField = new JTextField(15);
        topPanel.add(findIdField);

        cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);

        displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        StringBuilder strBuilder = new StringBuilder();
        for (Employee emp : employees) {
            strBuilder.append(emp).append("\n");
        }
        displayArea.setText(strBuilder.toString());

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        return panel;
    }

    private void repaintPanel(JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(newPanel);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel showInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);
        JLabel dobLabel = new JLabel("Date of Birth (DDMMYYYY):");
        dobField = new JTextField(15);
        JLabel departementLabel = new JLabel("Departement:");
        String[] departments = {"Product", "Human Resources"};
        departementComboBox = new JComboBox<>(departments);
        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);

        addEmployeeButton = new JButton("Add Data");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(departementLabel);
        inputPanel.add(departementComboBox);
        inputPanel.add(positionLabel);
        inputPanel.add(positionComboBox);
        inputPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String dob = dobField.getText();
                String department = departementComboBox.getSelectedItem().toString();
                String position = positionComboBox.getSelectedItem().toString();
                String empId = generateEmployeeID(department, dob);
                double salary = getSalary(position);

                Employee employee;
                switch (position) {
                    case "Manager":
                        employee = new Manager(empId, name, dob, department, salary);
                        break;
                    case "Developer":
                        employee = new Developer(empId, name, dob, department, salary);
                        break;
                    default:
                        employee = new HRStaff(empId, name, dob, department, salary);
                        break;
                }

                employees.add(employee);
                JOptionPane.showMessageDialog(HRISGUI.this, "Employee added: " + employee);
            }
        });

        return inputPanel;
    }

    private String generateEmployeeID(String department, String dob) {
        String departmentCode = department.equals("Product") ? "PROD" : "HR";
        int randomNum = new Random().nextInt(1000);
        return "000" + departmentCode + dob + String.format("%03d", randomNum);
    }

    private double getSalary(String position) {
        switch (position) {
            case "Manager":
                return 20000000;
            case "Developer":
                return 10000000;
            default:
                return 5000000;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}


