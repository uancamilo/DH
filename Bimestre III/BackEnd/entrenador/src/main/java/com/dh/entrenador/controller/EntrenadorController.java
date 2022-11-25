package com.dh.entrenador.controller;

import com.dh.entrenador.model.Entrenador;
import com.dh.entrenador.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    private EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<Entrenador> obtenerLista(){
    return entrenadorService.obtenerListaEntrenadores();
    }
}
