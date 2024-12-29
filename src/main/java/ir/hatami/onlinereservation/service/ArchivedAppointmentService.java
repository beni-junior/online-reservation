package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.domain.dto.ArchivedAppointmentListDto;
import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.model.ArchivedAppointment;

import java.util.List;
import java.util.Optional;

public interface ArchivedAppointmentService {
    Optional<List<ArchivedAppointmentListDto>> load();

    Optional<DetailsDto> load(Long id);

    void create(ArchivedAppointment archivedAppointment);
}
