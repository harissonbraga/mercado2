
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
               + " perecivel = " + est.Data_de_vencimento()                 + " , " 
               + " codCategoria = " + pro.getCategoria().getCodigo() + " " 
               + "WHERE codigo = " + est.getCodigo();   
       Conexao.executar(sql);
   }      
       public static void excluir (ObjProduto pro){
       String sql = "DELETE FROM produtos"
               + "WHERE codigo = " + pro.getCodigo();   
       Conexao.executar(sql);
}
       
       
       public static List<ObjProduto> getProdutos(){
    List<ObjProduto> lista = new ArrayList<>();
   
    String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome , "
            + " c.preco, c.quantidade, c.perecivel"
            + " FROM produtos c "
            + " INNER JOIN cidades d ON c.codCategoria = d.codigo "
            + " ORDER BY c.nome";
    

           ResultSet rs = Conexao.consultar(sql);
    if (rs != null){
       
        try {
            while (rs.next()) {       
               
               ObjProduto pro = new ObjProduto();
               pro.setCodigo(rs.getInt(1));
               pro.setNome(rs.getString(3));
               pro.setPreco(rs.getDouble(5));
               pro.setQuantidade(rs.getDouble(6));
               pro.setPerecivel(rs.getBoolean(7));
               
               
               
               ObjCategoria cat = new ObjCategoria();
               cat.setCodigo(rs.getInt(2));
               cat.setNome(rs.getString(4));
               
               pro.setCategoria(cat);
               
               lista.add(pro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }
    return lista;
    
}
}
