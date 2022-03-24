package com.dnavault;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;

public class DnaEntryPoint extends JFrame {

    private static JPanel controlPanel;
    private static GridBagConstraints gbc;
    private static JTextArea ta;
  
    public DnaEntryPoint() 
    {
        initUI();
    }

    private void initUI() 
    {
        //createMenuBar();
        //addCreateProjectPanel();
        createTabbedPane();
        setTitle("DNA|Pipeline");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createTabbedPane()
    {
        ta = new JTextArea(200,200);
        JPanel p1 = new JPanel();
        p1.add(ta);
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(50,50,200,200);
        tp.add("Dashboard",p1);
        tp.add("My Apps",p2);
        tp.add("help",p3);
        add(tp);
    }
  
    private void addCreateProjectPanel()
    {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        Common.setControlFixedSize(controlPanel,new Dimension(500,250)); 
        Common.setComponentPadding(controlPanel,20,0,0,0);
        
        GridBagConstraints gbc = new GridBagConstraints();  
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHEAST;  

        // The Maven min props to generate maven project
        JPanel jpProjectPanel = new CreateProjectPanel();
        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.add(jpProjectPanel,gbc);
        controlPanel.add(roundedPanel,gbc);
        add(controlPanel);
    }
  
    // This method is responsible for building up the Menu Bar for the app
    private void createMenuBar() {

        var menuBar = new JMenuBar();
        var exitIcon = new ImageIcon("src/resources/exit.png");

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var eMenuItem = new JMenuItem("Exit", exitIcon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(eMenuItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> 
        {
            var ex = new DnaEntryPoint();
            ex.setVisible(true);
        });
    }
}