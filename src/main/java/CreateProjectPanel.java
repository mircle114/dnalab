package com.dnavault;

import javax.swing.*;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import java.awt.Component;


public class CreateProjectPanel extends JPanel
{
  public CreateProjectPanel()
  {
    EventQueue.invokeLater(new Runnable() 
    {
      @Override
      public void run() 
      {
        try 
        {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
  catch (ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException ex) 
        {
          ex.printStackTrace();
        }

        setLayout(new BorderLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBackground(Color.gray);
        setBorder(DnaBorderFactory.createGradientBorder(2,2,2,2));
        setPreferredSize(new Dimension(200,200));
        setVisible(true);
      }
    });
  }
}
