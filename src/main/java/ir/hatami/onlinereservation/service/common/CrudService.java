package ir.hatami.onlinereservation.service.common;

import ir.hatami.onlinereservation.domain.dto.common.CreateDto;
import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.dto.common.ListDto;
import ir.hatami.onlinereservation.domain.dto.common.UpdateDto;

import java.util.List;
import java.util.Optional;

public interface CrudService<ID, CD extends CreateDto, UD extends UpdateDto> {
    Optional<List<? extends ListDto>> load();

    Optional<DetailsDto> load(ID id);

    void create(CD createDto);

    void update(ID id, UD updateDto);

    void delete(ID id);
}
