package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.domain.dto.DoctorCreateDto;
import ir.hatami.onlinereservation.domain.dto.DoctorDetailsDto;
import ir.hatami.onlinereservation.domain.dto.DoctorListDto;
import ir.hatami.onlinereservation.domain.dto.DoctorUpdateDto;
import ir.hatami.onlinereservation.service.common.CrudService;

import java.util.List;
import java.util.UUID;

public interface DoctorService extends CrudService<UUID,DoctorCreateDto,DoctorUpdateDto> {

}
