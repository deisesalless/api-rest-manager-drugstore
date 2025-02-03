package br.com.drugstore.newlife.dto;

import br.com.drugstore.newlife.enums.Laboratory;
import br.com.drugstore.newlife.enums.PharmaceuticalForm;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MedicationCreateDTO(
        @NotBlank(message = "O campo NAME não pode estar vazio ou nulo")
        String name,

        @NotBlank(message = "O campo CONCENTRATION não pode estar vazio ou nulo")
        String concentration,

        @NotNull(message = "O campo PHARMACEUTICAL FORM não pode ser nulo")
        @Convert(converter = PharmaceuticalForm.class)
        PharmaceuticalForm pharmaceuticalForm,

        @NotNull(message = "O campo LABORATORY não pode ser nulo")
        @Convert(converter = Laboratory.class)
        Laboratory laboratory,

        @PastOrPresent(message = "A data de registro deve ser a data atual ou do passado")
        LocalDate registrationDate,

        @Future(message = "A data de validade deve estar no futuro")
        LocalDate expirationDate,

        @NotNull(message = "O campo QUANTITY não pode ser nulo")
        @Positive(message = "O campo QUANTITY deve ser maior que zero")
        Integer quantityInStock,

        @NotNull(message = "O campo COST PRICE não pode ser nulo")
        Double costPrice,

        @NotNull(message = "O campo SALE PRICE não pode ser nulo")
        Double salePrice) {
}