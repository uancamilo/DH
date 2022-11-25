package Presencial;

import java.sql.*;

public class Cliente {
    private static final String SQL_DROP_CREATE="DROP " +
            "TABLE IF EXISTS CUENTAS; CREATE TABLE " +
            "CUENTAS (ID INT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "NUMERO_CUENTA INT NOT NULL," +
            "SALDO NUMERIC(10,2) NOT NULL" +
            ")";
    // EJEMPLO DE NUMERIC(10,2)
    // 78452168,59
    private static final String SQL_INSERT="INSERT INTO" +
            " CUENTAS VALUES (?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE CUENTAS " +
            " SET SALDO=? WHERE ID=?";
    private static final String SQL_SELECT="SELECT * FROM " +
            "CUENTAS";

    public static void main(String[] args) {
        Connection connection=null;
        try{
            //conectarme a la base
            connection=getConnection();
            //crear la tabla
            Statement statement=connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            //insertar una fila
            //atención
            PreparedStatement psInsert=connection.prepareStatement(SQL_INSERT);
            //debemos cargar todos los ? en la declaración
            psInsert.setInt(1,1);
            psInsert.setString(2,"Rodolfo");
            psInsert.setInt(3,985451);
            psInsert.setDouble(4,250);
            psInsert.execute();

            //actualizar el saldo+10
            PreparedStatement psUpdate=connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1,250+10);
            psUpdate.setInt(2,1);
            psUpdate.execute();

            //crear la transacción para actualizar el saldo+10+15
            connection.setAutoCommit(false);
            PreparedStatement psUpdateTx= connection.prepareStatement(SQL_UPDATE);
            psUpdateTx.setDouble(1,250+10+15);
            psUpdateTx.setInt(2,1);
            psUpdateTx.execute();
            //varias cosas
            //generar una excepción para ver el proceso
            int x=4/0;
            connection.commit();
            //con el commit, guardamos efectivamente los cambios
            //buena costumbre, es solamente para volver al estado "normal" *sin tx*
            connection.setAutoCommit(true);
            //tengamos más SQL y ejecucción y las mismas no deberían ser txs



        }
        catch (Exception e){
            try {
                connection.rollback();
            } catch (SQLException exe) {
                exe.printStackTrace();
            }
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

        //en otro try, usar el select y mostrar el valor final de la fila
        try{
            connection=getConnection();
            //mostrar la tabla con el SELECT
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+
                        " - Saldo: "+rs.getDouble(4));
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
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c4clase13",
                "sa","sa");
    }
}