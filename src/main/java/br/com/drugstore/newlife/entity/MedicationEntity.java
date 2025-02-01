package br.com.drugstore.newlife.entity;

import br.com.drugstore.newlife.enums.Laboratory;
import br.com.drugstore.newlife.enums.PharmaceuticalForm;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_medication")
public class MedicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String concentration;

    @Convert(converter = PharmaceuticalForm.class)
    private PharmaceuticalForm pharmaceuticalForm;

    @Convert(converter = Laboratory.class)
    private Laboratory loboratory;

    private LocalDate expirationDate;
    private Double salePrice;
}
