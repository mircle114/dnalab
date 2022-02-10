package com.dnavault;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class DnaApp extends JComponent
{

  private static JFrame mainFrame;
  private static JPanel controlPanel;
  
  private DnaApp(){}
   
  public static void main(String[] args) throws IOException
	{
        try
        {
          loadGUIComponents();
          SinePixel sinePix = new SinePixel(new Dimension(100,100));
          controlPanel.add(sinePix);
          
          mainFrame.pack();
         
        }
        catch(IOException e)
        {
           System.out.println("Error: " + e);
        }
	}

  private static void loadGUIComponents()
  {
      JFrame.setDefaultLookAndFeelDecorated(true);
      mainFrame = new JFrame("DNA | PIPELINE");
      mainFrame.setBackground(Color.white);
      mainFrame.setSize(500,500);
      mainFrame.pack();
      mainFrame.addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent windowEvent)
        {
          System.exit(0);
        }
      });

      Border blackline = BorderFactory.createLineBorder(Color.white);
      controlPanel = new JPanel(new GridLayout(1,1));
      controlPanel.setBorder(blackline);
      
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);  
  }
}


