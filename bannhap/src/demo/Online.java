/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import dungchung.Oco;
import dungchung.message_Cls;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Online extends javax.swing.JFrame {

    private Graphics grs;
    Menu mn;
    ServerSocket Svcl;
    Socket Skcl;
    int port, id_phong;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    nhanDataNguoiChoi player;
    String address;
    boolean cftaoPhong;
    turnOff turn;

    public Online(Menu mn, boolean cftaoPhong, int id_phong, int port, String address) {
        initComponents();
        grs = pnBoard.getGraphics();
//        pnBoard.KhoiTaoMangOCo();
        pnBoard.StartPvsP(grs);
        setLocationRelativeTo(null);
        this.mn = mn;
        this.port = port;
        this.address = address;
        this.cftaoPhong = cftaoPhong;
        if (cftaoPhong) {
            System.out.println("gui tin tao phong");
            //gui thong tin dang ky phong len server
            message_Cls sms = new message_Cls("tao phong", "new phong");
            sms.setInetAddress(address);
            sms.setPort(port);
            sms.setId_user(mn.getId_user());
            this.mn.getSk().SendData(sms);
            //NẾU mà tạo phòng thì cho biến sẵn sàng false
            this.carochess1.setSanSang(false);
        } else {
            try {
                Skcl = new Socket(address, port);
                oos = new ObjectOutputStream(Skcl.getOutputStream());
                ois = new ObjectInputStream(Skcl.getInputStream());
                player = new nhanDataNguoiChoi(this, ois, Skcl);
                player.start();
                SendData(new message_Cls("chat", "vao choi mi"));
                //nếu đã kết nối thành công thì cho cờ đánh bằng true
                this.carochess1.setSanSang(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Carochess getCarochess1() {
        return carochess1;
    }

    public void setCarochess1(Carochess carochess1) {
        this.carochess1 = carochess1;
    }

    public void Connect2() {
        try {
            
            Svcl = new ServerSocket(port);
            //gui len server thoi gian cho
            message_Cls sms = new message_Cls("time", "10");
            sms.setInetAddress(address);
            sms.setPort(port);
            sms.setIdPhong(this.mn.getId_phong());
            this.mn.getSk().SendData(sms);
            
            //dang cho nguoi choi
            System.out.println("dang hco nguoi choi");
            Skcl = Svcl.accept();
            System.out.println("da co nguoi choi");
            
            oos = new ObjectOutputStream(Skcl.getOutputStream());
            ois = new ObjectInputStream(Skcl.getInputStream());
            
            player = new nhanDataNguoiChoi(this, ois, Skcl);
            player.start();
            this.carochess1.setSanSang(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SendData(message_Cls sms) {
        try {
            this.oos.writeObject(sms);
            this.oos.flush();
            System.out.println("da gui=>  " + sms.getStatus());
        } catch (Exception e) {
            System.out.println("loi gui data");
            JOptionPane.showMessageDialog(null, "loi gui data");
            e.printStackTrace();
        }
    }

    public void closeSK() {
        try {
            if (this.Skcl != null) {
                this.Skcl.close();
            }
            if (this.Svcl != null) {
                this.Svcl.close();
            }
        } catch (Exception e) {
        }
    }

    public Carochess getPnBoard() {
        return pnBoard;
    }

    public void setPnBoard(Carochess pnBoard) {
        this.pnBoard = pnBoard;
    }

    public Graphics getGrs() {
        return grs;
    }

    public void setGrs(Graphics grs) {
        this.grs = grs;
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
        System.out.println("C66666666666666o online " + this.carochess1.isSanSang());
        if (this.carochess1.isSanSang()) {
            this.carochess1.setSanSang(false);
            int cl = evt.getX() / 25;
            int rw = evt.getY() / 25;
            Oco oc = new Oco();
            oc.setCot(cl);
            oc.setDong(rw);
            Oco oc1 = pnBoard.getMangOCo(rw, cl);
            message_Cls sms = new message_Cls("danh co", "da danh cai ni" + cl + "-" + rw);
            sms.setOc(oc1);
            DanhCoOnline(oc);
            this.SendData(sms);
            //đánh xg cho nó false để đợi
        } else {
            JOptionPane.showMessageDialog(null, "vui lòng đợi đến lượt bạn");
        }
        System.out.println("co ovvvvvvvvvvvvvnline sau " + this.carochess1.isSanSang());
        //
//        this.mn.getSk().SendData();

    }//GEN-LAST:event_pnBoardMouseReleased
    public void DanhCoOnline(Oco oc) {
        int cl = oc.getCot();
        int rw = oc.getDong();
        if (pnBoard.DanhCo_CS(oc.getDong(), oc.getCot(), grs)) {

//            this.mn.getSk().SendData(sms);
            if (pnBoard.getLuotDi() == 1) {
                pnBoard.getBanCo().VeQuanCo(grs, pnBoard.getMangOCo(rw, cl).getVitri(), pnBoard.getImageX());
            } else {
                pnBoard.getBanCo().VeQuanCo(grs, pnBoard.getMangOCo(rw, cl).getVitri(), pnBoard.getImageO());
            }
            if (pnBoard.KiemTraChienThang()) {
                pnBoard.ThongBao();
            } else {
                if (pnBoard.getCheDoChoi() == 2) {
                    pnBoard.KhoiDongComputer(grs);
                    if (pnBoard.KiemTraChienThang()) {
                        pnBoard.ThongBao();
                    }
                }
            }
        }
    }
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
        if ((x > 0) && (x < (lbExit.getWidth())) && (y > 0) && (y < (lbExit.getHeight()))) {
            CloseGiaoDien();
        }
    }//GEN-LAST:event_lbExitMouseReleased
    
    public void CloseGiaoDien(){
                    message_Cls sms = new message_Cls("thoat rooms", "");
            sms.setIdPhong(this.mn.getId_phong());
            System.out.println("id phong                      => "+sms.getIdPhong());
            this.mn.getSk().SendData(sms);
            if (this.mn.getHdtp() != null) {
                this.mn.getHdtp().show();
                this.mn.getHdtp().YeuCauPhong();
            } else {
                this.mn.setHdtp(new HangDoiTimPhong(mn));
                this.mn.getHdtp().YeuCauPhong();
            }
            this.dispose();
    }
    
    private void lbLoseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoseMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Image/Board/Lose_press.png"));
        lbLose.setIcon(II);
    }//GEN-LAST:event_lbLoseMousePressed

    private void lbLoseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoseMouseReleased
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Image/Board/Lose.png"));
        lbLose.setIcon(II);
        int x = evt.getX();
        int y = evt.getY();
        if ((x > 0) && (x < (lbLose.getWidth())) && (y > 0) && (y < (lbLose.getHeight()))) {
            new Carochess().ThongBao();
        }
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
