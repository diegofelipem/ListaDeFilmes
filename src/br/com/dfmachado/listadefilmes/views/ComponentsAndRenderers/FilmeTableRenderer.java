package br.com.dfmachado.listadefilmes.views.ComponentsAndRenderers;

import br.com.dfmachado.listadefilmes.models.Status;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author diego.felipe
 */
public class FilmeTableRenderer extends DefaultTableCellRenderer {

    private DateFormat formatter;
    private final int NUMERACAO = 0;
    private final int DATA = 3;
    private final int STATUS = 4;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        switch (column) {
            case DATA:
                formatter = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("pt", "BR"));
                setText(formatter.format(value));
                setHorizontalAlignment(SwingConstants.CENTER);
                //exibe descricao na coluna de status
                break;
            case STATUS:
                Status s = (Status) value;
                setText(s.getDescricao());
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case NUMERACAO:
                setFont(new Font(null, 0, 12));
                setHorizontalAlignment(SwingConstants.RIGHT);
                setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                break;
            default:
                break;
        }
        return this;
    }
}
