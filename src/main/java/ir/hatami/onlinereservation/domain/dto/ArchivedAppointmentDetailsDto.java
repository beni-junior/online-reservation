package ir.hatami.onlinereservation.domain.dto;

import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.type.Speciality;

public class ArchivedAppointmentDetailsDto extends ArchivedAppointmentListDto implements DetailsDto {
    private String doctorAddress;
    private Speciality doctorSpeciality;
    private String doctorPhone;
    private String patientEmail;

    public ArchivedAppointmentDetailsDto() {
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public Speciality getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(Speciality doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
}
