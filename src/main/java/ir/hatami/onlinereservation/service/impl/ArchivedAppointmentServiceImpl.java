package ir.hatami.onlinereservation.service.impl;

import ir.hatami.onlinereservation.domain.dto.ArchivedAppointmentDetailsDto;
import ir.hatami.onlinereservation.domain.dto.ArchivedAppointmentListDto;
import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.model.Appointment;
import ir.hatami.onlinereservation.domain.model.ArchivedAppointment;
import ir.hatami.onlinereservation.domain.model.Doctor;
import ir.hatami.onlinereservation.domain.model.Patient;
import ir.hatami.onlinereservation.repository.ArchivedAppointmentRepository;
import ir.hatami.onlinereservation.service.AppointmentService;
import ir.hatami.onlinereservation.service.ArchivedAppointmentService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
    @implNote  interface of "InitializingBean" is Spring boot interface with method initialize that this method will be invoked automatically after all requirements of this service is gathered.
 */
@Service
public class ArchivedAppointmentServiceImpl implements ArchivedAppointmentService, InitializingBean {

    private final ArchivedAppointmentRepository archivedAppointmentRepository;
    private final AppointmentService appointmentService;

    public ArchivedAppointmentServiceImpl(ArchivedAppointmentRepository archivedAppointmentRepository, AppointmentService appointmentService) {
        this.archivedAppointmentRepository = archivedAppointmentRepository;
        this.appointmentService = appointmentService;
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
    public void afterPropertiesSet() throws Exception {
        // create and start a worker method that will be alive infinite.
        new Thread(new AppointmentArchiverTask(), "archiver-thread").start();
    }

    private class AppointmentArchiverTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                int counter = 0;
                for (Appointment appointment : appointmentService.findAndSetAllExpired()) {
                    ArchivedAppointment archivedAppointment = new ArchivedAppointment();

                    archivedAppointment.setAppointmentDate(appointment.getDate());

                    Doctor doctor = appointment.getDoctor();
                    archivedAppointment.setDoctorFullName(doctor.getName() + " " + doctor.getSurname());
                    archivedAppointment.setDoctorAddress(doctor.getAddress());
                    archivedAppointment.setDoctorPhone(doctor.getPhone());
                    archivedAppointment.setDoctorSpeciality(doctor.getSpeciality());

                    Patient patient = appointment.getPatient();
                    archivedAppointment.setPatientFullName(patient.getFirstName() + " " + patient.getLastName());
                    archivedAppointment.setPatientEmail(patient.getEmail());

                    this.create(archivedAppointment);
                    counter++;
                }
                System.out.printf(">>>> %d appointment got expired.\n", counter);
                this.delay();
            }

        }

        private void create(ArchivedAppointment archivedAppointment) {
            archivedAppointmentRepository.save(archivedAppointment);
        }

        private void delay() {
            try {
                TimeUnit.MINUTES.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
