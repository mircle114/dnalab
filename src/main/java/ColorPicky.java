package com.dnavault;

import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

public class ColorPicky {

  public static void main(String[] args) {
    new ColorPicky();
  }

  public ColorPicky() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException ex) {
        }

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new TestPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
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

    public String getFileName() {
      return this.fileName;
    }

    public void setFileName(String filename) {
      this.fileName = filename;
    }

    public TestPane() 
    {
      
      Container content = getContentPane();

      JTextField labelA = new JTextField("Your A component");
      JTextField labelB = new JTextField("Your B component");
      JTextField labelC = new JTextField("Your C component");
      JTextField labelD = new JTextField("Top Right D");

      JPanel north = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      
      //gbc.weightx = 0;
      gbc.gridx = 1;
      gbc.insets = new Insets(10, 10, 10, 10);
      
      
      gbc.anchor = GridBagConstraints.EAST;
     
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
      content.add(north,gbc);
      //add(north, BorderLayout.NORTH);
      add(south, BorderLayout.SOUTH);
     
     /* setLayout(new GridBagLayout());

      GridBagConstraints gbc = new GridBagConstraints();
      // gbc.gridwidth = GridBagConstraints.REMAINDER;

      buttonProperties(gbc);

      // The selected image file (using a label with setIcon)
      labelImg = new JLabel();
      gbc.gridx = 1;
      gbc.gridy = 0;
      add(labelImg, gbc);

      fields = new JPanel();
      gbc.gridx = 0;
      gbc.gridy = 1;
      fields.setBorder(new EmptyBorder(1, 15, 15, 15));
      red = new JTextField(4);
      green = new JTextField(3);
      blue = new JTextField(3);
      fields.add(red);
      fields.add(green);
      fields.add(blue);
      add(fields, gbc); */
    }

    public void loadImageIcon(String filename) {
      try {
        if (fileName != "") {
          BufferedImage img = ImageIO.read(new File(fileName));
          labelImg.setIcon(new ImageIcon(img));
          labelImg.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
              try {
                int packedInt = img.getRGB(e.getX(), e.getY());
                Color color = new Color(packedInt, true);
                fields.setBackground(color);
                red.setText(Integer.toString(color.getRed()));
                green.setText(Integer.toString(color.getGreen()));
                blue.setText(Integer.toString(color.getBlue()));
              } catch (Exception exception) {

              }
            }
          });
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    public void buttonProperties(GridBagConstraints gbc) {
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 0;
      
      selFileButton = new JButton("...");
      selFileButton.setBounds(0,0, 15,15);
      
      add(selFileButton);
      selFileButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (selFileButton instanceof JButton) {
        DnaFileChooser dnFile = new DnaFileChooser(this);
        String selectedFileName = dnFile.getSelectedFile().getAbsolutePath();
        this.setFileName(selectedFileName);
        if (selectedFileName != "") {
          loadImageIcon(selectedFileName);
        }
      }
    }

  }

}