package com.dnavault;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.border.*;
import javax.swing.BorderFactory;

public class DnaBorderFactory
{
    public static Border createGradientBorder(int top, int left, int bottom, int right)
    {
        return new GradientBorder(top,left,bottom,right);
    }

    public static Border createTitledBorder(String title,int top, int left, int bottom, int right)    
    {
      return BorderFactory.createTitledBorder(title);
    }
    
   
}