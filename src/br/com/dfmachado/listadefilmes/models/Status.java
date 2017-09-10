package br.com.dfmachado.listadefilmes.models;

/**
 *
 * @author diego.felipe
 */
public class Status {

    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
