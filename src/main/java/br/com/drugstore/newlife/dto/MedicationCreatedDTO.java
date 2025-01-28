package br.com.drugstore.newlife.dto;

import br.com.drugstore.newlife.enums.Laboratory;
import br.com.drugstore.newlife.enums.PharmaceuticalForm;

import java.time.LocalDate;

public record MedicationCreatedDTO(String name, String concentration, PharmaceuticalForm pharmaceuticalForm,
                                   Laboratory loboratory, LocalDate expirationDate, double salePrice)  {
}

// Concentração (concentration): Quantidade do princípio ativo por unidade (ex: 500 mg, 10 mg/mL).
// Forma Farmacêutica (pharmaceuticalForm): Forma de apresentação (ex: comprimido, cápsula, xarope, injetável).
// Preço de Venda (salePrice): Preço de venda ao consumidor.