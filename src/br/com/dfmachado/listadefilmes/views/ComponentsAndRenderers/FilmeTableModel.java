package br.com.dfmachado.listadefilmes.views.ComponentsAndRenderers;

import br.com.dfmachado.listadefilmes.controllers.FilmeController;
import br.com.dfmachado.listadefilmes.exceptions.GenericCustomException;
import br.com.dfmachado.listadefilmes.models.Filme;
import br.com.dfmachado.listadefilmes.models.Status;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego.felipe
 */
public class FilmeTableModel extends AbstractTableModel {

    private final List<Filme> filmes;
    private final FilmeController controller;
    private final String[] colunas = {"Nº", "Titulo Original", "Titulo Traduzido", "Lançamento", "Status"};
    private final boolean[] canEdit = {false, true, true, true, true};

    public FilmeTableModel() {
        this.controller = new FilmeController();
        this.filmes = controller.listAll();
    }

    public FilmeTableModel(Status status) {
        this.controller = new FilmeController();
        this.filmes = controller.findByStatus(status);

    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return this.canEdit[column];
    }

    //total de linhas a partir do total de itens na list
    @Override
    public int getRowCount() {
        return filmes.size();
    }

    //total de colunas da table
    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    //retorna o nome da coluna, ao ser informado o indice
    @Override
    public String getColumnName(int num) {
        return this.colunas[num];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return super.getColumnClass(columnIndex);
            case 4:
                return Status.class;
            default:
                throw new GenericCustomException("Coluna invalida");
        }
    }

    //Responsavel por cruzar as linhas com as suas respectivas colunas
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filme filme = this.filmes.get(rowIndex);
        Object retorno = null;
        switch (columnIndex) {
            case 0:
                retorno = rowIndex + 1;
                break;
            case 1:
                retorno = filme.getTituloOriginal();
                break;
            case 2:
                retorno = filme.getTituloTraduzido();
                break;
            case 3:
                retorno = filme.getDataLancamento();
                break;
            case 4:
                retorno = filme.getStatusDownload();
        }
        return retorno;
    }

    //Metodo que atualiza os dados das celulas editaveis da jtable
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Filme filme = this.filmes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                break;
            case 1:
                String str_Orig = (String) aValue;
                filme.setTituloOriginal(str_Orig);
                break;
            case 2:
                String str_Trad = (String) aValue;
                filme.setTituloTraduzido(str_Trad);
                break;
            case 3:
                String str_data = aValue.toString();
                 {
                    try {
                        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(str_data);
                        filme.setDataLancamento(data);
                    } catch (ParseException ex) {
                        throw new GenericCustomException(ex);
                    }
                }
                break;
            case 4:
                Status s = (Status) aValue;
                filme.setStatusDownload(s);
        }
        this.controller.update(filme);//atualiza o objeto no banco de dados
        
        this.fireTableCellUpdated(rowIndex, columnIndex);//dispara a atualizacao da celula
    }

    //retorna o indice do objeto na lista
    private int indexOf(Filme filme) {
        return this.filmes.indexOf(filme);
    }

    public void AddRow(Filme filme) {
        this.controller.insert(filme);
        this.filmes.add(filme);
        super.fireTableRowsInserted(indexOf(filme), indexOf(filme));

    }

    public void removeRow(int linha) {
        Filme filme = this.filmes.get(linha);
        this.controller.delete(filme);
        this.filmes.remove(linha);
        super.fireTableRowsDeleted(linha, linha);
    }  
}
