package ir.hatami.onlinereservation.service.impl;

import ir.hatami.onlinereservation.dto.*;
import ir.hatami.onlinereservation.model.Appointment;
import ir.hatami.onlinereservation.model.Doctor;
import ir.hatami.onlinereservation.repository.AppointmentRepository;
import ir.hatami.onlinereservation.repository.DoctorRepository;
import ir.hatami.onlinereservation.service.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<DoctorListDto> load() {
        return this.doctorRepository.findAll()
                .stream()
                .map(doctor -> {
                    DoctorListDto dto = new DoctorListDto();
                    dto.setId(doctor.getId());
                    dto.setName(doctor.getName());
                    dto.setSurname(doctor.getSurname());
                    dto.setAddress(doctor.getAddress());
                    dto.setPhone(doctor.getPhone());
                    dto.setSpeciality(doctor.getSpeciality());

                    return dto;
                }).toList();
    }

    @Override
    public DoctorDetailsDto load(UUID id) {
        Doctor doctor = this.doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid.doctor.id"));

        DoctorDetailsDto dto = new DoctorDetailsDto();

        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSurname(doctor.getSurname());
        dto.setAddress(doctor.getAddress());
        dto.setPhone(doctor.getPhone());
        dto.setSpeciality(doctor.getSpeciality());

        dto.setAppointments(doctor.getAppointments().stream().map(appointment -> {
                    AppointmentReadDto readDtp = new AppointmentReadDto();
                    readDtp.setId(appointment.getId());
                    readDtp.setDoctorFullName(doctor.getName() + " " + doctor.getSurname());
                    readDtp.setPatientFullName(appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName());
                    readDtp.setMeetingTime(appointment.getMeetingTime());
                    return readDtp;
                }).toList()
        );
        return dto;
    }

    @Override
    public void create(DoctorCreateDto createDto) {
        Doctor doctor = new Doctor();

        doctor.setAddress(createDto.getAddress());
        doctor.setName(createDto.getName());
        doctor.setSurname(createDto.getSurname());
        doctor.setSpeciality(createDto.getSpeciality());
        doctor.setPhone(createDto.getPhone());
//        List<Appointment> appointments = this.appointmentRepository.findAllById(createDto.getAppointmentIds());
//        doctor.setAppointments(appointments);

        this.doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public void update(UUID id, DoctorUpdateDto updateDto) {
        Doctor doctor = this.doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid.doctor.id"));
        doctor.setName(updateDto.getName());
        doctor.setSurname(updateDto.getSurname());
        doctor.setAddress(updateDto.getAddress());
        doctor.setSpeciality(updateDto.getSpeciality());
        doctor.setPhone(updateDto.getPhone());
//        List<Appointment> appointments = this.appointmentRepository.findAllById(updateDto.getAppointmentIds());
//        doctor.setAppointments(appointments);

        this.doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        this.doctorRepository.deleteById(id);
    }
}
