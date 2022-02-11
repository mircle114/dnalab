package com.dnavault;

//import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class DnaApp extends JComponent
{
  private static JFrame rootFrame;
  private static JPanel controlPanel;
  
  private DnaApp(){}
   
  public static void main(String[] args) throws IOException
	{
        try
        {
          loadGUIComponents();

         DnaUtil du = new DnaUtil();
          List<DnaStrand> listDnaStrands = du.getDnaStrands();
          SinePixel sinePix = new SinePixel(listDnaStrands,new Dimension(100,100));
          
          controlPanel.add(sinePix);
          controlPanel.setPreferredSize(new Dimension(25,25));

          rootFrame.pack();
         
        }
        catch(IOException e)
        {
           System.out.println("Error: " + e);
        }
	}

  private static void loadGUIComponents()
  {
      Border blackline = BorderFactory.createLineBorder(Color.PINK);
      
      // The ROOT frame for the entire app
      JFrame.setDefaultLookAndFeelDecorated(true);
      rootFrame = new JFrame("DNA | PIPELINE");
      rootFrame.getContentPane().setLayout(new BorderLayout());
            
      controlPanel = new JPanel();
      controlPanel.setBackground(Color.yellow);
      controlPanel.setOpaque(false);
      controlPanel.setBorder(blackline);
      
      rootFrame.getContentPane().add(controlPanel);
      rootFrame.setSize(400,400);  
      rootFrame.setBackground(Color.magenta);
     
      rootFrame.setVisible(true);  
      rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}


