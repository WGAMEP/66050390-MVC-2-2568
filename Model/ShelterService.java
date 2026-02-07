package Model;

import java.util.*;
import java.util.stream.Collectors;
import Model.FilterType;


public class ShelterService {

    private final List<Shelter> shelters = new ArrayList<>();
    private final List<Citizen> citizens = new ArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();


    public void addShelter(Shelter s) {
        shelters.add(s);
    }

    public List<Shelter> getShelters() {
        return Collections.unmodifiableList(shelters);
    }


    public boolean registerCitizen(Citizen c) { //ตรวจ ID ซ้ำ
        for (Citizen x : citizens) {
            if (x.getId().equalsIgnoreCase(c.getId())) {
                return false; 
            }
        }
        citizens.add(c);
        return true;
    }

    public List<Citizen> getCitizens() {
        return Collections.unmodifiableList(citizens);
    }

    public List<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    // จัดลำดับและกระจายประชาชนเข้า shelter
    public String assignAll() { 
        int assignedCount = 0;
  
        Map<String, Shelter> shelterMap = shelters.stream()
                .collect(Collectors.toMap(Shelter::getId, s -> s));

   
        List<Citizen> queue = citizens.stream()
                .filter(c -> !c.isAssigned())
                .collect(Collectors.toList());

   
        queue.sort((a, b) -> {
            if (a.isPriorityAge() && !b.isPriorityAge()) return -1;
            if (!a.isPriorityAge() && b.isPriorityAge()) return 1;
            return 0;
        });

        for (Citizen c : queue) {
            List<Shelter> candidates;
            if (c.hasHealthRisk()) { 
                candidates = shelters.stream()
                        .filter(s -> s.getRiskLevel() == RiskLevel.LOW && !s.isFull())
                        .collect(Collectors.toList());
            } else {
                candidates = shelters.stream()
                        .filter(s -> !s.isFull())
                        .collect(Collectors.toList());
            }

            if (candidates.isEmpty()) {
                continue; 
            }

            candidates.sort((s1, s2) -> {
                int free1 = s1.getCapacity() - s1.getCurrentOccupancy();
                int free2 = s2.getCapacity() - s2.getCurrentOccupancy();
                return Integer.compare(free2, free1); 
            });

            Shelter chosen = candidates.get(0);
            boolean ok = chosen.addOne();
            if (ok) {
                c.assignTo(chosen.getId());
                assignments.add(new Assignment(c.getId(), chosen.getId()));
                assignedCount++;
            }
        }

        return String.format("Assigned %d people (remaining unassigned: %d)", assignedCount,
                (int) citizens.stream().filter(p -> !p.isAssigned()).count());
    }
    public List<Citizen> getCitizensByType(CitizenType type) {
        return citizens.stream().filter(c -> c.getType() == type).collect(Collectors.toList());
    }

    // กรองประชาชนตามประเภท filter
    public List<Citizen> getCitizensByFilter(FilterType type) {
    
    return citizens.stream().filter(c -> {

        return switch(type) {

            case ALL -> true;

            case NORMAL ->
                    c.getType() == CitizenType.NORMAL;

            case RISK_GROUP ->
                    c.getType() == CitizenType.RISK_GROUP;

            case VIP ->
                    c.getType() == CitizenType.VIP;

            case CHILD ->
                    c.isChild();

            case ELDERLY ->
                    c.isElderly();
        };

    }).toList();
}

}
