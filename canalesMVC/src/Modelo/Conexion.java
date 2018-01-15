package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    //------Atributos de la clase----------
    String jdbcDriver = ("com.mysql.jdbc.Driver");//drivers
    String jdbcSup = ("mysql");//base de datos
    String jdbcHost = ("localhost");//servidor
    String jdbcBd = ("canal");//nombre de la base de datos //no se si es de poner PersonaMVC
    String jdbcUser = ("root");//usuario
    String jdbcPwd = ("123456789");//pongo mi clave
    Connection con = null;

    public Conexion() {
    }

    public Connection conexionBD() {

        try {
            Class.forName(jdbcDriver);
            String strcon = "jdbc:" + jdbcSup + "://" + jdbcHost + "/" + jdbcBd;
            con = DriverManager.getConnection(strcon, jdbcUser, jdbcPwd);
            System.out.println("Conexion Existosa");
            return con;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "mensaje fallo conexion", JOptionPane.ERROR_MESSAGE);
            System.out.println("Driver Incorrectro" + ex.getMessage());
            return null;
        } catch (SQLException exsql) {
            JOptionPane.showMessageDialog(null, exsql.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("BDD INCORRECTA" + exsql.getMessage());
            return null;
        }
    }

    public void mensaje() {
        JOptionPane.showMessageDialog(null, "mensaje", "contenido", 3);
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
