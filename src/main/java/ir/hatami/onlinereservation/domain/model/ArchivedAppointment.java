package ir.hatami.onlinereservation.domain.model;

import ir.hatami.onlinereservation.domain.type.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_archived_appointment")
public class ArchivedAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long appointmentDate;

    @NotBlank
    private String doctorFullName;
    @NotBlank
    private String doctorAddress;
    @NotNull
    private Speciality doctorSpeciality;
    @NotBlank
    private String doctorPhone;
    @NotBlank
    private String patientFullName;
    @NotBlank
    private String patientEmail;

    public ArchivedAppointment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(long appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public @NotBlank String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(@NotBlank String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public @NotBlank String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(@NotBlank String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public @NotNull Speciality getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(@NotNull Speciality doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public @NotBlank String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(@NotBlank String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public @NotBlank String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(@NotBlank String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public @NotBlank String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(@NotBlank String patientEmail) {
        this.patientEmail = patientEmail;
    }
}
