package br.com.dfmachado.listadefilmes.controllers;

import br.com.dfmachado.listadefilmes.models.Status;
import br.com.dfmachado.listadefilmes.models.StatusModel;
import java.util.List;

/**
 *
 * @author diego.felipe
 */
public class StatusController {

    private final StatusModel model;

    public StatusController() {
        this.model = new StatusModel();
    }

    public List<Status> listAll() {
        return this.model.listAll();
    }
}
