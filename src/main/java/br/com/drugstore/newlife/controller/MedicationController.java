package br.com.drugstore.newlife.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedio")
public class MedicationController {

    @PostMapping
    public void create(@RequestBody String json) {

    }
}
