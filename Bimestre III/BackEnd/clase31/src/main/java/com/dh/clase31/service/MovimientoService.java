package com.dh.clase31.service;

import com.dh.clase31.entity.Movimiento;
import com.dh.clase31.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
private MovimientoRepository movimientoRepository;
    @Autowired

    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public Movimiento guardarMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }
    public List<Movimiento> listarMovimientos(){
        return movimientoRepository.findAll();
    }
    public Optional<Movimiento> buscarMovimiento (Integer id){
        return movimientoRepository.findById(id);
    }
    public void actualizarMovimiento(Movimiento movimiento){
        movimientoRepository.save(movimiento);
    }
}
