/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import dungchung.message_Cls;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author naruto
 */
public class Constants_cls {
   public static Queue<message_Cls> qData = new LinkedList<message_Cls>();

    public static synchronized Queue<message_Cls> getqData() {
        return qData;
    }

    public static synchronized void addqData(message_Cls sms) {
        Constants_cls.qData.offer(sms);
    }
   
}
