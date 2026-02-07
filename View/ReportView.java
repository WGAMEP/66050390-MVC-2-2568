package View;

import Controller.ShelterController;
import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ReportView extends JFrame {
    //หน้ารายงานผล
    DefaultTableModel model;
    

    public ReportView(ShelterController controller){

        setTitle("Report");
        setSize(900,400);
        setLocationRelativeTo(null); 

        model=new DefaultTableModel(new Object[]{
                "ID","Name","Age","Type","Health","Assigned","Shelter"},0);

        JTable table=new JTable(model);

        JComboBox<FilterType> filter=new JComboBox<>(FilterType.values());
        JButton refresh=new JButton("Refresh");

        JPanel top=new JPanel();
        top.add(new JLabel("Filter"));
        top.add(filter);
        top.add(refresh);

        add(top,BorderLayout.NORTH);
        add(new JScrollPane(table));

        refresh.addActionListener(e->load(controller,filter));
        filter.addActionListener(e->load(controller,filter));

        load(controller,filter);

        setVisible(true);
    }
    //โหลดข้อมูลรายงาน
    private void load(ShelterController c,JComboBox<FilterType> f){

        model.setRowCount(0);

        List<Citizen> list=c.filterCitizens((FilterType)f.getSelectedItem());

        for(Citizen x:list){
            model.addRow(new Object[]{
                    x.getId(),
                    x.getName(),
                    x.getAge(),
                    x.getType(),
                    x.hasHealthRisk(),
                    x.isAssigned(),
                    x.getAssignedShelterId()
            });
        }
    }
}
