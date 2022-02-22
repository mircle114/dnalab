package com.dnavault;

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

public class DnaGridBagLayout {

  public static void main(String[] args) 
  {
    new DnaGridBagLayout();
  }

  public DnaGridBagLayout() 
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
            | UnsupportedLookAndFeelException ex) {
        }

        JFrame frame = new JFrame("Kayla's App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(new TestPane(),BorderLayout.EAST);
        frame.setPreferredSize(new Dimension(500,400));
        frame.pack();
        //frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  public class TestPane extends JPanel implements ActionListener {

    private JButton selFileButton;

    private BufferedImage img;
    private JLabel labelImg;

    private JPanel fields;
    private JTextField red;
    private JTextField green;
    private JTextField blue;

    private String fileName;

    public String getFileName() 
    {
      return this.fileName;
    }

    public void setFileName(String filename) 
    {
      this.fileName = filename;
    }

    // Override this method to specify the panel's
    // insets (top, left, bottom, right).
    public Insets getInsets()
    {
      return new Insets(5,5,5,5);
    }

    public TestPane() 
    {
      // Layout manager
      GridBagLayout gbl = new GridBagLayout();
      this.setLayout(gbl);
      Border border = DnaBorderFactory.createGradientBorder(35,50,45,50);

      
      // Set the appropriate border
      this.setBorder(border);

      // Constraints object for layout management
      GridBagConstraints gbc = new GridBagConstraints();  
     
      // Examples of adding textfields
      /*JTextField AComponent = setTextField("A component",0,0,gbc,gbl);
      JTextField BComponent = setTextField("B component",0,1,gbc,gbl);
      JTextField CComponent = setTextField("C component",0,2,gbc,gbl);
      JTextField DComponent = setTextField("D component",1,0,gbc,gbl);*/

      JButton selectFileButton = setButton("...",0,0,gbl);

      gbc.weightx = 1;
      gbc.weighty = 1;
      gbc.fill = GridBagConstraints.VERTICAL;
      gbc.anchor = GridBagConstraints.NORTH;

      
      // The selected image file (using a label with setIcon)
      labelImg = new JLabel();
      labelImg.setBorder(DnaBorderFactory.createGradientBorder(5,5,5,5));
      gbc.weighty = 1;
      gbc.weighty = 1;
      gbc.gridx = 0;
      gbc.gridy = 1;
      add(labelImg, gbc);
      labelImg.setPreferredSize(new Dimension(200,100));


      fields = new JPanel();
      gbc.gridx = 0;
      gbc.gridy = 2;
      fields.setBorder(DnaBorderFactory.createGradientBorder(0,5,0,5));
      red = new JTextField(4);
      green = new JTextField(3);
      blue = new JTextField(3);
      fields.add(red);
      fields.add(green);
      fields.add(blue);

      gbc.gridx = 0;
      gbc.gridy = 3;

      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.VERTICAL;
      gbc.anchor = GridBagConstraints.SOUTH;


      add(fields, gbc);
      fields.setPreferredSize(new Dimension(200,35));

      this.setPreferredSize(new Dimension(300, 100));
     


       /*JPanel north = new JPanel(new GridBagLayout());
      
      
      //gbc.weightx = 0;
      gbc.gridx = 2;
      gbc.gridy = 1;
      gbc.insets = new Insets(10, 10, 10, 10);
      
      //gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.WEST;
      
      north.add(labelD, gbc);

      JPanel south = new JPanel(new GridBagLayout());
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridy = 4;
      south.add(labelA, gbc);
      gbc.gridy = 1;
      south.add(labelB, gbc);
      gbc.gridy = 2;
      south.add(labelC, gbc);

      setLayout(new BorderLayout());
      //content.add(north,gbc);
      add(north, BorderLayout.NORTH);
      add(south, BorderLayout.SOUTH);*/
    }

    public JButton setButton(String caption,int x,int y,GridBagLayout lay) 
    {
      selFileButton = new JButton(caption);

      // Constraints object for layout management
      GridBagConstraints gbc = new GridBagConstraints();  
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.NONE;
      gbc.anchor = GridBagConstraints.NORTH;

      gbc.gridx = x;
      gbc.gridy = y;
      lay.setConstraints(selFileButton, gbc);
      add(selFileButton);
      selFileButton.addActionListener(this);
      return selFileButton;
    }

    public JTextField setTextField(String name,int x,int y,GridBagConstraints gbc,GridBagLayout lay)
    {
        JTextField jt = new JTextField(name);
        gbc.gridy = y;
        gbc.gridx = x;
        lay.setConstraints(jt, gbc);
        add(jt);
        return jt;
    }

    public void loadImageIcon(String filename) 
    {
      try 
      {
        if (fileName != "") 
        {
          BufferedImage img = ImageIO.read(new File(fileName));
          labelImg.setIcon(new ImageIcon(img));
          labelImg.addMouseMotionListener(new MouseAdapter() 
          {
            @Override
            public void mouseMoved(MouseEvent e) 
            {
              try 
              {
                int packedInt = img.getRGB(e.getX(), e.getY());
                Color color = new Color(packedInt, true);
                fields.setBackground(color);
                red.setText(Integer.toString(color.getRed()));
                green.setText(Integer.toString(color.getGreen()));
                blue.setText(Integer.toString(color.getBlue()));
              } 
              catch (Exception exception) 
              {

              }
            }
          });
        }
      } catch (IOException ex) 
      {
        ex.printStackTrace();
      }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if (selFileButton instanceof JButton) 
      {
        DnaFileChooser dnFile = new DnaFileChooser(this);
        String selectedFileName = dnFile.getSelectedFile().getAbsolutePath();
        this.setFileName(selectedFileName);
        if (selectedFileName != "") 
        {
          loadImageIcon(selectedFileName);
        }
      }
    }

  }

}