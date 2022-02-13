package com.dnavault;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;
//import javax.swing.border.Border;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class SpringLayoutDemo extends JFrame
{
 

  public static void main(String[] args) {
    JFrame aWindow = new JFrame("This is a Box Layout");
    aWindow.setBounds(30, 30, 300, 300);
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Create left column of radio buttons
    Box left = Box.createVerticalBox();
    left.add(Box.createVerticalStrut(30));
    ButtonGroup radioGroup = new ButtonGroup();
    JRadioButton rbutton;
    radioGroup.add(rbutton = new JRadioButton("Red"));
    left.add(rbutton);
    left.add(Box.createVerticalStrut(30));
    radioGroup.add(rbutton = new JRadioButton("Green"));
    left.add(rbutton);
    left.add(Box.createVerticalStrut(30));
    radioGroup.add(rbutton = new JRadioButton("Blue"));
    left.add(rbutton);
    left.add(Box.createVerticalStrut(30));
    radioGroup.add(rbutton = new JRadioButton("Yellow"));
    left.add(rbutton);
    Box right = Box.createVerticalBox();
    right.add(new JCheckBox("A"));
    right.add(new JCheckBox("B"));
    right.add(new JCheckBox("C"));
    Box top = Box.createHorizontalBox();
    top.add(left);
    top.add(right);
    Container content = aWindow.getContentPane();
    content.setLayout(new BorderLayout());
    content.add(top, BorderLayout.CENTER);
    aWindow.pack();
    aWindow.setVisible(true);
  

}
}