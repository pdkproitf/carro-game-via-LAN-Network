/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import dungchung.Room_Cls;
import dungchung.message_Cls;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author naruto
 */
public class HangDoiTimPhong extends javax.swing.JFrame{

    /**
     * Creates new form HangDoiTimPhong
     */
    final Menu mn;
    public HangDoiTimPhong(Menu mn) {
        initComponents();
        this.setVisible(true);
        this.mn = mn;
        YeuCauPhong();
        
    }
    public void YeuCauPhong(){//gui yeu cau len server load phong he thong
        this.mn.getSk().SendData(new message_Cls("rooms", "yeu cau danh sach phong"));
    }
    public void hienThiPhong(ArrayList<Room_Cls> mangPhong) {
        this.PnShowPhong.removeAll();
        this.PnShowPhong.setLayout(new GridLayout(5, 2));
        if (mangPhong != null) {
            for (int i = 0; i < mangPhong.size(); i++) {
                JButton bt = new JButton("phong "+mangPhong.get(i).getId() + " so nguoi " + mangPhong.get(i).getSonguoi());
                this.PnShowPhong.add(bt);
                bt.setActionCommand(mangPhong.get(i).getId()+"");
                final int id = mangPhong.get(i).getId();
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //dua id muon den vao menu
                        mn.setId_phong(id);
                        //gui id phong muon ket noi den cho server
                        message_Cls sms = new message_Cls("vao phong", e.getActionCommand());
                        sms.setId_user(mn.getId_user());//gui luon id cua chinh minh den server
                        sms.setIdPhong(mn.getId_phong());
                        mn.getSk().SendData(sms);
                        System.out.println("yeu cau vao phong "+e.getActionCommand());
                    }
                });
            }
            JButton btNew = new JButton();
            btNew.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int port;
                        while(true){
                            port = new Random().nextInt(9999);
                            if(port!=mn.getServerPort()){
                                break;
                            }
                        }
                        vaoPhong(port);
                    }
                });
            this.PnShowPhong.add(btNew);
        }else{
            this.PnShowPhong.removeAll();
        }
        System.out.println("hien thi phong");
        this.show();
    }
    public final void vaoPhong(int port){
        new Online(mn, true,0,port,"localhost").show();;
         this.dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PnShowPhong = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));

        jLabel1.setText("                             DANH SACH HANG DOI");

        PnShowPhong.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout PnShowPhongLayout = new javax.swing.GroupLayout(PnShowPhong);
        PnShowPhong.setLayout(PnShowPhongLayout);
        PnShowPhongLayout.setHorizontalGroup(
            PnShowPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        PnShowPhongLayout.setVerticalGroup(
            PnShowPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PnShowPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnShowPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HangDoiTimPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HangDoiTimPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HangDoiTimPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HangDoiTimPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HangDoiTimPhong().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnShowPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
