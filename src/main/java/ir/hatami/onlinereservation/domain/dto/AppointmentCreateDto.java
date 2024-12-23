package ir.hatami.onlinereservation.domain.dto;

import ir.hatami.onlinereservation.domain.type.TimePeriod;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class AppointmentCreateDto {
    @Min(1)
    private long date;
    @NotNull
    private UUID doctorId;
    @NotNull
    private UUID patientId;
    @NotNull
    private TimePeriod timePeriod;

    public AppointmentCreateDto() {
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }
}
