/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class Form extends javax.swing.JFrame {

    
    private Graphics grs;
    public Form() {
        initComponents();
        //caro= new Carochess();
        //caro.KhoiTaoMangOCo();
        //caro.VeLaiQuanCo(grs);
        grs=pnBoard.getGraphics();
        pnBoard.KhoiTaoMangOCo();
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carochess1 = new demo.Carochess();
        pnPlayOnline = new javax.swing.JPanel();
        pnBoard = new demo.Carochess();
        lbLose = new javax.swing.JLabel();
        lbExit = new javax.swing.JLabel();
        lbBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));
        setUndecorated(true);
        setResizable(false);

        pnPlayOnline.setPreferredSize(new java.awt.Dimension(1244, 700));
        pnPlayOnline.setLayout(null);

        pnBoard.setPreferredSize(new java.awt.Dimension(501, 501));
        pnBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnBoardMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnBoardLayout = new javax.swing.GroupLayout(pnBoard);
        pnBoard.setLayout(pnBoardLayout);
        pnBoardLayout.setHorizontalGroup(
            pnBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );
        pnBoardLayout.setVerticalGroup(
            pnBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        pnPlayOnline.add(pnBoard);
        pnBoard.setBounds(369, 47, 501, 501);

        lbLose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Board/Lose.png"))); // NOI18N
        lbLose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbLoseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbLoseMouseReleased(evt);
            }
        });
        pnPlayOnline.add(lbLose);
        lbLose.setBounds(475, 610, 65, 65);

        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Board/thoat.png"))); // NOI18N
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbExitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbExitMouseReleased(evt);
            }
        });
        pnPlayOnline.add(lbExit);
        lbExit.setBounds(712, 610, 60, 64);

        lbBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Board/Game.png"))); // NOI18N
        pnPlayOnline.add(lbBg);
        lbBg.setBounds(0, 0, 1244, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnPlayOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnPlayOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnBoardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBoardMouseReleased

      if(pnBoard.DanhCo(evt.getX(), evt.getY(), grs))
      {
          if(pnBoard.KiemTraChienThang())
              pnBoard.ThongBao();
          else{
              if(pnBoard.getCheDoChoi() == 2){    
              pnBoard.KhoiDongComputer(grs);
              if(pnBoard.KiemTraChienThang())
                  pnBoard.ThongBao();
              }
          }
      }
       
    }//GEN-LAST:event_pnBoardMouseReleased

    private void lbExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Image/Board/thoat_press.png"));
        lbExit.setIcon(II);
    }//GEN-LAST:event_lbExitMousePressed

    private void lbExitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseReleased
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Image/Board/thoat.png"));
        lbExit.setIcon(II);
        int x = evt.getX();
        int y = evt.getY();
        if ((x > 0) && (x < (lbExit.getWidth())) && (y > 0) && (y < (lbExit.getHeight()))){
            dispose();
        }      
    }//GEN-LAST:event_lbExitMouseReleased

    private void lbLoseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoseMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Image/Board/Lose_press.png"));
        lbLose.setIcon(II);
    }//GEN-LAST:event_lbLoseMousePressed

    private void lbLoseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoseMouseReleased
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Image/Board/Lose.png"));
        lbLose.setIcon(II);
    }//GEN-LAST:event_lbLoseMouseReleased
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private demo.Carochess carochess1;
    private javax.swing.JLabel lbBg;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbLose;
    private demo.Carochess pnBoard;
    private javax.swing.JPanel pnPlayOnline;
    // End of variables declaration//GEN-END:variables
}
