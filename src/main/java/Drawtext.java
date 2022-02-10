package com.dnavault;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Drawtext {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      /*  f.setSize(500,500);
        
        
        BufferedImage image = new BufferedImage(1, 1,
            BufferedImage.TYPE_INT_RGB);
        Graphics2D imageGraphics = image.createGraphics();
        //GradientPaint gp = new GradientPaint(20f, 20f, Color.blue, 360f, 90f,Color.magenta);
        //imageGraphics.setPaint(gp);
        imageGraphics.fillRect(0, 0, 400, 300);

        JLabel textLabel = new JLabel("æ");
        textLabel.setSize(textLabel.getPreferredSize());

        Dimension d = textLabel.getPreferredSize();
       
        BufferedImage bi = new BufferedImage(d.width, d.height,
            BufferedImage.TYPE_INT_ARGB);
        
        Graphics g = bi.createGraphics();
        g.setColor(new Color(255, 200, 255, 128));
        g.fillRoundRect(0, 0, bi.getWidth(f), bi.getHeight(f), 105, 100);
        g.setColor(Color.black);
        
        textLabel.paint(g);
        
        
        Graphics g2 = image.getGraphics();
        g2.drawImage(bi, 200, 20, f);

        ImageIcon ii = new ImageIcon(image);
        JLabel imageLabel = new JLabel(ii);

        f.getContentPane().add(imageLabel);
*/
       
        f.pack();

        f.setVisible(true);
      }
    });
  }
}