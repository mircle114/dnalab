package com.dnavault;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.awt.Graphics;
import javax.swing.border.*;
import java.util.concurrent.ThreadLocalRandom;

public class SinePixel extends JPanel 
{
   int SCALEFACTOR = 10;
   int cycles;
   int points;
   double[] sines;
   int[] pts;
 
    public void setCycles(int cycles, List<DnaStrand> lstStrands) 
    {
      this.cycles = cycles;
      this.points = SCALEFACTOR * cycles * 2;
     // System.out.println(this.points);
      this.sines = new double[points];
      for (int i = 0; i < points; i++) 
      {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = ThreadLocalRandom.current().nextInt(0, 255 + 1);
        DnaStrand dnaStrand = lstStrands.get(i);
        Double test = dnaStrand.getSumTPercT();
        System.out.printf("Test: %s \n", test);
        double radians = (Math.PI / SCALEFACTOR) * test;
        this.sines[i] = Math.sin(radians);
        //this.sines[i] = dnaStrand.getSinT();
        System.out.printf("Radians: %s | Sines: %s \n" ,dnaStrand.getSinT(), sines[i]);

      }
    }

    public SinePixel(List<DnaStrand> listDnaStrands, Dimension dimensions) throws IOException
    {
      Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
      this.setBorder(raisedetched);

      // Set the cycles for the sine wave
      setCycles(1,listDnaStrands);
    }

    public void paintComponent(Graphics g) 
    {
      int maxWidth = 50; //getWidth();
      double hstep = (double) maxWidth / (double) points;
     
      int maxHeight = 10; //getHeight();
      pts = new int[points];
        
      
      for (int i = 0; i < points; i++)
      {
          double result1 = sines[i] * maxHeight / 2;
          double result2 = result1 * .95;
          double result3 = result2 + maxHeight;
          double result4 = result3 / 2;
          pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
        // System.out.printf("Sines: %s and Converted to: %s \n", sines[i],pts[i]);
        //  System.out.printf("Result1: %s * .95 = %s \n plus maxHeight = %s \n divided by 2 = %s \n and this ends with : %s \n",result1,result2,result3,result4,pts[i]);
      }
      g.setColor(Color.BLUE);
      for (int i = 1; i < points; i++) 
      {
        int x1 = (int) ((i - 1) * hstep);
        int x2 = (int) (i * hstep);
        int y1 = pts[i - 1];
        int y2 = pts[i];
        g.drawLine(x1, y1, x2, y2);
        //g.drawString("æ",x1, y1);
      }
    }
   
}