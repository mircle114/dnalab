package com.dnavault;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.net.URL;


public class ImageProcessing
{
   public ImageProcessing(){}

    private final static String IMAGE_PATH = "src/main/resources/";

    public static void main(String[] args) 
    {
      try
      {
        String imagePath = IMAGE_PATH;
        String imageFileName = "geek.jpg";
        // Read a image input
        BufferedImage newImg = ImageIO.read(new File(IMAGE_PATH + imageFileName));
        // Create your own image input from scratch
        BufferedImage img = new BufferedImage(256,256,BufferedImage.TYPE_INT_RGB);
        
        int rgb = newImg.getRGB(1,1);

        int width = newImg.getWidth(null);
        int height = newImg.getHeight(null);

        FileWriter writer = new FileWriter("pixel_values.txt");

        for (int y = 0; y < newImg.getHeight(); y++) {
         for (int x = 0; x < newImg.getWidth(); x++) {
            //Retrieving contents of a pixel
            int pixel = newImg.getRGB(x,y);
            //Creating a Color object from pixel value
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            writer.append(red+":");
            writer.append(green+":");
            writer.append(blue+"");
            writer.append("\n");
            writer.flush();
         }
      }
      writer.close();
        
        /*int[] rgbs = new int[width * height];
        newImg.getRGB(0,0,width,height,rgbs,0,width);

        System.out.println(String.valueOf(rgb));

        rgb = 0xFF00FF00; // green
        newImg.setRGB(1,1,rgb);

        System.out.println(String.valueOf(rgb));

        ImageIO.write(newImg, "JPG", new File(imagePath + "geek_crop.jpg"));
        */

        //int width = img.getWidth();
        //int height = img.getHeight();
        //BufferedImage croppedImg = cropImage(img, width/2, height/2, width/2, height/2);
        //ImageIO.write(croppedImg, "JPG", new File(imagePath + "geek_crops.jpg"));
      }
      catch(IOException e)
      {
          System.out.println(e.getMessage());
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