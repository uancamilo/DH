package Presencial.dao;

import org.apache.log4j.Logger;
import Presencial.model.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicamentoDAOH2 implements IDao<Medicamento> {
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS " +
            "VALUES (?,?,?,?,?,?)";
    private static final Logger LOGGER= Logger.getLogger(MedicamentoDAOH2.class);
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        LOGGER.info("Inicio de operación de guardado de un medicamento");
        Connection connection=null;
        try{
            //conectarme a la base de datos
            connection=BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,medicamento.getId());
            psInsert.setInt(2,medicamento.getCodigo());
            psInsert.setString(3,medicamento.getNombre());
            psInsert.setString(4,medicamento.getLaboratorio());
            psInsert.setInt(5,medicamento.getCantidad());
            psInsert.setDouble(6,medicamento.getPrecio());
            psInsert.execute();
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
        return medicamento;
    }
}