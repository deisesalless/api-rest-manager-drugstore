package br.com.drugstore.newlife.controller;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationDTO;
import br.com.drugstore.newlife.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remedio")
public class MedicationController {

    @Autowired
    private MedicationService service;

    @PostMapping("/cadastrar")
    public MedicationDTO create(@RequestBody MedicationCreateDTO dto) {
        return service.saveMedication(dto);
    }

    @GetMapping()
    public MedicationDTO findAll() {
        return null;
    }
}
