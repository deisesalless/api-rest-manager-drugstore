package br.com.drugstore.newlife.service;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationCreatedDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.dto.MedicationUpdateDTO;
import br.com.drugstore.newlife.entity.MedicationEntity;
import br.com.drugstore.newlife.repository.MedicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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


    public List<MedicationDTO> findAllMedications() {
        return repository.findAll().stream()
                .map(medication -> objectMapper.convertValue(
                        medication, MedicationDTO.class)).toList();
    }

    @Transactional
    public MedicationDTO updateMedication(MedicationUpdateDTO dto) {
        boolean found = repository.existsById(dto.id());

        if (found) {
            MedicationEntity medicationEntity = objectMapper.convertValue(dto, MedicationEntity.class);
            medicationEntity = repository.save(medicationEntity);
            return objectMapper.convertValue(medicationEntity, MedicationDTO.class);
        }

        return null;
    }

    public void deleteMedication(UUID id) {
        repository.deleteById(id);
    }


}
