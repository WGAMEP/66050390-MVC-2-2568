package Model;

import java.time.LocalDate;

public class Assignment {
    private String citizenId;
    private String shelterId;
    private LocalDate date;

    public Assignment(String citizenId, String shelterId) {
        this.citizenId = citizenId;
        this.shelterId = shelterId;
        this.date = LocalDate.now();
    }

    public String getCitizenId() { return citizenId; }
    public String getShelterId() { return shelterId; }
    public LocalDate getDate() { return date; }
}
