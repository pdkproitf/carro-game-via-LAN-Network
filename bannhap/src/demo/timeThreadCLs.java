/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author naruto
 */
public class timeThreadCLs extends Thread {

    Carochess cc;
    PvC pcShow;
    public boolean cf = false;

    public timeThreadCLs(PvC pc) {
        this.pcShow = pc;
    }

    public void run() {
        while (true) {
            try {
                if (pcShow.getGiay() < 0) {
                    pcShow.setGiay(17);
                    //System.out.println(" het gio ");
                    //JOptionPane.showMessageDialog(null,"het thoi gian  THẰNG NGU");
                    this.stop();
                }
                this.pcShow.setGiay(pcShow.getGiay() - 1);
                this.pcShow.setTime();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
