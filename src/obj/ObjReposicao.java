/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

/**
 *
 * @author 181710062
 */
public class ObjReposicao {

    public ObjReposicao() {
    }

    public ObjReposicao(String nome, String cor, int codigo, String data_de_vencimento) {
        this.nome = nome;
        this.cor = cor;
        this.codigo = codigo;
        this.data_de_vencimento = data_de_vencimento;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the data_de_vencimento
     */
    public String getData_de_vencimento() {
        return data_de_vencimento;
    }

    /**
     * @param data_de_vencimento the data_de_vencimento to set
     */
    public void setData_de_vencimento(String data_de_vencimento) {
        this.data_de_vencimento = data_de_vencimento;
    }
  private String nome;
  private String cor;
  private int codigo;
  private String data_de_vencimento;  
}
