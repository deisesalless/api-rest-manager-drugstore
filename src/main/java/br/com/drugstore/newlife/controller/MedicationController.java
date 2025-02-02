package br.com.drugstore.newlife.controller;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationCreatedDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.service.MedicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedio")
public class MedicationController {

    @Autowired
    private MedicationService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<MedicationCreatedDTO> create(@RequestBody @Valid MedicationCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMedication(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MedicationDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllMedications());
    }
}
