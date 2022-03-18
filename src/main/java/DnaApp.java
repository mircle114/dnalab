package com.dnavault;

import java.awt.Dimension;
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

public class DnaApp extends JComponent
{
  private static JFrame rootFrame;
  private static JPanel controlPanel;
  
  
  private DnaApp(){}
   
  public static void main(String[] args) 
	{
    loadGUIComponents();
    JTextField jtfModelVersion = new JTextField("4.0.0");
    JTextField jtfGroupId = new JTextField();
    JTextField jtfArtifactId = new JTextField();
    JTextField jtfVersion = new JTextField();
    controlPanel = new CreateProjectPanel();
    controlPanel.setLayout(new BorderLayout());
    controlPanel.add(jtfModelVersion); 
    controlPanel.setPreferredSize(new Dimension(50,50));
    
    rootFrame.getContentPane().add(controlPanel,BorderLayout.EAST);
    rootFrame.pack();
       
	}

  private static void loadGUIComponents()
  {
      // The ROOT frame for the entire app
      JFrame.setDefaultLookAndFeelDecorated(true);
      rootFrame = new JFrame("DNA | PIPELINE");
      
      rootFrame.setSize(400,400);  
      rootFrame.setBackground(Color.magenta);
     
      rootFrame.setVisible(true);  
      rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}


