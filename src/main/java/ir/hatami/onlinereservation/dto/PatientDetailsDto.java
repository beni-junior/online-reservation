package ir.hatami.onlinereservation.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientDetailsDto extends PatientListDto {

    private List<AppointmentReadDto> appointments = new ArrayList<>();

    public PatientDetailsDto() {
    }

    public List<AppointmentReadDto> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentReadDto> appointments) {
        this.appointments = appointments;
    }
}
