package Presencial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final String SQL_DROP_CREATE="DROP TABLE IF " +
            "EXISTS MEDICAMENTOS; CREATE TABLE MEDICAMENTOS (" +
            "ID INT PRIMARY KEY," +
            "CODIGO INT NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "LABORATORIO VARCHAR(100) NOT NULL," +
            "CANTIDAD INT NOT NULL," +
            "PRECIO NUMERIC(10,2) NOT NULL" +
            ")";
    //método para crea las tablas (drop-create)
    public static void crearTablas(){
        Connection connection=null;
        try{
            connection=getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    //método para conectarnos a la BD
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c4clase14",
                "sa","sa");
    }
}