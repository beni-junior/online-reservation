package ir.hatami.onlinereservation.dto;

import ir.hatami.onlinereservation.type.Speciality;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DoctorCreateDto {

    private String name;
    private String surname;
    private Speciality speciality;
    private String phone;
    private String address;
//    private List<UUID> appointmentIds = new ArrayList<>();

    public DoctorCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public List<UUID> getAppointmentIds() {
//        return appointmentIds;
//    }
//
//    public void setAppointmentIds(List<UUID> appointmentIds) {
//        this.appointmentIds = appointmentIds;
//    }
}
