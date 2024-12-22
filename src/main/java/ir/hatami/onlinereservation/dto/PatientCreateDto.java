package ir.hatami.onlinereservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PatientCreateDto {

    private String firstName;
    private String lastName;
    private String email;
//    private List<UUID> appointmentIds = new ArrayList<>();

    public PatientCreateDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<UUID> getAppointmentIds() {
//        return appointmentIds;
//    }
//
//    public void setAppointmentIds(List<UUID> appointmentIds) {
//        this.appointmentIds = appointmentIds;
//    }
}
