package ir.hatami.onlinereservation.service.impl;

import ir.hatami.onlinereservation.domain.dto.*;
import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.dto.common.ListDto;
import ir.hatami.onlinereservation.domain.model.Patient;
import ir.hatami.onlinereservation.repository.AppointmentRepository;
import ir.hatami.onlinereservation.repository.PatientRepository;
import ir.hatami.onlinereservation.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public PatientServiceImpl(PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<List<? extends ListDto>> load() {
        return Optional.of(this.patientRepository.findAll()
                .stream()
                .map(patient -> {
                    PatientListDto dto = new PatientListDto();
                    dto.setId(patient.getId());
                    dto.setEmail(patient.getEmail());
                    dto.setFirstName(patient.getFirstName());
                    dto.setLastName(patient.getLastName());
                    return dto;
                }).toList());
    }

    @Override
    public Optional<DetailsDto> load(UUID id) {
        Patient patient = this.patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        PatientDetailsDto dto = new PatientDetailsDto();

        dto.setId(patient.getId());
        dto.setEmail(patient.getEmail());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());

        dto.setAppointments(patient.getAppointments().stream().map(appointment -> {
                    AppointmentReadDto readDto = new AppointmentReadDto();
                    readDto.setPatientFullName(patient.getFirstName() + " " + patient.getLastName());
                    readDto.setDoctorFullName(appointment.getDoctor().getName() + " " + appointment.getDoctor().getSurname());
//                    readDto.setMeetingTime(appointment.getMeetingTime());
                    readDto.setId(appointment.getId());

                    return readDto;
                }).toList()
        );

        return Optional.of(dto);
    }

    @Override
    public void create(PatientCreateDto createDto) {
        Patient patient = new Patient();

        patient.setEmail(createDto.getEmail());
        patient.setFirstName(createDto.getFirstName());
        patient.setLastName(createDto.getLastName());
//        patient.setAppointments(this.appointmentRepository.findAllById(createDto.getAppointmentIds()));

        this.patientRepository.save(patient);
    }

    @Override
    @Transactional
    public void update(UUID id, PatientUpdateDto updateDto) {
        Patient patient = this.patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setEmail(updateDto.getEmail());
        patient.setFirstName(updateDto.getFirstName());
        patient.setLastName(updateDto.getLastName());
//        patient.setAppointments(this.appointmentRepository.findAllById(updateDto.getAppointmentIds()));

        this.patientRepository.save(patient);

    }

    @Override
    @Transactional
    public void delete(UUID id) {
        this.patientRepository.deleteById(id);
    }
}
