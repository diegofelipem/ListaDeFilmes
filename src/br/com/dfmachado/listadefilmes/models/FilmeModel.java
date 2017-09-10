package br.com.dfmachado.listadefilmes.models;

import br.com.dfmachado.listadefilmes.exceptions.GenericCustomException;
import br.com.dfmachado.listadefilmes.models.connection.ConnFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego.felipe
 */
public class FilmeModel {

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet r = null;

    public void insert(Filme filme) {
        String sql = "insert into filme(titulo_original, titulo_traduzido, data, status) "
                + "values (?,?,?,?)";
        try {
            this.conn = ConnFactory.createConnection();
            this.pstm = this.conn.prepareStatement(sql);

            this.pstm.setString(1, filme.getTituloOriginal());
            this.pstm.setString(2, filme.getTituloTraduzido());
            this.pstm.setDate(3, new java.sql.Date(filme.getDataLancamento().getTime()));
            this.pstm.setInt(4, filme.getStatusDownload().getId());
            this.pstm.executeUpdate();

        } catch (SQLException ex) {
            throw new GenericCustomException(ex);
        } finally {
            this.fecharRecursos();
        }
    }

    public void update(Filme filme) {
        String sql = "update filme set "
                + "titulo_original = ?, titulo_traduzido = ?, data = ?, status = ? "
                + "where id = ?";
        try {
            this.conn = ConnFactory.createConnection();
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setString(1, filme.getTituloOriginal());
            this.pstm.setString(2, filme.getTituloTraduzido());
            this.pstm.setDate(3, new java.sql.Date(filme.getDataLancamento().getTime()));
            this.pstm.setInt(4, filme.getStatusDownload().getId());
            this.pstm.setInt(5, filme.getId());
            this.pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new GenericCustomException(ex);
        } finally {
            this.fecharRecursos();
        }
    }

    public void delete(Filme filme) {
        String sql = "delete from filme where id = ?";

        try {
            this.conn = ConnFactory.createConnection();
            this.pstm = conn.prepareStatement(sql);
            this.pstm.setInt(1, filme.getId());
            this.pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new GenericCustomException(ex);
        } finally {
            this.fecharRecursos();
        }
    }

    public Filme findById(int id) {
        String sql = "select filme.id, titulo_original, titulo_traduzido, data,status, status_filme.descricao from filme "
                + "inner join status_filme on status_filme.id = filme.status "
                + "where filme.id = ?";
        Filme filme = null;
        try {
            this.conn = ConnFactory.createConnection();
            this.pstm = this.conn.prepareStatement(sql);
            this.pstm.setInt(1, id);
            this.r = this.pstm.executeQuery();
            while (this.r.next()) {
                filme = fillFilmeWithResultSet(this.r);
                break;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new GenericCustomException(ex);
        } finally {
            this.fecharRecursos();
        }
        return filme;
    }

    public List<Filme> findByStatus(Status status) {
        String sql = "select filme.id, titulo_original, titulo_traduzido, data,status, status_filme.descricao from filme "
                + "inner join status_filme on status_filme.id = filme.status "
                + "where filme.status = ?";
        List<Filme> lista = new ArrayList<>();
        try {
            this.conn = ConnFactory.createConnection();
            this.pstm = this.conn.prepareStatement(sql);
            this.pstm.setInt(1, status.getId());
            this.r = this.pstm.executeQuery();
            while (this.r.next()) {
                Filme filme = this.fillFilmeWithResultSet(this.r);
                lista.add(filme);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new GenericCustomException(ex);
        } finally {
            this.fecharRecursos();
        }
        return lista;
    }

    public List<Filme> listFilmes() {
        String sql = "select filme.id, titulo_original, titulo_traduzido, data,status, status_filme.descricao from filme "
                + "inner join status_filme on status_filme.id = filme.status order by data asc";
        List<Filme> lista = new ArrayList<>();
        try {
            this.conn = ConnFactory.createConnection();
            this.pstm = this.conn.prepareStatement(sql);
            this.r = this.pstm.executeQuery();
            while (this.r.next()) {
                Filme filme = this.fillFilmeWithResultSet(this.r);
                lista.add(filme);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new GenericCustomException(ex);
        } finally {
            this.fecharRecursos();
        }
        return lista;
    }

    private Filme fillFilmeWithResultSet(ResultSet res) throws SQLException {
        Filme filme = new Filme();
        Status status = new Status();
        filme.setId(res.getInt("id"));
        filme.setTituloOriginal(res.getString("titulo_original"));
        filme.setTituloTraduzido(res.getString("titulo_traduzido"));
        filme.setDataLancamento(res.getDate("data"));
        status.setId(res.getInt("status"));
        status.setDescricao(res.getString("descricao"));
        filme.setStatusDownload(status);
        return filme;
    }

    private void fecharRecursos() {
        try {
            ConnFactory.closeConnection(conn, pstm, r);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new GenericCustomException(ex);
        }
    }
}
