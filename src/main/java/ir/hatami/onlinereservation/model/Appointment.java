package ir.hatami.onlinereservation.model;

import ir.hatami.onlinereservation.model.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_appointment")
public class Appointment extends BaseEntity {

    private long meetingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY) // fetch data when needed.
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    public Appointment() {
    }

    public long getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(long meetingTime) {
        this.meetingTime = meetingTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

