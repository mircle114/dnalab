package com.dnavault;

//import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.GridLayout;
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
          DnaUtil du = new DnaUtil();
          List<DnaStrand> listDnaStrands = du.getDnaStrands();
          SinePixel sinePix = new SinePixel(listDnaStrands,new Dimension(100,100));
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
      mainFrame.setBackground(Color.magenta);
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
      
      JButton jButton = new JButton();
      JButton b=new JButton("Click Here");  
      b.setBounds(0,0,95,50);  
    mainFrame.add(b);  
    mainFrame.setSize(400,400);  
    //mainFrame.setLayout(null);  
   

      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);  
  }
}


