package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.domain.dto.PatientCreateDto;
import ir.hatami.onlinereservation.domain.dto.PatientDetailsDto;
import ir.hatami.onlinereservation.domain.dto.PatientListDto;
import ir.hatami.onlinereservation.domain.dto.PatientUpdateDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientListDto> load();

    PatientDetailsDto load(UUID id);

    void create(PatientCreateDto createDto);

    void update(UUID id, PatientUpdateDto updateDto);

    void delete(UUID id);
}
