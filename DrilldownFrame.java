package hugosql.drilldownnn;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Victor Hugo Silva Blancas
 */
public class DrilldownFrame extends javax.swing.JFrame {
    private Drilldown dd;

    /** Creates new form DrilldownFrame */
    public DrilldownFrame() {
        initComponents();
        setLocation(300,100);
        
        dd=new Drilldown();
        dd.AgrupaPaises(false);
        dd.CargaMicros(false);
        
        PonListas();
        PonTabla();
    }
    private void PonTabla() {
        tablaciudades.setModel(new DefaultTableModel(
                dd.TablaPaises(),
                dd.Cabeza
            ));
        for (int i=0;i<dd.Cabeza.length;i++) {
            setModeloColumn(tablaciudades.getColumnModel().getColumn(i),50,false,false);
        }
        tablamicros.setModel(new DefaultTableModel(
                dd.TablaMicros(filtro.getText()),
                dd.CabezaMicros
            ));
        setModeloColumn(tablamicros.getColumnModel().getColumn(0),50,true,false);
        setModeloColumn(tablamicros.getColumnModel().getColumn(1),250,false,false);
    }
    private void PonListas() {
        tablaciudades.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pTodo = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pMicroeconomicos = new javax.swing.JPanel();
        filtroLb = new javax.swing.JLabel();
        filtro = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablamicros = new javax.swing.JTable();
        pCiudades = new javax.swing.JPanel();
        ciudadesLb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaciudades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Drill-Down con Neural-Network");

        pTodo.setBackground(new java.awt.Color(102, 0, 102));

        filtroLb.setText("Filtro por Indicador");

        filtro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filtroFocusGained(evt);
            }
        });
        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroKeyPressed(evt);
            }
        });

        tablamicros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablamicros);

        javax.swing.GroupLayout pMicroeconomicosLayout = new javax.swing.GroupLayout(pMicroeconomicos);
        pMicroeconomicos.setLayout(pMicroeconomicosLayout);
        pMicroeconomicosLayout.setHorizontalGroup(
            pMicroeconomicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMicroeconomicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMicroeconomicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addGroup(pMicroeconomicosLayout.createSequentialGroup()
                        .addComponent(filtroLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pMicroeconomicosLayout.setVerticalGroup(
            pMicroeconomicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMicroeconomicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMicroeconomicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroLb)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Microeconómicos", pMicroeconomicos);

        ciudadesLb.setText("a) Sólo países > 1 millón, b) Click para ver la ciudad más poblada, c) F(pais,población,max(ciudad))");

        tablaciudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaciudades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaciudadesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaciudades);

        javax.swing.GroupLayout pCiudadesLayout = new javax.swing.GroupLayout(pCiudades);
        pCiudades.setLayout(pCiudadesLayout);
        pCiudadesLayout.setHorizontalGroup(
            pCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCiudadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pCiudadesLayout.createSequentialGroup()
                        .addComponent(ciudadesLb)
                        .addGap(0, 161, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pCiudadesLayout.setVerticalGroup(
            pCiudadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCiudadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ciudadesLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ciudades", pCiudades);

        javax.swing.GroupLayout pTodoLayout = new javax.swing.GroupLayout(pTodo);
        pTodo.setLayout(pTodoLayout);
        pTodoLayout.setHorizontalGroup(
            pTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTodoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        pTodoLayout.setVerticalGroup(
            pTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTodoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("DD Ciudades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaciudadesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaciudadesMouseReleased
        int r=tablaciudades.getSelectedColumn();
        String acodigo=tablaciudades.getColumnName(r);
        new Mensaje(Ciudadesdata.getMaximaCiudad(acodigo)).setVisible(true);
    }//GEN-LAST:event_tablaciudadesMouseReleased

    private void filtroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filtroFocusGained
        filtro.selectAll();
    }//GEN-LAST:event_filtroFocusGained

    private void filtroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            PonTabla();
        }
    }//GEN-LAST:event_filtroKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ciudadesLb;
    private javax.swing.JTextField filtro;
    private javax.swing.JLabel filtroLb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pCiudades;
    private javax.swing.JPanel pMicroeconomicos;
    private javax.swing.JPanel pTodo;
    private javax.swing.JTable tablaciudades;
    private javax.swing.JTable tablamicros;
    // End of variables declaration//GEN-END:variables

        //RENDERING
    public void setModeloColumn(TableColumn c,int Ancho,boolean derecha,boolean editable) {
        JTextField b = new JTextField();
        b.setEditable(editable);
        c.setCellEditor(new DefaultCellEditor(b));
        c.setMinWidth(Ancho);
        DefaultTableCellRenderer render= new DefaultTableCellRenderer();
        if (derecha) render.setHorizontalAlignment(JLabel.RIGHT);
        else render.setHorizontalAlignment(JLabel.LEFT);
        c.setCellRenderer(render);
        c.setResizable(false);
    }
    private static class MyTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String aequis=(String)table.getValueAt(row, column);
            boolean pasa=false;
            if (aequis!=null) {
                if (aequis.equals("X")) {
                    pasa=true;
                }
            }
            if (pasa) {
                c.setBackground(new Color(102,0,102));
                c.setForeground(new Color(102,0,102));
            } else c.setBackground(Color.white);
            return c;
        }
    }
    
    
    
}