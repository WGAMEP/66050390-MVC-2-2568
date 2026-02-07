package View;

import Controller.ShelterController;
import Model.Shelter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShelterView extends JFrame {
    //หน้าจัดสรรที่พัก
    private final ShelterController controller;
    private final DefaultTableModel tableModel;

    public ShelterView(ShelterController controller) {
        this.controller = controller;

        setTitle("Shelter Details & Assignment");
        setSize(700,450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID","Name","Capacity","Current","RiskLevel"}, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAssign = new JButton("Assign All");
        JButton btnRefresh = new JButton("Refresh");
        bottom.add(btnAssign); bottom.add(btnRefresh);
        add(bottom, BorderLayout.SOUTH);

        btnAssign.addActionListener(e -> { //AssignAll จัดประชาชน
            String result = controller.assignAll();
            JOptionPane.showMessageDialog(this, result, "Assign Result", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        });

        btnRefresh.addActionListener(e -> refreshTable());

        refreshTable();
        setVisible(true);
    }
    //โหลดข้อมูลใหม่
    private void refreshTable() {
        tableModel.setRowCount(0);
        List<Shelter> list = controller.getService().getShelters();
        for (Shelter s : list) {
            tableModel.addRow(new Object[]{
                    s.getId(), s.getName(), s.getCapacity(), s.getCurrentOccupancy(), s.getRiskLevel()
            });
        }
    }
}
