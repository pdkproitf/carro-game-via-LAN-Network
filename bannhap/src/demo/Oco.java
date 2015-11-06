/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import java.awt.Point;

/**
 *
 * @author PC
 */
public class Oco {
    private int _Dong;

    public int getDong() {
        return _Dong;
    }
    public void setDong(int _Dong) {
        this._Dong = _Dong;
    }
    
    private int _Cot;

    public int getCot() {
        return _Cot;
    }
    public void setCot(int _Cot) {
        this._Cot = _Cot;
    }
    
    private Point _Vitri;

    public Point getVitri() {
        return _Vitri;
    }
    public void setVitri(Point _Vitri) {
        this._Vitri = _Vitri;
    }
    
    private int _Sohuu;

    public int getSohuu() {
        return _Sohuu;
    }

    public void setSohuu(int _Sohuu) {
        this._Sohuu = _Sohuu;
    }
    
    public Oco(int dong,int cot,Point vitri,int sohuu){
        _Dong=dong;
        _Cot=cot;
        _Vitri=vitri;
        _Sohuu=sohuu;
    }

}
