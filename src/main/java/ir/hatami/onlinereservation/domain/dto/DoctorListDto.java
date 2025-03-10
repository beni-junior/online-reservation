package ir.hatami.onlinereservation.domain.dto;

import ir.hatami.onlinereservation.domain.dto.common.BaseReadDto;
import ir.hatami.onlinereservation.domain.dto.common.ListDto;
import ir.hatami.onlinereservation.domain.type.Speciality;

import java.util.UUID;

public class DoctorListDto extends BaseReadDto implements ListDto {

    private String name;
    private String surname;
    private Speciality speciality;
    private String phone;
    private String address;

    public DoctorListDto() {
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
}
