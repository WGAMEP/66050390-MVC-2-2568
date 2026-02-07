package View;

import Controller.ShelterController;
import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CitizenView extends JFrame {

    // ตารางแสดงข้อมูลประชาชน
    private DefaultTableModel model;

    public CitizenView(ShelterController controller){

        setTitle("Citizen Registration");
        setSize(900,500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); 

        //ลงทะเบียน
        JPanel form=new JPanel();

        JTextField tfId=new JTextField(6);
        JTextField tfName=new JTextField(8);
        JTextField tfAge=new JTextField(4);

        JCheckBox cbHealth=new JCheckBox("Health Risk"); // ความเสี่ยงสุขภาพ
        JComboBox<CitizenType> cbType=new JComboBox<>(CitizenType.values());
        JButton btnAdd=new JButton("Register");

        form.add(new JLabel("ID")); form.add(tfId);
        form.add(new JLabel("Name")); form.add(tfName);
        form.add(new JLabel("Age")); form.add(tfAge);
        form.add(cbHealth);
        form.add(cbType);
        form.add(btnAdd);

        add(form,BorderLayout.NORTH);

        //ตารางแสดงประชาชน
        model=new DefaultTableModel(new Object[]{
                "ID","Name","Age","Health","Type","Assigned","Shelter"},0);

        JTable table=new JTable(model);
        add(new JScrollPane(table),BorderLayout.CENTER);

        JPanel bottom=new JPanel();

        JComboBox<FilterType> filter=new JComboBox<>(FilterType.values());
        JButton refresh=new JButton("Refresh");

        bottom.add(new JLabel("Filter"));
        bottom.add(filter);
        bottom.add(refresh);

        add(bottom,BorderLayout.SOUTH);

        // Register 
        btnAdd.addActionListener(e->{

            try{
                // สร้าง Citizen จาก input
                Citizen c=new Citizen(
                        tfId.getText(),
                        tfName.getText(),
                        Integer.parseInt(tfAge.getText()),
                        cbHealth.isSelected(),
                        (CitizenType)cbType.getSelectedItem()
                );

                // ส่งไป Controller ลงทะเบียน
                if(!controller.registerCitizen(c)){
                    JOptionPane.showMessageDialog(this,"Duplicate ID");
                }else{
                    JOptionPane.showMessageDialog(this,"Registration Success");

                    tfId.setText("");
                    tfName.setText("");
                    tfAge.setText("");
                    cbHealth.setSelected(false);
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid Input");
            }

            // โหลดข้อมูลใหม่หลังเพิ่ม
            refresh(controller,filter);
        });

        // ปุ่ม Refresh
        refresh.addActionListener(e->refresh(controller,filter));

        // เปลี่ยน filter
        filter.addActionListener(e->refresh(controller,filter));

        refresh(controller,filter);

        setVisible(true);
    }

    // โหลดข้อมูลประชาชนลงตารางตาม filter
    private void refresh(ShelterController c,JComboBox<FilterType> f){

        model.setRowCount(0);

        List<Citizen> list=
                c.filterCitizens((FilterType)f.getSelectedItem());

        for(Citizen x:list){
            model.addRow(new Object[]{
                    x.getId(),
                    x.getName(),
                    x.getAge(),
                    x.hasHealthRisk(),
                    x.getType(),
                    x.isAssigned(),
                    x.getAssignedShelterId()
            });
        }
    }
}
