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
public class StatusModel {

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet r = null;

    public List<Status> listAll() {
        String sql = "select id,descricao from status_filme";
        List<Status> lista = new ArrayList<>();

        try {
            this.conn = ConnFactory.createConnection();
            this.pstm = this.conn.prepareStatement(sql);
            this.r = this.pstm.executeQuery();
            while (this.r.next()) {
                Status status = new Status();
                status.setId(this.r.getInt("id"));
                status.setDescricao(this.r.getString("descricao"));
                lista.add(status);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
             throw new GenericCustomException(ex);
            
        } finally {
            this.fecharRecursos();
        }
        return lista;
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
