/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import obj.ObjReposicao;

public class ReposicaoDao {
     /**
     *
     * @param est
     */
    public static void inserir (ObjReposicao est){
       String sql = "INSERT INTO reposicao "
               + " ( nome, cor, codigo, data_de_vencimento ) "
               + "VALUES( "
               + " '" + est.getNome()                 + "' , " 
               + " " + est.getCor()                   + " , " 
               + " " + est.getCodigo()                + " , " 
               + " " + est.getData_de_vencimento()    + "  " 
               + " );";   
       Conexao.executar(sql);
   }
     
     
     
      public static void editar (ObjReposicao est){
       String sql = "UPDATE reposicao SET "
        
               + " nome = '" + est.getNome()                         + "' , " 
               + " preco = " + est.getCor()                        + " , " 
               + " quantidade = " + est.getCodigo()              + " , " 
               + " perecivel = " + est.getData_de_vencimento()                 + " , " 

               + "WHERE codigo = " + est.getCodigo();   
       Conexao.executar(sql);
   }      
       public static void excluir (ObjReposicao est){
       String sql = "DELETE FROM reposicao"
               + "WHERE codigo = " + est.getCodigo();   
       Conexao.executar(sql);
}
       
       
       public static List<ObjReposicao> getEncomendas(){
    List<ObjReposicao> lista = new ArrayList<>();
   
    String sql = "SELECT nome, cor, codigo, data_de_vencimento FROM TABLE reposicao";
  
           

           ResultSet rs = Conexao.consultar(sql);
    if (rs != null){
       
        try {
            while (rs.next()) {       
               
               ObjReposicao est = new ObjReposicao();
               est.setNome(rs.getString(1));
               est.setCor(rs.getString(3));
               est.setCodigo(rs.getInt(5));
               est.setData_de_vencimento(rs.getString(6));
               
               
               
               
               
               
               lista.add(est);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }
    return lista;
    
}
    
}
