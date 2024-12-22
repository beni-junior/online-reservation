package ir.hatami.onlinereservation.type.converter;

import ir.hatami.onlinereservation.type.Speciality;
import jakarta.persistence.AttributeConverter;

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
