package br.com.drugstore.newlife.dto;

import br.com.drugstore.newlife.enums.Laboratory;
import br.com.drugstore.newlife.enums.PharmaceuticalForm;

import java.time.LocalDate;
import java.util.UUID;

public record MedicationCreatedDTO(
        UUID id,
        String name,
        String concentration,
        PharmaceuticalForm pharmaceuticalForm,
        Laboratory laboratory,
        LocalDate registrationDate,
        LocalDate expirationDate,
        Integer quantityInStock,
        Double costPrice,
        Double salePrice,
        Boolean isActive) {
}
