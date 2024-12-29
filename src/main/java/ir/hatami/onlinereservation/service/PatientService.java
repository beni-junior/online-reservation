package ir.hatami.onlinereservation.service;

import ir.hatami.onlinereservation.domain.dto.PatientCreateDto;
import ir.hatami.onlinereservation.domain.dto.PatientDetailsDto;
import ir.hatami.onlinereservation.domain.dto.PatientListDto;
import ir.hatami.onlinereservation.domain.dto.PatientUpdateDto;
import ir.hatami.onlinereservation.service.common.CrudService;

import java.util.List;
import java.util.UUID;

public interface PatientService extends CrudService<UUID, PatientCreateDto, PatientUpdateDto> {

}
