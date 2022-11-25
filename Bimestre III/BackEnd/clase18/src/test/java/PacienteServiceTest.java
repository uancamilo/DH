import dao.BD;
import dao.PacienteDAOH2;
import model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.util.List;

public class PacienteServiceTest {
    @Test
    public void testBuscarTodos(){
        //dado
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService(new PacienteDAOH2());
        //cuando
        List<Paciente> pacientes=pacienteService.buscarPacientes();
        //entonces
        Assertions.assertEquals(2,pacientes.size());
    }
    @Test
    public void testBuscar(){
        //dado
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService(new PacienteDAOH2());
        Integer idBuscado=2;
        //cuando
        Paciente paciente=pacienteService.buscarPaciente(idBuscado);
        //entonces
        Assertions.assertTrue(paciente!=null);
        //comparado los nombres, te fijas si da Ezequiel
    }
}
