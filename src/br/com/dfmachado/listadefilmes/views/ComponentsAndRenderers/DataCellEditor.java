package br.com.dfmachado.listadefilmes.views.ComponentsAndRenderers;

import br.com.dfmachado.listadefilmes.views.utils.FixedLengthDocument;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.EventObject;
import java.util.Locale;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author diego.felipe
 */
public class DataCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {

    private String DataLancamento;
    private DateFormat formatter;

    @Override
    public Object getCellEditorValue() {
        return this.DataLancamento;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        formatter = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("pt", "BR"));
        this.DataLancamento = formatter.format(value);
        JTextField txtField = new JTextField();
        txtField.setDocument(new FixedLengthDocument(10));
        txtField.setText(this.DataLancamento);
        txtField.addActionListener(this);
        txtField.addKeyListener(this.getEnterKey());
        return txtField;
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        if (e instanceof MouseEvent) {
            MouseEvent evt = (MouseEvent) e;
            return evt.getClickCount() >= 2;
        }
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        super.cancelCellEditing();
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField txtField = (JTextField) e.getSource();
        this.DataLancamento = txtField.getText();
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
