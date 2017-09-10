package br.com.dfmachado.listadefilmes.views.ComponentsAndRenderers;

import br.com.dfmachado.listadefilmes.models.Status;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author diego.felipe
 */
public class StatusCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {

    private Status status;

    @Override
    public Object getCellEditorValue() {
        return this.status;
    }

    @Override
    public boolean stopCellEditing() {
        super.cancelCellEditing();
        return true;
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        super.isCellEditable(e);
        if (e instanceof MouseEvent) {
            MouseEvent evt = (MouseEvent) e;
            return evt.getClickCount() >= 2;
        }
        return true;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.status = (Status) value;
        JComboBox comboStatus = new JComboBox(new StatusComboModel());
        comboStatus.setRenderer(new GenericComboRenderer());
        comboStatus.setSelectedItem(this.status);
        comboStatus.addActionListener(this);
        comboStatus.addKeyListener(this.getEnterKey());
        return comboStatus;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JComboBox<Status> comboStatus = (JComboBox<Status>) evt.getSource();
        this.status = (Status) comboStatus.getSelectedItem();
    }
    
    public KeyListener getEnterKey() {
        KeyAdapter adapter = new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    fireEditingStopped();
                }
            }
        };
        return adapter;
    }
}
