package br.com.drugstore.newlife.controller;

import br.com.drugstore.newlife.dto.MedicationCreateDTO;
import br.com.drugstore.newlife.dto.MedicationCreatedDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remedio")
public class MedicationController {

    @PostMapping("/cadastrar")
    public MedicationCreatedDTO create(@RequestBody MedicationCreateDTO dto) {
        return null;
    }

    @GetMapping()
    public MedicationCreatedDTO findAll() {
        return null;
    }
}
