package br.com.drugstore.newlife.controller;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationCreatedDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.dto.MedicationUpdateDTO;
import br.com.drugstore.newlife.service.MedicationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.yaml.snakeyaml.events.Event;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/remedios")
public class MedicationController {

    @Autowired
    private MedicationService service;

    @PostMapping
    public ResponseEntity<MedicationCreatedDTO> create(@RequestBody @Valid MedicationCreateDTO dto) {
        MedicationCreatedDTO createdMedication = service.saveMedication(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdMedication.id()).toUri();

        return ResponseEntity.created(location).body(createdMedication);
    }

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> findAll(@RequestParam(required = false) Boolean active) {
        return ResponseEntity.ok(service.findAllMedications(active));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMedications(@PathVariable UUID id, @RequestBody @Valid MedicationUpdateDTO dto) {
        service.updateMedication(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable UUID id, @RequestParam boolean active) {
        service.updateStatus(id, active);
        return ResponseEntity.noContent().build();
    }
}
