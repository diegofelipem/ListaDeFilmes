package br.com.dfmachado.listadefilmes.controllers;

import br.com.dfmachado.listadefilmes.models.Filme;
import br.com.dfmachado.listadefilmes.models.FilmeModel;
import br.com.dfmachado.listadefilmes.models.Status;
import java.util.List;

/**
 *
 * @author diego.felipe
 */
public class FilmeController {

    private final FilmeModel model;

    public FilmeController() {
        this.model = new FilmeModel();
    }

    public void insert(Filme filme) {
        this.model.insert(filme);
    }

    public void update(Filme filme) {
        this.model.update(filme);
    }

    public void delete(Filme filme) {
        this.model.delete(filme);
    }

    public Filme findById(int id) {
        return this.model.findById(id);
    }

    public List<Filme> findByStatus(Status status) {
        return this.model.findByStatus(status);
    }

    public List<Filme> listAll() {
        return this.model.listFilmes();
    }
}
