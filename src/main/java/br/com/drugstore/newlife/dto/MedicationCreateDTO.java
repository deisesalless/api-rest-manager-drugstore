package br.com.drugstore.newlife.dto;

import java.time.LocalDate;

public record MedicationCreateDTO(String name, double concentration, String pharmaceuticalForm, LocalDate registrationDate,
                                  LocalDate expirationDate, int quantityInStock, double costPrice, double salePrice) {
}

// Concentração (concentration): Quantidade do princípio ativo por unidade (ex: 500 mg, 10 mg/mL).
// Forma Farmacêutica (pharmaceuticalForm): Forma de apresentação (ex: comprimido, cápsula, xarope, injetável).
// Quantidade em Estoque (quantityInStock): Quantidade disponível no estoque.
// Preço de Custo (costPrice): Preço de compra do medicamento.
// Preço de Venda (salePrice): Preço de venda ao consumidor.
// Preço de Custo (costPrice): Preço de compra do medicamento.
// Preço de Venda (salePrice): Preço de venda ao consumidor.