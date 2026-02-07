import Controller.ShelterController;
import Model.*;
import View.MainMenuView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShelterController controller = new ShelterController();
            controller.getService().addShelter(new Shelter("S01", "City Hall", 5, RiskLevel.LOW));
            controller.getService().addShelter(new Shelter("S02", "School Gym", 8, RiskLevel.MEDIUM));
            controller.getService().addShelter(new Shelter("S03", "Temple", 6, RiskLevel.LOW));
            controller.getService().addShelter(new Shelter("S04", "Community Center", 5, RiskLevel.HIGH));
            controller.getService().addShelter(new Shelter("S05", "Stadium", 4, RiskLevel.MEDIUM));
            controller.getService().registerCitizen(new Citizen("C01","Alice",10,false,CitizenType.NORMAL)); // child - priority
            controller.getService().registerCitizen(new Citizen("C02","Bob",65,false,CitizenType.NORMAL));  // elderly - priority
            controller.getService().registerCitizen(new Citizen("C03","Carol",30,true,CitizenType.RISK_GROUP)); // health risk -> LOW only
            controller.getService().registerCitizen(new Citizen("C04","Dave",45,false,CitizenType.VIP));
            controller.getService().registerCitizen(new Citizen("C05","Eve",8,true,CitizenType.RISK_GROUP)); // child & risk
            controller.getService().registerCitizen(new Citizen("C06","Frank",72,false,CitizenType.NORMAL)); // elderly
            controller.getService().registerCitizen(new Citizen("C07","Grace",33,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C08","Hank",28,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C09","Ivy",54,true,CitizenType.RISK_GROUP));
            controller.getService().registerCitizen(new Citizen("C10","John",5,false,CitizenType.NORMAL)); // child
            controller.getService().registerCitizen(new Citizen("C11","Kara",15,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C12","Leo",61,false,CitizenType.NORMAL)); // elderly
            controller.getService().registerCitizen(new Citizen("C13","Mona",40,true,CitizenType.RISK_GROUP));
            controller.getService().registerCitizen(new Citizen("C14","Nate",22,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C15","Olga",70,true,CitizenType.RISK_GROUP)); // elderly & risk
            controller.getService().registerCitizen(new Citizen("C16","Paul",27,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C17","Quin",9,false,CitizenType.NORMAL)); // child
            controller.getService().registerCitizen(new Citizen("C18","Rita",34,false,CitizenType.VIP));
            controller.getService().registerCitizen(new Citizen("C19","Sam",58,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C20","Tina",45,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C21","Uma",50,true,CitizenType.RISK_GROUP));
            controller.getService().registerCitizen(new Citizen("C22","Vik",12,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C23","Walt",14,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C24","Xena",66,true,CitizenType.RISK_GROUP));
            controller.getService().registerCitizen(new Citizen("C25","Yara",7,false,CitizenType.NORMAL)); // child
            controller.getService().registerCitizen(new Citizen("C26","Zed",38,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C27","Ana",29,false,CitizenType.NORMAL));
            controller.getService().registerCitizen(new Citizen("C28","Ben",83,true,CitizenType.RISK_GROUP)); // elderly & risk
            controller.getService().registerCitizen(new Citizen("C29","Cleo",31,false,CitizenType.VIP));
            controller.getService().registerCitizen(new Citizen("C30","Don",44,false,CitizenType.NORMAL));

            new MainMenuView(controller);
        });
    }
}
