package com.dnavault;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class SinePixel extends JPanel 
{
   int SCALEFACTOR = 10;
   int cycles;
   int points;
   double[] sines;
   int[] pts;
 
    public void setCycles(int cycles) 
    {
      this.cycles = cycles;
      this.points = SCALEFACTOR * cycles * 2;
     // System.out.println(this.points);
      this.sines = new double[points];
      for (int i = 0; i < points; i++) 
      {
        double radians = (Math.PI / SCALEFACTOR) * i;
        this.sines[i] = Math.sin(radians);

        System.out.printf("Radians: %s | Sines: %s \n" ,radians, sines[i]);

      }
    }

    public SinePixel(Dimension dimensions) throws IOException
    {
        setCycles(2);
    }

    

    public void paintComponent(Graphics g) 
    {
      int maxWidth = getWidth();
      double hstep = (double) maxWidth / (double) points;
      System.out.printf("HStep: %s \n",hstep);
      int maxHeight = getHeight();
      pts = new int[points];
      for (int i = 0; i < points; i++)
      {
        double result1 = sines[i] * maxHeight / 2;
        double result2 = result1 * .95;
        double result3 = result2 + maxHeight;
        double result4 = result3 / 2;
        pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
       // System.out.printf("Sines: %s and Converted to: %s \n", sines[i],pts[i]);
        System.out.printf("Result1: %s * .95 = %s \n plus maxHeight = %s \n divided by 2 = %s \n and this ends with : %s \n",result1,result2,result3,result4,pts[i]);

      }
      g.setColor(Color.BLUE);
      for (int i = 1; i < points; i++) 
      {
        int x1 = (int) ((i - 1) * hstep);
        int x2 = (int) (i * hstep);
        int y1 = pts[i - 1];
        int y2 = pts[i];
        g.drawLine(x1, y1, x1, y1);
      }
    }
   
}