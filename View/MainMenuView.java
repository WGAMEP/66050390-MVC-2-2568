package View;

import Controller.ShelterController;

import javax.swing.*;

public class MainMenuView extends JFrame {

    public MainMenuView(ShelterController controller) {
        setTitle("Shelter Management - Main Menu");
        setSize(360,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnCitizen = new JButton("Citizen (Register / View)");
        JButton btnShelter = new JButton("Shelter (Details / Assign)");
        JButton btnReport = new JButton("Report (Assigned / Waiting)");

        btnCitizen.setBounds(40,20,260,35);
        btnShelter.setBounds(40,60,260,35);
        btnReport.setBounds(40,100,260,35);

        add(btnCitizen);
        add(btnShelter);
        add(btnReport);

        btnCitizen.addActionListener(e -> new CitizenView(controller));
        btnShelter.addActionListener(e -> new ShelterView(controller));
        btnReport.addActionListener(e -> new ReportView(controller));

        setVisible(true);
    }
}
