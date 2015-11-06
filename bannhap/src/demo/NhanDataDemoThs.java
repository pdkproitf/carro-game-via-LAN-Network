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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naruto
 */
public class NhanDataDemoThs extends Thread {

    Socket sk;
    ObjectInputStream ois;

    public NhanDataDemoThs(Socket sk, String name) {
        super(name);
        try {
            this.sk = sk;
            ois = new ObjectInputStream(this.sk.getInputStream());
            System.out.println("luong nhan hoat dong");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                if (!this.sk.isClosed()) {
                    message_Cls sms = (message_Cls) ois.readObject();
                    if (sms != null) {
                        System.out.println("da nhan duoc => " + sms.getDesc());
                    }
                } else {
                    System.out.println("da dong socket");
                    this.sk.close();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("loi nhan tin");
                e.printStackTrace();
            }
        }
    }
}
