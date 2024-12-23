package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.domain.dto.AppointmentCreateDto;
import ir.hatami.onlinereservation.domain.dto.AppointmentReadDto;
import ir.hatami.onlinereservation.domain.dto.AppointmentUpdateDto;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    List<AppointmentReadDto> load();

    AppointmentReadDto load(UUID id);

    void create(AppointmentCreateDto createDto);

    void update(UUID id,AppointmentUpdateDto updateDto);

    void delete(UUID id);
}
