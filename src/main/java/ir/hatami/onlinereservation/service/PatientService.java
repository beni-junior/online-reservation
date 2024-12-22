package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.dto.*;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientListDto> load();

    PatientDetailsDto load(UUID id);

    void create(PatientCreateDto createDto);

    void update(UUID id, PatientUpdateDto updateDto);

    void delete(UUID id);
}
