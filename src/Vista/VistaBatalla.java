/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Movimiento;
import Modelo.Pokemon;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author fcuevas
 */
public class VistaBatalla extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    public VistaBatalla(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Capa2.setVisible(false);
        Capa3.setVisible(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Capa3 = new javax.swing.JLayeredPane();
        turnoLb = new javax.swing.JLabel();
        pokeActualLb = new javax.swing.JLabel();
        pokeActualNombreLb = new javax.swing.JLabel();
        ataque1 = new javax.swing.JButton();
        ataque2 = new javax.swing.JButton();
        ataque3 = new javax.swing.JButton();
        ataque4 = new javax.swing.JButton();
        turnoNombreLb = new javax.swing.JLabel();
        Capa1 = new javax.swing.JLayeredPane();
        texto = new javax.swing.JLabel();
        btSimple = new javax.swing.JButton();
        btTriple = new javax.swing.JButton();
        btDoble = new javax.swing.JButton();
        Capa2 = new javax.swing.JLayeredPane();
        bAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        turnoLb.setText("Turno:");

        pokeActualLb.setText("Pokemon Actual:");

        pokeActualNombreLb.setText("jLabel4");

        ataque1.setText("jButton1");
        ataque1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque1ActionPerformed(evt);
            }
        });

        ataque2.setText("jButton2");
        ataque2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque2ActionPerformed(evt);
            }
        });

        ataque3.setText("jButton3");
        ataque3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque3ActionPerformed(evt);
            }
        });

        ataque4.setText("jButton4");
        ataque4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque4ActionPerformed(evt);
            }
        });

        turnoNombreLb.setText("jLabel2");

        javax.swing.GroupLayout Capa3Layout = new javax.swing.GroupLayout(Capa3);
        Capa3.setLayout(Capa3Layout);
        Capa3Layout.setHorizontalGroup(
            Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Capa3Layout.createSequentialGroup()
                .addGroup(Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Capa3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pokeActualLb)
                            .addComponent(ataque1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Capa3Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(pokeActualNombreLb))
                            .addGroup(Capa3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(ataque2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(ataque3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(ataque4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Capa3Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(turnoLb)
                        .addGap(48, 48, 48)
                        .addComponent(turnoNombreLb, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        Capa3Layout.setVerticalGroup(
            Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Capa3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(turnoLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(turnoNombreLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pokeActualLb)
                    .addComponent(pokeActualNombreLb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(Capa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ataque1)
                    .addComponent(ataque2)
                    .addComponent(ataque3)
                    .addComponent(ataque4))
                .addGap(79, 79, 79))
        );
        Capa3.setLayer(turnoLb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa3.setLayer(pokeActualLb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa3.setLayer(pokeActualNombreLb, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa3.setLayer(ataque1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa3.setLayer(ataque2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa3.setLayer(ataque3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa3.setLayer(ataque4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa3.setLayer(turnoNombreLb, javax.swing.JLayeredPane.DEFAULT_LAYER);

        texto.setText("Seleccione tipo de combate");

        btSimple.setText("Simple");
        btSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpleActionPerformed(evt);
            }
        });

        btTriple.setText("Triple");

        btDoble.setText("Doble");
        btDoble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDobleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Capa1Layout = new javax.swing.GroupLayout(Capa1);
        Capa1.setLayout(Capa1Layout);
        Capa1Layout.setHorizontalGroup(
            Capa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Capa1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btSimple)
                .addGap(83, 83, 83)
                .addComponent(btDoble)
                .addGap(94, 94, 94)
                .addComponent(btTriple)
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Capa1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(texto)
                .addGap(110, 110, 110))
        );
        Capa1Layout.setVerticalGroup(
            Capa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Capa1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(texto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(Capa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimple)
                    .addComponent(btTriple)
                    .addComponent(btDoble))
                .addGap(49, 49, 49))
        );
        Capa1.setLayer(texto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa1.setLayer(btSimple, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa1.setLayer(btTriple, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa1.setLayer(btDoble, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Elija su pokemon inicial");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout Capa2Layout = new javax.swing.GroupLayout(Capa2);
        Capa2.setLayout(Capa2Layout);
        Capa2Layout.setHorizontalGroup(
            Capa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Capa2Layout.createSequentialGroup()
                .addGroup(Capa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Capa2Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(bAceptar))
                    .addGroup(Capa2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(Capa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        Capa2Layout.setVerticalGroup(
            Capa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Capa2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAceptar)
                .addContainerGap())
        );
        Capa2.setLayer(bAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Capa2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Capa1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Capa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 24, Short.MAX_VALUE)
                    .addComponent(Capa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Capa1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Capa2)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Capa3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSimpleActionPerformed

    private void btDobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDobleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDobleActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        
    }//GEN-LAST:event_bAceptarActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1ValueChanged

    private void ataque2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque2ActionPerformed
    this.nombreApretado = ataque2.getText();  
    
    }//GEN-LAST:event_ataque2ActionPerformed

    private void ataque1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque1ActionPerformed
    this.nombreApretado = ataque1.getText();
    
    }//GEN-LAST:event_ataque1ActionPerformed

    private void ataque3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque3ActionPerformed
    this.nombreApretado = ataque3.getText();     // TODO add your handling code here:
    }//GEN-LAST:event_ataque3ActionPerformed

    private void ataque4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque4ActionPerformed
    this.nombreApretado = ataque4.getText();         // TODO add your handling code here:
    }//GEN-LAST:event_ataque4ActionPerformed
   public Object getValorSeleccionado(){
       return jList1.getSelectedValue();
   }
   public void agregarListener(ActionListener copucha){
        btSimple.addActionListener(copucha);
        btSimple.setActionCommand("1");
        btDoble.addActionListener(copucha);
        btDoble.setActionCommand("2");
        btTriple.addActionListener(copucha);
        btTriple.setActionCommand("3");
        bAceptar.addActionListener(copucha);
        bAceptar.setActionCommand("4");
        ataque1.addActionListener(copucha);
        ataque1.setActionCommand("6");
        ataque2.addActionListener(copucha);
        ataque2.setActionCommand("7");
        ataque3.addActionListener(copucha);
        ataque3.setActionCommand("8");
        ataque4.addActionListener(copucha);
        ataque4.setActionCommand("9");
       }
   public void bAceptarSegundoClick(){
       this.bAceptar.setActionCommand("5");
   }
   public void esconderCapa1(){
        this.Capa1.setVisible(false);
   }
   public void esconderCapa2(){
       this.Capa2.setVisible(false);
   }
   public void mostrarCapa2(){
        this.Capa2.setVisible(true);}
   
   public void mostrarCapa3(){
        this.Capa3.setVisible(true);
   }
   
   public void agregarEnLista(ArrayList<Pokemon> listaPokemon){
            
       
        DefaultListModel elementosLista = new DefaultListModel();
        for(Pokemon pokemon : listaPokemon){
            elementosLista.addElement(pokemon.getNombre());
        jList1.setModel(elementosLista);
       
              
       }
        
       
   }

   public void setBotones(Movimiento[] movimientos,String nombre, String nombre2){
      
        ataque1.setText(movimientos[0].getNombre());
        ataque2.setText(movimientos[1].getNombre());
        ataque3.setText(movimientos[2].getNombre());
        ataque4.setText(movimientos[3].getNombre());
     
        pokeActualNombreLb.setText(nombre);
        turnoNombreLb.setText(nombre2);
      
      
       
   }
       
   public String getNombreApretado(){
       return this.nombreApretado;
   }    

    public JButton getAtaque1() {
        return ataque1;
    }

    public void setAtaque1(JButton ataque1) {
        this.ataque1 = ataque1;
    }

    public JButton getAtaque2() {
        return ataque2;
    }

    public void setAtaque2(JButton ataque2) {
        this.ataque2 = ataque2;
    }

    public JButton getAtaque3() {
        return ataque3;
    }

    public void setAtaque3(JButton ataque3) {
        this.ataque3 = ataque3;
    }

    public JButton getAtaque4() {
        return ataque4;
    }

    public void setAtaque4(JButton ataque4) {
        this.ataque4 = ataque4;
    }
       
       
       
   private String nombreApretado;
               
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Capa1;
    private javax.swing.JLayeredPane Capa2;
    private javax.swing.JLayeredPane Capa3;
    private javax.swing.JButton ataque1;
    private javax.swing.JButton ataque2;
    private javax.swing.JButton ataque3;
    private javax.swing.JButton ataque4;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton btDoble;
    private javax.swing.JButton btSimple;
    private javax.swing.JButton btTriple;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pokeActualLb;
    private javax.swing.JLabel pokeActualNombreLb;
    private javax.swing.JLabel texto;
    private javax.swing.JLabel turnoLb;
    private javax.swing.JLabel turnoNombreLb;
    // End of variables declaration//GEN-END:variables
}
