package com.dh.entrenador.service;

import com.dh.entrenador.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadoServiceImpl implements EntrenadorService{

    @Override
    public List<Entrenador> obtenerListaEntrenadores() {
        return Arrays.asList(new Entrenador("Juan"), new Entrenador("Camilo"));
    }
}
