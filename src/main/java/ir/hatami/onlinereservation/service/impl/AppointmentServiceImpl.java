package ir.hatami.onlinereservation.service.impl;

import ir.hatami.onlinereservation.domain.dto.AppointmentCreateDto;
import ir.hatami.onlinereservation.domain.dto.AppointmentReadDto;
import ir.hatami.onlinereservation.domain.dto.AppointmentUpdateDto;
import ir.hatami.onlinereservation.domain.model.Appointment;
import ir.hatami.onlinereservation.domain.model.Doctor;
import ir.hatami.onlinereservation.domain.model.Patient;
import ir.hatami.onlinereservation.domain.type.TimePeriod;
import ir.hatami.onlinereservation.repository.AppointmentRepository;
import ir.hatami.onlinereservation.repository.DoctorRepository;
import ir.hatami.onlinereservation.repository.PatientRepository;
import ir.hatami.onlinereservation.service.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<AppointmentReadDto> load() {
        return this.appointmentRepository.findAll().stream().map(app -> {
            AppointmentReadDto appointmentReadDto = new AppointmentReadDto();
            appointmentReadDto.setId(app.getId());
            appointmentReadDto.setMeetingTime(app.getDate());
            appointmentReadDto.setDoctorFullName(app.getDoctor().getName() + " " + app.getDoctor().getSurname());
            appointmentReadDto.setPatientFullName(app.getPatient().getFirstName() + " " + app.getPatient().getLastName());

            return appointmentReadDto;
        }).toList();
    }

    @Override
    public AppointmentReadDto load(UUID id) {
        Appointment appointment = this.appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid.appointment.id"));

        AppointmentReadDto appointmentReadDto = new AppointmentReadDto();
        appointmentReadDto.setMeetingTime(appointment.getDate());
        appointmentReadDto.setDoctorFullName(appointment.getDoctor().getName() + " " + appointment.getDoctor().getSurname());
        appointmentReadDto.setPatientFullName(appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName());
        appointmentReadDto.setId(appointment.getId());

        return appointmentReadDto;
    }

    @Override
    public void create(AppointmentCreateDto createDto) {
        Appointment appointment = new Appointment();
        Doctor doctor = this.doctorRepository.findById(createDto.getDoctorId()).orElseThrow(() -> new RuntimeException("invalid.doctor.id"));
        Patient patient = this.patientRepository.findById(createDto.getPatientId()).orElseThrow(() -> new RuntimeException("invalid.patient.id"));

        if (this.appointmentRepository.countOfDuplicateAppointments(createDto.getDate(), createDto.getTimePeriod().getCode(), createDto.getDoctorId()) > 0) {
            throw new RuntimeException("Duplicate Appointment");
        }
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setDate(createDto.getDate());
        appointment.setTimePeriod(createDto.getTimePeriod());
        this.appointmentRepository.save(appointment);
    }

    @Override
    @Transactional
    public void update(UUID id, AppointmentUpdateDto updateDto) {
        Appointment appointment = this.appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid.appointment.id"));

        Doctor doctor = this.doctorRepository.findById(updateDto.getDoctorId()).orElseThrow(() -> new RuntimeException("invalid.doctor.id"));
        Patient patient = this.patientRepository.findById(updateDto.getPatientId()).orElseThrow(() -> new RuntimeException("invalid.patient.id"));

        appointment.setDate(updateDto.getDate());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        this.appointmentRepository.save(appointment);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        this.appointmentRepository.deleteById(id);
    }
}
