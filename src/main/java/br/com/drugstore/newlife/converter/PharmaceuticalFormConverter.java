package br.com.drugstore.newlife.converter;

import br.com.drugstore.newlife.enums.PharmaceuticalForm;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PharmaceuticalFormConverter implements AttributeConverter<PharmaceuticalForm, Integer>  {

    @Override
    public Integer convertToDatabaseColumn(PharmaceuticalForm pharmaceuticalForm) {
        return (pharmaceuticalForm!= null) ? pharmaceuticalForm.getCode() : null;
    }

    @Override
    public PharmaceuticalForm convertToEntityAttribute(Integer code) {
        return (code != null) ? PharmaceuticalForm.fromCode(code) : null;
    }
}
