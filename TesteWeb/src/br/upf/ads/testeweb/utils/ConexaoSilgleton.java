package br.upf.ads.testeweb.utils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class ConexaoSilgleton {
    
    private Connection con;

    public Connection getCon() {
        return con;
    }
  
    private ConexaoSilgleton() {
        try {
            // 1) registrar a classe do driver
            Class.forName("org.postgresql.Driver");
            // 2) Definir a URL JDBC
            String url = "jdbc:postgresql://localhost:5432/teste";
            // 3) Obter a conexão com o BD
            con = DriverManager.getConnection(url, "postgres", "masterkey");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public static ConexaoSilgleton getInstance() {
        return ConexaoSilgletonHolder.INSTANCE;
    }
    
    private static class ConexaoSilgletonHolder {

        private static final ConexaoSilgleton INSTANCE = new ConexaoSilgleton();
    }
}
