package br.com.drugstore.newlife.entity;

import br.com.drugstore.newlife.converter.LaboratoryConverter;
import br.com.drugstore.newlife.converter.PharmaceuticalFormConverter;
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

    @Convert(converter = PharmaceuticalFormConverter.class)
    @Column(columnDefinition = "TINYINT(1)")
    private PharmaceuticalForm pharmaceuticalForm;

    @Convert(converter = LaboratoryConverter.class)
    @Column(columnDefinition = "TINYINT(1)")
    private Laboratory laboratory;

    private LocalDate registrationDate;

    private LocalDate expirationDate;

    private Integer quantityInStock;

    private Double costPrice;

    private Double salePrice;

    @Column(name = "is_active", columnDefinition = "TINYINT(1)")
    private Boolean isActive = true;
}
