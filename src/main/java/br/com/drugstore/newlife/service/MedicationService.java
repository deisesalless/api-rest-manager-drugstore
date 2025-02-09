package br.com.drugstore.newlife.service;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationCreatedDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.dto.MedicationUpdateDTO;
import br.com.drugstore.newlife.entity.MedicationEntity;
import br.com.drugstore.newlife.repository.MedicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    public MedicationCreatedDTO saveMedication(MedicationCreateDTO dto) {
        MedicationEntity medicationEntity = repository.save(objectMapper.convertValue(dto, MedicationEntity.class));
        return objectMapper.convertValue(medicationEntity, MedicationCreatedDTO.class);
    }


    public List<MedicationDTO> findAllMedications(Boolean active) {
        List<MedicationEntity> medications;

        if (active == null) medications = repository.findAll(); // Retorna todos os medicamentos
        else medications = repository.findByActive(active); // Filtra por ativos/inativos

        return medications.stream().map(medication ->
                objectMapper.convertValue(medication, MedicationDTO.class)).toList();
    }

    public MedicationDTO findById(UUID id) {
         Optional<MedicationEntity> medicationEntity = repository.findById(id);
        if (medicationEntity.isEmpty()) return null;
        else return objectMapper.convertValue(medicationEntity, MedicationDTO.class);
    }

    @Transactional
    public MedicationDTO updateMedication(UUID id, MedicationUpdateDTO dto) {
        Optional<MedicationEntity> optionalMedication = repository.findById(id);

        if (optionalMedication.isEmpty()) return null; // Lançar exception personalizada

        MedicationEntity medicationEntity = optionalMedication.get();
        medicationEntity.setName(dto.name());
        medicationEntity.setConcentration(dto.concentration());
        medicationEntity.setPharmaceuticalForm(dto.pharmaceuticalForm());
        medicationEntity.setLaboratory(dto.laboratory());
        medicationEntity.setExpirationDate(dto.expirationDate());
        medicationEntity.setQuantityInStock(dto.quantityInStock());
        medicationEntity.setCostPrice(dto.costPrice());
        medicationEntity.setSalePrice(dto.salePrice());
        medicationEntity = repository.save(medicationEntity);

        return objectMapper.convertValue(medicationEntity, MedicationDTO.class);
    }

    @Transactional
    public void updateStatus(UUID id, boolean active) {
        MedicationDTO dto = findById(id);

        if (dto != null && active) repository.reactivate(id);
        if (dto != null) repository.reactivate(id);

    }


}
