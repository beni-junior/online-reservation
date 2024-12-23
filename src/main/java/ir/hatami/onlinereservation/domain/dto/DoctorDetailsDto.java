package ir.hatami.onlinereservation.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class DoctorDetailsDto extends DoctorListDto{

    private List<AppointmentReadDto> appointments = new ArrayList<>();

    public DoctorDetailsDto() {
    }

    public List<AppointmentReadDto> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentReadDto> appointments) {
        this.appointments = appointments;
    }
}
