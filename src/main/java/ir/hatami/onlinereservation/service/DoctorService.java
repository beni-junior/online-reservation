package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.dto.DoctorCreateDto;
import ir.hatami.onlinereservation.dto.DoctorDetailsDto;
import ir.hatami.onlinereservation.dto.DoctorListDto;
import ir.hatami.onlinereservation.dto.DoctorUpdateDto;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    List<DoctorListDto> load();

    DoctorDetailsDto load(UUID id);

    void create(DoctorCreateDto createDto);

    void update(UUID id,DoctorUpdateDto updateDto);

    void delete(UUID id);

}
