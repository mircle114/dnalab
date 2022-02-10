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
      this.sines = new double[points];
      for (int i = 0; i < points; i++) 
      {
        double radians = (Math.PI / SCALEFACTOR) * i;
        this.sines[i] = Math.sin(radians);
      }
    }

    public SinePixel(Dimension dimensions) throws IOException
    {
        setCycles(10);
    }

    public void paintComponent(Graphics g) 
    {
      int maxWidth = getWidth();
      double hstep = (double) maxWidth / (double) points;
      int maxHeight = getHeight();
      pts = new int[points];
      for (int i = 0; i < points; i++){
        pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
      }
      g.setColor(Color.BLUE);
      for (int i = 1; i < points; i++) {
        int x1 = (int) ((i - 1) * hstep);
        int x2 = (int) (i * hstep);
        int y1 = pts[i - 1];
        int y2 = pts[i];
        g.drawLine(x1, y1, x2, y2);
      }
    }
   
}