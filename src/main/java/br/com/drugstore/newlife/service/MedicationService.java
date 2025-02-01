package br.com.drugstore.newlife.service;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.entity.MedicationEntity;
import br.com.drugstore.newlife.repository.MedicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository repository;
    private ObjectMapper objectMapper;

    public MedicationDTO saveMedication(MedicationCreateDTO dto) {
        MedicationEntity medicationEntity = repository.save(objectMapper.convertValue(dto, MedicationEntity.class));
        return objectMapper.convertValue(medicationEntity, MedicationDTO.class);
    }

    public List<MedicationDTO> findAllMedication() {
        List<MedicationEntity> entityList = repository.findAll();
        return null;
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
