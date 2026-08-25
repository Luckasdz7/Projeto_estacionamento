/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Conexao {
     public Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/estacionamento";
        String usuario = "root";
        String senha = "123456";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
           // JOptionPane.showMessageDialog(null, "Conectador com sucesso!"); 
            return conexao;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar tente novamente");
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            return null;
        }
    }
}
