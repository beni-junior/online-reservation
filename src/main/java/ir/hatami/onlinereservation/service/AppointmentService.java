package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.domain.dto.AppointmentCreateDto;
import ir.hatami.onlinereservation.domain.dto.AppointmentUpdateDto;
import ir.hatami.onlinereservation.domain.model.Appointment;
import ir.hatami.onlinereservation.service.common.CrudService;

import java.util.List;
import java.util.UUID;

public interface AppointmentService extends CrudService<UUID,AppointmentCreateDto,AppointmentUpdateDto> {

    List<Appointment> findAndSetAllExpired();
}
