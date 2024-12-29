package ir.hatami.onlinereservation.service.impl;

import ir.hatami.onlinereservation.domain.dto.ArchivedAppointmentDetailsDto;
import ir.hatami.onlinereservation.domain.dto.ArchivedAppointmentListDto;
import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.model.ArchivedAppointment;
import ir.hatami.onlinereservation.repository.ArchivedAppointmentRepository;
import ir.hatami.onlinereservation.service.ArchivedAppointmentService;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Optional;

public class ArchivedAppointmentServiceImpl implements ArchivedAppointmentService, InitializingBean {
    private final ArchivedAppointmentRepository archivedAppointmentRepository;

    public ArchivedAppointmentServiceImpl(ArchivedAppointmentRepository archivedAppointmentRepository) {
        this.archivedAppointmentRepository = archivedAppointmentRepository;
    }

    @Override
    public Optional<List<ArchivedAppointmentListDto>> load() {
        List<ArchivedAppointment> all = this.archivedAppointmentRepository.findAll();

        List<ArchivedAppointmentListDto> result = all.stream()
                .map(arch -> {
                    ArchivedAppointmentListDto listDto = new ArchivedAppointmentListDto();
                    listDto.setId(arch.getId());
                    listDto.setAppointmentDate(arch.getAppointmentDate());
                    listDto.setDoctorFullName(arch.getDoctorFullName());
                    listDto.setPatientFullName(arch.getPatientFullName());
                    return listDto;
                }).toList();

        return Optional.of(result);
    }

    @Override
    public Optional<DetailsDto> load(Long id) {
        ArchivedAppointment archivedAppointment = this.archivedAppointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id"));
        ArchivedAppointmentDetailsDto detailsDto = new ArchivedAppointmentDetailsDto();

        detailsDto.setId(archivedAppointment.getId());
        detailsDto.setAppointmentDate(archivedAppointment.getAppointmentDate());
        detailsDto.setDoctorFullName(archivedAppointment.getDoctorFullName());
        detailsDto.setDoctorPhone(archivedAppointment.getDoctorPhone());
        detailsDto.setDoctorAddress(archivedAppointment.getDoctorAddress());
        detailsDto.setDoctorSpeciality(archivedAppointment.getDoctorSpeciality());
        detailsDto.setPatientFullName(archivedAppointment.getPatientFullName());
        detailsDto.setPatientEmail(archivedAppointment.getPatientEmail());

        return Optional.of(detailsDto);
    }

    @Override
    public void create(ArchivedAppointment archivedAppointment) {
        archivedAppointmentRepository.save(archivedAppointment);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(new AppointmentArchiverTask(), "archiver-thread").start();
    }

    private static class AppointmentArchiverTask implements Runnable {

        @Override
        public void run() {
            while (true) {
            }
            // TODO process and find expired and call create archive
        }
    }
}
