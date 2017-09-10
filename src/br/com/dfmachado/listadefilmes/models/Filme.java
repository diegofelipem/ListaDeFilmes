package br.com.dfmachado.listadefilmes.models;

import java.util.Date;

/**
 *
 * @author diego.felipe
 */
public class Filme {

    private int id;
    private String tituloOriginal;
    private String tituloTraduzido;
    private Date dataLancamento;
    private Status statusDownload;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTituloTraduzido() {
        return tituloTraduzido;
    }

    public void setTituloTraduzido(String tituloTraduzido) {
        this.tituloTraduzido = tituloTraduzido;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Status getStatusDownload() {
        return statusDownload;
    }

    public void setStatusDownload(Status statusDownload) {
        this.statusDownload = statusDownload;
    }
}
