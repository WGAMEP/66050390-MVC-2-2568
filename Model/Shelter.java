package Model;

public class Shelter {
    private String id;
    private String name;
    private int capacity;
    private RiskLevel riskLevel;
    private int currentOccupancy = 0;

    public Shelter(String id, String name, int capacity, RiskLevel riskLevel) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.riskLevel = riskLevel;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public RiskLevel getRiskLevel() { return riskLevel; }
    public int getCurrentOccupancy() { return currentOccupancy; }

    public boolean isFull() { return currentOccupancy >= capacity; } // ตรวจว่าศูนย์พักพิงเต็มหรือยัง
    // เพิ่มประชาชนเข้า shelter ถ้ายังไม่เต็ม
    public boolean addOne() {
        if (isFull()) return false;
        currentOccupancy++;
        return true;
    }

    // public void removeOne() {
    //     if (currentOccupancy > 0) currentOccupancy--;
    // }
}
