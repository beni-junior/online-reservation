package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.domain.dto.DoctorCreateDto;
import ir.hatami.onlinereservation.domain.dto.DoctorDetailsDto;
import ir.hatami.onlinereservation.domain.dto.DoctorListDto;
import ir.hatami.onlinereservation.domain.dto.DoctorUpdateDto;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    List<DoctorListDto> load();

    DoctorDetailsDto load(UUID id);

    void create(DoctorCreateDto createDto);

    void update(UUID id,DoctorUpdateDto updateDto);

    void delete(UUID id);

}
