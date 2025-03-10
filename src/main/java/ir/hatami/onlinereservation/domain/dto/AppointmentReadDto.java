package ir.hatami.onlinereservation.domain.dto;

import ir.hatami.onlinereservation.domain.dto.common.BaseReadDto;
import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.dto.common.ListDto;

public class AppointmentReadDto extends BaseReadDto implements ListDto, DetailsDto {

    private String doctorFullName;
    private String patientFullName;
    private long meetingTime;

    public AppointmentReadDto() {
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public long getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(long meetingTime) {
        this.meetingTime = meetingTime;
    }
}
