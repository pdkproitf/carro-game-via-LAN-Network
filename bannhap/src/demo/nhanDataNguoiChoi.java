/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import dungchung.message_Cls;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author naruto
 */
public class nhanDataNguoiChoi extends Thread{
    ObjectInputStream ois;
    Online olne;
    Socket sk;
    message_Cls smsCL = new message_Cls();
    public nhanDataNguoiChoi(Online onl,ObjectInputStream ois,Socket sk){
        this.olne = onl;
        this.ois = ois;
        this.sk = sk;
    }
        public void run() {
        while (true) {
            try {
                if (!this.sk.isClosed()) {
                    message_Cls sms = (message_Cls) ois.readObject();
                    if ((sms != null)) {
                        System.out.println("nhan :::::"+sms.getStatus()+sms.getDesc());
                        switch (sms.getStatus()) {
                            case "danh co":
                                System.out.println("----trc khi danh "+this.olne.getCarochess1().isSanSang());
                                this.olne.DanhCoOnline(sms.getOc());
                                this.olne.getCarochess1().setSanSang(true);
                                System.out.println("---co luc nay "+this.olne.getCarochess1().isSanSang());
                                break;
                            case "chat":
                                System.out.println("may chu "+sms.getDesc());
                                break;
                            case "thoat":
                                this.olne.closeSK();
                                this.olne.CloseGiaoDien();
                                break;
                            default:
                                
                        }
                    }
                } else {
                    System.out.println("da dong socket");
                    this.sk.close();
                    this.stop();
                }
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("loi nhan tin "+e.getMessage());
            }
        }
    }
}
