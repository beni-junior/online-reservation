package ir.hatami.onlinereservation.domain.model;

import ir.hatami.onlinereservation.domain.model.common.BaseEntity;
import ir.hatami.onlinereservation.domain.type.Speciality;
import ir.hatami.onlinereservation.domain.type.converter.SpecialityConverter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity // define jpa entity
@Table(name = "tb_doctor") // define table name for mapping class to mysql table
public class Doctor extends BaseEntity {

    private String name;
    private String surname;
    // convert enum to number for saving in db (its auto applied no need to declare)
    @Convert(converter = SpecialityConverter.class)
    private Speciality speciality;

    private String phone;
    private String address;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor() {
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
