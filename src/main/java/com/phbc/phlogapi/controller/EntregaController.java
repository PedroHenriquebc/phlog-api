package com.phbc.phlogapi.controller;

import com.phbc.phlogapi.domain.model.Entrega;
import com.phbc.phlogapi.domain.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entrega")
public class EntregaController {

    private EntregaService entregaService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Entrega solicitar(@RequestBody Entrega entrega) {
        return entregaService.solicitar(entrega);
    }
}
