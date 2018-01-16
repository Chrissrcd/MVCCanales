/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chris
 */
public class Controlador {

    public void cargar(DefaultTableModel model, int edad) throws SQLException {
        String[] titulos = {"IdCanal", "Nombre del Canal", "Tipo del Canal", "Nombre Programa", "Hora Inicio", "Hora Fin"};
        String[] registro = new String[6];
        String  sql1 = "SELECT * FROM canal";
        String  sql2 = "SELECT * FROM programa";
        model = new DefaultTableModel(null, titulos);
        Conexion cc = new Conexion();
        Connection cn = cc.conexionBD();
        
        Statement stC = cn.createStatement();
        ResultSet rsC = stC.executeQuery(sql1);
        Statement stP = cn.createStatement();
        ResultSet rsP = stP.executeQuery(sql2);
         
     }
    
}
