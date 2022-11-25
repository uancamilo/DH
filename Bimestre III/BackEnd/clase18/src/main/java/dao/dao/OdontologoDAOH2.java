package dao.dao;
import dao.dao.BD;
import dao.dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);

    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";

    private static final String SQL_SELECT="SELECT * FROM ODONTOLOGOS WHERE ID=?";

    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Acá se guardan los datos del odontologo.");
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,odontologo.getMatricula());
            psInsert.setString(2,odontologo.getNombre());
            psInsert.setString(3,odontologo.getApellido());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        LOGGER.info("Estas buscando los datos de un odontologo con el ID: ");
        Connection connection = null;
        Odontologo odontologo = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psSelect=connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1, id);
            ResultSet rs = psSelect.executeQuery();
            while(rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarOdontologo() {
        LOGGER.info("Esta es la lista de los odontologos encontrados: ");
        Connection connection = null;
        List<Odontologo> odontologos= new ArrayList<>();
        Odontologo odontologo = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psSelectAll.executeQuery();
            while (rs.next()){
                odontologo= new Odontologo(rs.getInt(1), rs.getNString(2), rs.getString(3), rs.getString(4) );
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return odontologos;
    }
}
