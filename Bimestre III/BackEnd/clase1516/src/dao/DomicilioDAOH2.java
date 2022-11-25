package dao;

import model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio>{

    private static final Logger LOGGER = Logger.getLogger(DomicilioDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO DOMICILIOS (CALLE," +
            "NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?) ";

    private static final String SQL_SELECT= "SELECT * FROM DOMICILIO WHERE ID = ?";
    private static final String SQL_SELECT_ALL="SELECT * FROM DOMICILIOS";
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        LOGGER.info("Inicia la operación de guardado de domicilio.");
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,domicilio.getCalle());
            psInsert.setInt(2, domicilio.getNumero());
            psInsert.setString(3,domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                domicilio.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        LOGGER.info("Buscando un domicilios en la base datos con id " + id );
        Connection connection=null;
        Domicilio domicilio = null;
        try{
            connection = BD.getConnection();
            PreparedStatement psSelect=connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1, id);
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
            }
        } catch (Exception e){
            e.printStackTrace();

        }
        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public void actualizar(Domicilio domicilio) {
        LOGGER.info("Operación de actualización. ");
    }

    @Override
    public void eliminar(Integer id) {
        LOGGER.info("Operación eliminar elemento id = " + id );
    }

    @Override
    public List<Domicilio> buscarTodos() {
        LOGGER.info("Búsqueda de todos los domicilios");
        Connection connection=null;
        List<Domicilio> domicilios=new ArrayList<>();
        Domicilio domicilio=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelectAll=connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSelectAll.executeQuery();
            while(rs.next()){
                domicilio=new Domicilio(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getString(4),rs.getString(5));
                domicilios.add(domicilio);
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
        return domicilios;
    }
}
