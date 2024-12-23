package ir.hatami.onlinereservation.domain.type.converter;

import ir.hatami.onlinereservation.domain.type.Speciality;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SpecialityConverter implements AttributeConverter<Speciality, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Speciality speciality) {
        return speciality.getCode();
    }

    @Override
    public Speciality convertToEntityAttribute(Integer code) {
        return Speciality.of(code);
    }
}
