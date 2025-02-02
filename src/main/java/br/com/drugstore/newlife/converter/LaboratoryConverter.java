package br.com.drugstore.newlife.converter;

import br.com.drugstore.newlife.enums.Laboratory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LaboratoryConverter implements AttributeConverter<Laboratory, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Laboratory laboratory) {
        return (laboratory != null) ? laboratory.getCode() : null;
    }

    @Override
    public Laboratory convertToEntityAttribute(Integer code) {
        return (code != null) ? Laboratory.fromCode(code) : null;
    }
}
