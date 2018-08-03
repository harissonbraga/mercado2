
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import obj.ObjEstoque;


public class EstoqueDao {

    /**
     *
     * @param est
     */
    public static void inserir (ObjEstoque est){
       String sql = "INSERT INTO estoque "
               + " ( nome, cor, codigo, data_de_vencimento ) "
               + "VALUES( "
               + " '" + est.getNome()                 + "' , " 
               + " " + est.getCor()                   + " , " 
               + " " + est.getCodigo()                + " , " 
               + " " + est.getData_de_vencimento()    + "  " 
               + " );";   
       Conexao.executar(sql);
   }
     
     
     
      public static void editar (ObjEstoque est){
       String sql = "UPDATE estoque SET "
        
               + " nome = '" + est.getNome()                         + "' , " 
               + " preco = " + est.getCor()                        + " , " 
               + " quantidade = " + est.getCodigo()              + " , " 
               + " perecivel = " + est.getData_de_vencimento()                 + " , " 

               + "WHERE codigo = " + est.getCodigo();   
       Conexao.executar(sql);
   }      
       public static void excluir (ObjEstoque est){
       String sql = "DELETE FROM estoque"
               + "WHERE codigo = " + est.getCodigo();   
       Conexao.executar(sql);
}
       
       
       public static List<ObjEstoque> getEstoques(){
    List<ObjEstoque> lista = new ArrayList<>();
   
    String sql = "SELECT nome, cor, codigo, data_de_vencimento FROM TABLE estoque";
  
           

           ResultSet rs = Conexao.consultar(sql);
    if (rs != null){
       
        try {
            while (rs.next()) {       
               
               ObjEstoque est = new ObjEstoque();
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
