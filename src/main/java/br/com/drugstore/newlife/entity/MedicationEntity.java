package br.com.drugstore.newlife.entity;

import br.com.drugstore.newlife.enums.Laboratory;
import br.com.drugstore.newlife.enums.PharmaceuticalForm;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class MedicationEntity {
    private UUID id;
    private String name;
    private String concentration;
    private PharmaceuticalForm pharmaceuticalForm;
    private Laboratory loboratory;
    private LocalDate expirationDate;
    private Double salePrice;
}
