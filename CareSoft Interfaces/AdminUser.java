package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    private String role;
    private ArrayList<String> securityIncidents;
    
    public AdminUser(Integer id, String role) {
        super(id);
        this.role = role;
        this.securityIncidents = new ArrayList<>();
    }

    @Override
    public boolean assignPin(int pin) {
        if (pin >= 100000) {
            setPin(pin);
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (!getId().equals(confirmedAuthID)) {
            authIncident();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), getId(), notes
        );
        securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), getId(), "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
}
