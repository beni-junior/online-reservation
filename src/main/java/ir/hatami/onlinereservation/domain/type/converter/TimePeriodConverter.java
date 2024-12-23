package ir.hatami.onlinereservation.domain.type.converter;

import ir.hatami.onlinereservation.domain.type.TimePeriod;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TimePeriodConverter implements AttributeConverter<TimePeriod, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TimePeriod timePeriod) {
        return timePeriod.getCode();
    }

    @Override
    public TimePeriod convertToEntityAttribute(Integer integer) {
        return TimePeriod.of(integer);
    }
}
