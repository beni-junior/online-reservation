package ir.hatami.onlinereservation.domain.dto;

import ir.hatami.onlinereservation.domain.dto.common.CreateDto;
import ir.hatami.onlinereservation.domain.type.Speciality;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DoctorCreateDto implements CreateDto {

    @NotNull
    @Size(max = 64)
    private String name;
    @NotNull
    @Size(max = 64)
    private String surname;
    @NotNull
    private Speciality speciality;
    @NotNull
    @Size(max = 15)
    private String phone;
    @NotNull
    @Size(max = 255)
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
