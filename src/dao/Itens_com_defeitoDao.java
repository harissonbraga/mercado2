package dao;

import obj.ObjEstoque;

public class Itens_com_defeitoDao {

    public static void inserir(ObjEstoque est) {
        String sql = "INSERT INTO estoque "
                + " ( nome, cor, codigo, data de vencimento ) "
                + " VALUES ( "
                + "  '" + est.getNome() + "' , "
                + "  '" + est.getCor() + "' , "
                + "  '" + est.getCodigo() + "' , "
                + "  '" + est.getData_de_vencimento() + "    "
                + " );";
        Conexao.executar(sql);
    }

    public static void editar(ObjEstoque est) {
        String sql = "UPDATE estoque SET "
                + " nome =      '" + est.getNome() + "' , "
                + " cor =  '" + est.getCor() + "' , "
                + " codigo =  '" + est.getCodigo() + "' , "
                + " data de vencimento =      '" + est.getData_de_vencimento() + "    "
                + " WHERE codigo = " + est.getCodigo();
        Conexao.executar(sql);
    }

    public static void excluir(ObjEstoque est) {
        String sql = "DELETE FROM estoque "
                +   " WHERE codigo = " + est.getCodigo();
        Conexao.executar(sql);
    }
}
