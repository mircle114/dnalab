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
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
//import javax.swing.border.Border;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class ImageProcessing
{
   public ImageProcessing(){}

    public static void main(String[] args) 
    {
        try
        {
          File imageFile = new File("src/main/resources/dnasnapshot.png");
          BufferedImage bufferedImage = ImageIO.read(imageFile);
          BufferedImage cropped = cropImage(bufferedImage,0, bufferedImage.getWidth()  /2,   
           bufferedimage.getWidth() /2, bufferedimage.getHeight()/2);
          File pathFile = new File("src/main/resources/pngimage-crop.jpg");
          ImageIO.write(bufferedImage,"jpg", pathFile);

          
        }
        catch(Exception e)
        {
            System.out.println("ImageProcessing.main()");
        }
        
    }

    /**
  * Crops an image to the specified region
  * @param bufferedImage the image that will be crop
  * @param x the upper left x coordinate that this region will start
  * @param y the upper left y coordinate that this region will start
  * @param width the width of the region that will be crop
  * @param height the height of the region that will be crop
  * @return the image that was cropped.
  */
  public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height)
  {
      BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
      return croppedImage;
  }
}