package ir.hatami.onlinereservation.domain.dto;

import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;

import java.util.ArrayList;
import java.util.List;

public class PatientDetailsDto extends PatientListDto implements DetailsDto {

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
