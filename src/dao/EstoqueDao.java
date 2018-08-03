
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import obj.ObjEstoque;


public class EstoqueDao {
     public static void inserir(ObjEstoque cli) {
        String sql = "INSERT INTO estoque "
                + " ( nome, cor, codigo, data_de_vencimento ) "
                + "VALUES( "
                + " '" + cli.getNome()   + "' , "
                + " '" + cli.getCor()    + "' , "
                + " '" + cli.getCodigo() + "' , "
                + " " + cli.getData_de_vencimento() + " "
                + " );";        
        Conexao.executar(sql);
    }

    public static void editar(ObjEstoque cli) {
        String sql = "UPDATE clientes SET "
                + " nome = '" + cli.getNome() + "' , "
                + " cor = '" + cli.getCor() + "' , "
                + " codigo = '" + cli.getCodigo() + "' , "
                + " data_de_vencimento = '" + cli.getData_de_vencimento() + "' , "
                + "WHERE codigo = " + cli.getNome();        
        Conexao.executar(sql);
    }    

    public static void excluir(ObjEstoque cli) {
        String sql = "DELETE FROM estoque"
                + "WHERE codigo = " + cli.getNome();        
        Conexao.executar(sql);
    }
    
    public static List<ObjEstoque> getClientes() {
        List<ObjEstoque> lista = new ArrayList<>();
        //consulta em mais de uma tabela ao mesmo tempo pra buscar o nome da cidade pelo codCidade.
        //a primeira tabela declarada após o from(na consulta) é a da esquerda e a segunda é a da direita
        
        String sql = "SELECT c.nome, c.cor, c.codigo, c.data_de_vencimento , "
                + " c.nome, c.cor, c.codigo, c.data_de_vencimento  "
                + " FROM estoque c "
                + " WHERE c.tipo = '' "
                + " ORDER BY c.nome";

//ordenado pelo nome(ordem alfabetica)
        //inner join usado para consultas em mais de uma tabela buscando a intersecção das tabelas.
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            //o result set(rs) vai conter a "tabela" com as informações na ordem da consulta
            try {
                while (rs.next()) {
                    //o result set começa o array em 1
                    ObjEstoque cli = new ObjEstoque();
                    cli.setNome(rs.getString(3));
                    cli.setCor(rs.getString(5));
                    cli.setCodigo(rs.getString(6));
                    cli.setData_de_vencimento(rs.getString(7));

                    //criar um objeto cidade
                    ObjEstoque cid = new ObjEstoque();
                    cid.setNome(rs.getString(2));
                    cid.setCor(rs.getString(3));
                    cid.setCodigo(rs.getString(4));
                    cid.setData_de_vencimento(rs.getString(5));
                   

                    //adicionar o cliente na lista:
                    lista.add(cli);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                
            }
        }
        return lista;
        
    }

    public static Object getClienteByCodigo(int codigo) {
        Object cliente = null;
        
        String sql = "SELECT c.nome, c.nome, c.cor, c.cor , "
                + " c.codigo, c.data_de_vencimento "
                + " FROM clientes c "
                + " INNER JOIN cidades d ON c.codCidade = d.codigo "
                + " WHERE c.codigo = " + codigo
                + " ORDER BY c.nome ";        
        ResultSet rs = Conexao.consultar(sql);
        
        try {
            rs.first();
            ObjEstoque cidade = new ObjEstoque();
            cidade.setCodigo(rs.getString(2));
            cidade.setNome(rs.getString(4));
            
            String tipo = rs.getString(7);            
            if ( tipo.equals("") ) {
                ObjEstoque cli = new ObjEstoque();
                cli.setCodigo(rs.getString(1));
                cli.setNome(rs.getString(3));
                cli.setCor(rs.getString(5));
                cli.setCodigo(rs.getString(6));
               
                cli.setCidade(cidade);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return cliente;
        
    }
}
