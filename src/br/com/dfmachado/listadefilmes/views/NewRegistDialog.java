package br.com.dfmachado.listadefilmes.views;

import br.com.dfmachado.listadefilmes.models.Filme;
import br.com.dfmachado.listadefilmes.models.Status;
import br.com.dfmachado.listadefilmes.views.ComponentsAndRenderers.GenericComboRenderer;
import br.com.dfmachado.listadefilmes.views.ComponentsAndRenderers.StatusComboModel;
import br.com.dfmachado.listadefilmes.views.utils.FixedLengthDocument;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author diego.felipe
 */
public class NewRegistDialog extends JDialog {

    private boolean success;
    private Filme filme;

    public NewRegistDialog(java.awt.Frame parent, boolean isModal) {
        super(parent, isModal);
        this.success = false;
        initComponents();
        this.txt_date.setDocument(new FixedLengthDocument(10));
    }

    public boolean isSuccess() {
        return this.success;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titOrig = new javax.swing.JLabel();
        txt_titOrig = new javax.swing.JTextField();
        txt_titTrad = new javax.swing.JTextField();
        lb_titTrad = new javax.swing.JLabel();
        lb_dtLanc = new javax.swing.JLabel();
        lb_Status = new javax.swing.JLabel();
        ComboStatus = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        txt_date = new javax.swing.JTextField();
        lb_warnning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Filme");
        setIconImage(null);
        setModal(true);
        setName("cadastroDialog"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(450, 300));

        lb_titOrig.setText("Título Original:");

        lb_titTrad.setText("Titulo Traduzido:");

        lb_dtLanc.setText("Data de Lançamento:");

        lb_Status.setText("Status:");

        ComboStatus.setModel(new StatusComboModel());
        ComboStatus.setRenderer(new GenericComboRenderer());

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txt_date.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lb_warnning.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_titOrig)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lb_titTrad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_titTrad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                            .addComponent(txt_titOrig))
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_dtLanc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_date))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_Status))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lb_warnning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lb_titOrig)
                .addGap(3, 3, 3)
                .addComponent(txt_titOrig, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lb_titTrad)
                .addGap(3, 3, 3)
                .addComponent(txt_titTrad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dtLanc)
                    .addComponent(lb_Status))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(lb_warnning))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String tituloOrig = this.txt_titOrig.getText(), tituloTrad = this.txt_titTrad.getText(),
                srtDate = this.txt_date.getText();
        Date date;
        Status status = (Status) this.ComboStatus.getSelectedItem();
        this.filme = new Filme();

        if (srtDate.isEmpty() || tituloOrig.isEmpty() || tituloTrad.isEmpty() || status == null) {
            lb_warnning.setText("Alguns campos não foram preenchidos");
        } else if (!isDateValid(this.txt_date.getText())) {
            lb_warnning.setText("Data inválida!");
            txt_date.requestFocus();
            txt_date.setText(null);

        } else {
            try {
                lb_warnning.setText(null);
                date = new SimpleDateFormat("dd/MM/yyyy").parse(srtDate);
                filme.setTituloOriginal(tituloOrig);
                filme.setTituloTraduzido(tituloTrad);
                filme.setDataLancamento(date);
                filme.setStatusDownload(status);
                this.success = true;
                this.dispose();
            } catch (ParseException ex) {
                //Exceção checada já tratada no metodo isDateValid()
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private static boolean isDateValid(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dt;
        GregorianCalendar cal = new GregorianCalendar();
        cal.getTimeInMillis();
        try {
            dt = sdf.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getClass() + "-" + e.getMessage());
            return false;
        }
        return sdf.format(dt).equals(date);
    }

    public Filme getFilmeCadastrado() {
        return this.filme;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboStatus;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel lb_Status;
    private javax.swing.JLabel lb_dtLanc;
    private javax.swing.JLabel lb_titOrig;
    private javax.swing.JLabel lb_titTrad;
    private javax.swing.JLabel lb_warnning;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_titOrig;
    private javax.swing.JTextField txt_titTrad;
    // End of variables declaration//GEN-END:variables
}
