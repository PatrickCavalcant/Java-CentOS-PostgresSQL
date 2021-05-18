/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2;

/**
 *
 * @author Patrick Cavalcante Moraes
 */
public class Aula2 {

     public static void main(String[] args) {
      String driver = "org.postgresql.Driver";
      String usuario = "patrick";
      String senha = "123456";
      String url = "jdbc:postgresql://192.168.0.110/bancoteste";
      java.sql.Connection con = null;
      try {
         Class.forName(driver);
         con = (java.sql.Connection) java.sql.DriverManager.getConnection(url, usuario, senha);
         javax.swing.JOptionPane.showMessageDialog(null, "Conexão realizada!");
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      } catch (java.sql.SQLException e) {
         e.printStackTrace();
      }
		
      String query = "SELECT * FROM produtos";
		
      try{
         java.sql.Statement st  = con.createStatement();
         java.sql.ResultSet rst = st.executeQuery(query);
         int codigo;
         String descricao = null;
         double preco;
         while (rst.next()) {
            codigo = rst.getInt("codigo");
            descricao = rst.getString("descricao");
            preco = rst.getDouble("preco");
            System.out.println(codigo+" \t| "+preco+" \t| "+descricao);
         }
         st.close();
         con.close();
      } catch(java.sql.SQLException ex){
         ex.printStackTrace(); 
         javax.swing.JOptionPane.showMessageDialog(null,"Impossível inserir o registro!");
      }
    }
    
}
