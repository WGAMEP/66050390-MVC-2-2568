package Model;

import java.time.LocalDate;

public class Citizen {
    private String id;
    private String name;
    private int age;
    private boolean healthRisk; 
    private LocalDate registerDate;
    private CitizenType type;
    private boolean assigned = false;
    private String assignedShelterId = null;

    public Citizen(String id, String name, int age, boolean healthRisk, CitizenType type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.healthRisk = healthRisk;
        this.type = type;
        this.registerDate = LocalDate.now();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean hasHealthRisk() { return healthRisk; }
    public LocalDate getRegisterDate() { return registerDate; }
    public CitizenType getType() { return type; }
    public boolean isAssigned() { return assigned; }
    public String getAssignedShelterId() { return assignedShelterId; }

    public void assignTo(String shelterId) {
        this.assigned = true;
        this.assignedShelterId = shelterId;
    }

    public boolean isPriorityAge() {
        return age < 12 || age > 60;
    }
    // ตรวจสอบว่าเป็นเด็กหรือไม่
    public boolean isChild() {
        return age < 12;
    }
    // ตรวจสอบว่าเป็นผู้สูงอายุหรือไม่
    public boolean isElderly() {
        return age > 60;
    }

}
