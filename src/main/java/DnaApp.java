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

public class DnaApp extends JPanel
{
  private static JFrame rootFrame;
  private static JPanel controlPanel;
  private static GridBagConstraints gbc;
  
  public DnaApp()
  {
    EventQueue.invokeLater(new Runnable() 
    {
      @Override
      public void run() 
      {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();  
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;  

        // The Maven min props to generate maven project
        JPanel jpProjectPanel = new CreateProjectPanel();
        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.add(jpProjectPanel);
        controlPanel.add(roundedPanel,gbc);
        
         // The ROOT frame for the entire app
        JFrame.setDefaultLookAndFeelDecorated(true);
        rootFrame = new JFrame("DNA | PIPELINE");
        rootFrame.setLayout(new BorderLayout());
        rootFrame.add(controlPanel,BorderLayout.NORTH);
        rootFrame.setBackground(Color.magenta);
        rootFrame.setSize(400,250);
        rootFrame.setVisible(true);  
        rootFrame.setDefaultCloseOperation(
        JFrame.EXIT_ON_CLOSE);
    
        rootFrame.pack();
      }
    });
  }
   
  public static void main(String[] args) 
	{
    new DnaApp();
	}
}


