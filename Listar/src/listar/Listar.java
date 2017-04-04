/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author qw
 */
public class Listar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            String drive = "";
            String url = "";
            String user = "";
            String pass = "";
            // passo 1= carregar o driver
            Class.forName(drive);
            //passo2 = obeter a conexão
            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                //passo 3a= criar o comando sql
                String sql = "SELECT * FROM Cliente ORDER BY nomeCompletoCliente ASC";
                PreparedStatement stmt = conn.prepareStatement(sql);
                //passo 4 Executa query
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("nomeCompletoCliente") + rs.getString("recebeNewsLetter"));

                }

            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Acesso negado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Listar nomes
}
