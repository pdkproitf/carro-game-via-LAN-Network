/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class BanCo {
    private int _SoDong;

    public int getSoDong() {
        return _SoDong;
    }
    public void setSoDong(int _SoDong) {
        this._SoDong = _SoDong;
    }
    
    private int _SoCot;

    public int getSoCot() {
        return _SoCot;
    }
    public void setSoCot(int _SoCot) {
        this._SoCot = _SoCot;
    }
    
    BanCo(int sodong,int socot){
        _SoDong=sodong;
        _SoCot=socot;
    }
    protected void VeQuanCo(Graphics g,Point point,ImageIcon img) { 
        g.drawImage(img.getImage(), point.x, point.y , null); 
    }      
    
}
