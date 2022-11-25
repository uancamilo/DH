package test;

import dao.BD;
import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoServiceTest {

    @Test
    public void guardar(){

        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

        Odontologo odontologo = new Odontologo("272410", "Juan", "Serna");

        odontologoService.guardarOdontologo(odontologo);

    }

    @Test
    public void testBuscarTodos(){
        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

        List<Odontologo> odontologos=odontologoService.buscarOdontologos();

        Assertions.assertTrue(odontologos != null );
    }

}
