package br.com.dfmachado.listadefilmes.views.ComponentsAndRenderers;

import br.com.dfmachado.listadefilmes.controllers.StatusController;
import br.com.dfmachado.listadefilmes.models.Status;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author diego.felipe
 */
public class StatusComboModel extends AbstractListModel implements ComboBoxModel {

    private final List<Status> status;
    private final StatusController controller = new StatusController();
    private Status selecao = null;

    public StatusComboModel() {
        this.status = this.controller.listAll();
        this.status.add(null);
    }

    @Override
    public int getSize() {
        return this.status.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.status.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selecao = (Status) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selecao;
    }
}
