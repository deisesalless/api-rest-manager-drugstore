package br.com.drugstore.newlife.controller;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationCreatedDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.dto.MedicationUpdateDTO;
import br.com.drugstore.newlife.service.MedicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/remedio")
public class MedicationController {

    @Autowired
    private MedicationService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<MedicationCreatedDTO> create(@RequestBody @Valid MedicationCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMedication(dto));
    }

    @GetMapping("/listar-medicamentos-ativos")
    public ResponseEntity<List<MedicationDTO>> findAllActiveMedications() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllActiveMedications());
    }

    @GetMapping("/listar-medicamentos-inativos")
    public ResponseEntity<List<MedicationDTO>> findAllSoftDeletedMedications() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllSoftDeletedMedications());
    }

    @PutMapping("/alterar")
    public ResponseEntity<Void> updateMedications(@RequestBody @Valid MedicationUpdateDTO dto) {
        service.updateMedication(dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/inativar/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable UUID id) {
        service.softDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/ativar/{id}")
    public ResponseEntity<Void> reactivate(@PathVariable UUID id) {
        service.reactivate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
