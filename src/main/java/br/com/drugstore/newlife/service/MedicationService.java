package br.com.drugstore.newlife.service;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationCreatedDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.entity.MedicationEntity;
import br.com.drugstore.newlife.repository.MedicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public List<MedicationDTO> findAllMedications() {
        return repository.findAll().stream()
                .map(medication -> objectMapper.convertValue(
                        medication, MedicationDTO.class)).collect(Collectors.toList());
    }

    public MedicationDTO updateMedication(MedicationDTO dto, UUID id) {
        return null;
    }

    public void deleteMedication(UUID id) {
        repository.deleteById(id);
    }

    private MedicationEntity findMedicationById(UUID id) {
        return null;
    }

}
