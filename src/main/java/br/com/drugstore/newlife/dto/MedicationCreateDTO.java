package br.com.drugstore.newlife.dto;

import br.com.drugstore.newlife.enums.Laboratory;
import br.com.drugstore.newlife.enums.PharmaceuticalForm;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record MedicationCreateDTO(
        @NotBlank
        String name,

        @NotBlank
        String concentration,

        @Convert(converter = PharmaceuticalForm.class)
        PharmaceuticalForm pharmaceuticalForm,

        @Convert(converter = Laboratory.class)
        Laboratory laboratory,

        @PastOrPresent
        LocalDate registrationDate,

        @Future
        LocalDate expirationDate,

        @NotNull
        int quantityInStock,

        @NotNull
        double costPrice,

        @NotNull
        double salePrice) {
}

// Concentração (concentration): Quantidade do princípio ativo por unidade (ex: 500 mg, 10 mg/mL).
// Forma Farmacêutica (pharmaceuticalForm): Forma de apresentação (ex: comprimido, cápsula, xarope, injetável).
// Quantidade em Estoque (quantityInStock): Quantidade disponível no estoque.
// Preço de Custo (costPrice): Preço de compra do medicamento.
// Preço de Venda (salePrice): Preço de venda ao consumidor.