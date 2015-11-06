/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import dungchung.message_Cls;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author naruto
 */
public class GuiDataDemoThs {

    Socket sk;
    ObjectOutputStream oos;
    String name;
    NhanDataDemoThs nhanData;

    public GuiDataDemoThs(String name) {
//        super(name);
        this.name = name;

    }

    public GuiDataDemoThs() {

    }

    public boolean openConnect(message_Cls sms, Menu mn) {
        try {
            System.out.println("tao ket noi");
            sk = new Socket("localhost", 1111);
            oos = new ObjectOutputStream(this.sk.getOutputStream());
            SendData(sms);
            ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());
            message_Cls sms2 = (message_Cls) ois.readObject();
            if (sms2 != null) {
                if (sms2.isCf()) {
                    nhanData = new NhanDataDemoThs(sk, name, ois, mn);
                    nhanData.start();
                    mn.setNotice(sms2.getDesc());
                    return true;
                } else {
                    mn.setNotice(sms2.getDesc());
                }
            }
            sk.close();
            System.out.println("dong sk");
            return false;
        } catch (Exception ex) {
            System.out.println("loi tao socket");
            mn.setNotice("ket noi that bai xem lai duong truyen hoac ip may chu");
            ex.printStackTrace();
            return false;
        }
    }

    public void closeSk() {
        try {
            if(this.sk!=null||!this.sk.isClosed()){
                SendData(new message_Cls("dong", "dong ket noi"));
                nhanData.closeSk();
                this.sk.close();
                System.out.println("da dong sk");
            }
        } catch (IOException ex) {
            System.out.println("loi dong sk");
            ex.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println("da tao ket noi den");
                if (!this.sk.isClosed()) {
                    System.out.println("socket life");
                    System.out.println("gui dat: => toi la socket thu 4");
                    oos.writeObject(new message_Cls("thong bao", "toi la socket thu 4"));
                    oos.flush();
                } else {
                    System.out.println("sk da dong");
                    this.sk.close();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("loi gui data");
                e.printStackTrace();
            }
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
}
