package Controller;

import java.util.List;

import Model.*;

public class ShelterController {

    private final ShelterService service = new ShelterService();

    public ShelterService getService() {
        return service;
    }
    // ลงทะเบียนประชาชนใหม่
    public boolean registerCitizen(Citizen c) {
        return service.registerCitizen(c);
    }
    // จัดสรรที่พักทั้งหมด
    public String assignAll() {
        return service.assignAll();
    }
    // ส่งรายชื่อประชาชนตาม filter ให้ View
    public List<Citizen> filterCitizens(FilterType type){
        return service.getCitizensByFilter(type);
    }
}


