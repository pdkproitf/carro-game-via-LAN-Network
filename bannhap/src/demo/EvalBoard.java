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
public class EvalBoard {
    public int height, width;
    public int EBoard[][];
    public EvalBoard()
    {
        height=20;
        width=20;
        EBoard=new int[22][22];
        
        ResetBoard();
    }
   
    
    public void ResetBoard()
        {
            
            for (int r = 0; r < height + 2; r++)
                for (int c = 0; c < width + 2; c++){                   
                  EBoard[r][c] = 0;
        }
        }

        public Point MaxPos()
        {
            int Max = 0;
            Point p = new Point(); 
            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    if (EBoard[i][j] > Max)
                    {
                        p.x = i; p.y = j;
                        Max = EBoard[i][j];
                    }
                    
                }
            }
            return p;
        }
}
