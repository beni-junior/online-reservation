package ir.hatami.onlinereservation.domain.model;

import ir.hatami.onlinereservation.domain.model.common.BaseEntity;
import ir.hatami.onlinereservation.domain.type.TimePeriod;
import ir.hatami.onlinereservation.domain.type.converter.TimePeriodConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_appointment")
public class Appointment extends BaseEntity {

//    @Convert(converter = TimePeriodConverter.class)
//    private TimePeriod timePeriod;
    private long date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY) // fetch data when needed.
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    boolean expired;

    public Appointment() {
    }



    public long getDate() {
        return date;
    }

    public void setDate(long meetingTime) {
        this.date = meetingTime;
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

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}

