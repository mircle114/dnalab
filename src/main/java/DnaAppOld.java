package com.dnavault;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;

public class DnaAppOld extends JFrame
{
  //private static JFrame rootFrame;
  private static JPanel controlPanel;
  private static GridBagConstraints gbc;
  
  public DnaAppOld()
  {
    EventQueue.invokeLater(new Runnable() 
    {
      @Override
      public void run() 
      {
       /* controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        Common.setComponentToFixedDimension(controlPanel,new Dimension(500,250)); 

        Common.setComponentPadding(controlPanel,20,0,0,0);
        */
        GridBagConstraints gbc = new GridBagConstraints();  
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHEAST;  

        // The Maven min props to generate maven project
   //     JPanel jpProjectPanel = new CreateProjectPanel();
     //   RoundedPanel roundedPanel = new RoundedPanel();
  
       // roundedPanel.add(jpProjectPanel,gbc);
        //controlPanel.add(roundedPanel,gbc);
        
         // The ROOT frame for the entire app
        //JFrame.setDefaultLookAndFeelDecorated(true);
        //rootFrame = new JFrame("DNA | PIPELINE");
       /* setTitle("DNA|Pipeline");
        //rootFrame.setLayout(new BorderLayout());
        //setLayout(null);
        setLocationRelativeTo(null);
        JMenuBar jmb = new MyMenu();
        add(jmb);
        setJMenuBar(jmb); 
        //rootFrame.add(controlPanel,BorderLayout.EAST);
        //setBackground(Color.magenta);
        Dimension fixedDimension = new Dimension(500,300);
        //setSize(fixedDimension);
        //setPreferredSize(fixedDimension);
        setMaximumSize(fixedDimension);
        setMinimumSize(fixedDimension);
        // Common.setComponentToFixedDimension (this,new Dimension(500,300)); 
        setVisible(true);  
        setDefaultCloseOperation(
        JFrame.EXIT_ON_CLOSE);
    
        pack();*/
      }
    });
  }
   
  public static void main(String[] args) 
	{
    new DnaAppOld();
	}
}


