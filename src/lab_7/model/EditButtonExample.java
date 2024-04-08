/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_7.model;

/**
 *
 * @author Admin
 * 
*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EditButtonExample extends JFrame {
    private JTable table;
    private JButton editButton;

    public EditButtonExample() {
        setTitle("Edit Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Dữ liệu mẫu cho bảng
        String[] columns = {"ID", "Name"};
        Object[][] data = {
            {1, "John"},
            {2, "Doe"},
            {3, "Jane"}
        };

        table = new JTable(data, columns);

        // Tạo nút sửa
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Lấy thông tin từ hàng được chọn và cho phép người dùng sửa
                    Object id = table.getValueAt(selectedRow, 0);
                    Object name = table.getValueAt(selectedRow, 1);
                    String newName = JOptionPane.showInputDialog(null, "Enter new name:", name);
                    if (newName != null) {
                        table.setValueAt(newName, selectedRow, 1);
                        JOptionPane.showMessageDialog(null, "Edit successful");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Thêm bảng và nút sửa vào frame
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(editButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EditButtonExample example = new EditButtonExample();
                example.setVisible(true);
            }
        });
    }
}
