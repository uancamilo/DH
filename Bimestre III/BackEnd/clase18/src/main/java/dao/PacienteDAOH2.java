package dao;

import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    private static final Logger LOGGER= Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=?";
    @Override
    public Paciente guardar(Paciente paciente) {
        LOGGER.info("Iniciando el guardado del paciente con nombre="+paciente.getNombre());
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {
        LOGGER.info("Iniciando la búsqueda del paciente con id="+id);
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectOne=connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs=psSelectOne.executeQuery();
            DomicilioDAOH2 daoAux=new DomicilioDAOH2();
            while (rs.next()){
                //que tendria un rs común
                //(51,'Ezequiel','Baspineiro',871,'2022-11-2',2) <--- el último es FK
                domicilio=daoAux.buscar(rs.getInt(6));
                paciente=new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDate(5).toLocalDate(),domicilio);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;
    }
    @Override
    public void actualizar(Paciente paciente) {
        LOGGER.info("Iniciando la actualización del paciente con id="+paciente.getId());

    }

    @Override
    public void eliminar(Integer id) {
        LOGGER.info("Iniciando la eliminación del paciente con id="+id);
    }

    @Override
    public List<Paciente> buscarTodos() {
        LOGGER.info("Iniciando la búsqueda de todos los pacientes");
        Connection connection=null;
        List<Paciente> pacientes=new ArrayList<>();
        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectAll=connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs=psSelectAll.executeQuery();
            DomicilioDAOH2 daoAux=new DomicilioDAOH2();
            while (rs.next()){
                //que tendria un rs común
                //(51,'Ezequiel','Baspineiro',871,'2022-11-2',2) <--- el último es FK
                domicilio=daoAux.buscar(rs.getInt(6));
                paciente=new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDate(5).toLocalDate(),domicilio);
                pacientes.add(paciente);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return pacientes;
    }
}
