package com.dnavault;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;

class ImageComponent extends Component 
{
  private BufferedImage bImage;
  
  public BufferedImage getBufferedImage()
  {
    return this.bImage;
  }

  private void setBufferedImage(BufferedImage bImage)
  {
    this.bImage = bImage;
  }

  public void paint(Graphics g) 
  {
      //g.setColor(Color.BLUE);
      try
      {
          g.drawImage(bImage, 0, 0, this);
          //this.writeImage('A', bImage);
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
    
  }

  public ImageComponent(Dimension dimensions) throws IOException
  {
        // img = ImageIO.read(new File(path));
        bImage = new BufferedImage(dimensions.width,dimensions.height,BufferedImage.TYPE_INT_RGB);
        setBufferedImage(bImage);
        Graphics2D imageGraphics = bImage.createGraphics();
        
        
        try
        {
            for(int x = 0; x < bImage.getWidth(); x++)
            {
                for(int y = 0; y < bImage.getHeight(); y++)
                {
                  bImage.setRGB(x, y,  y % 2 == 0 ? Color.RED.getRGB() : Color.WHITE.getRGB());
                }
            }
            ImageIO.write(bImage,"PNG",new File("src/main/resources/dnasnapshot.png"));
        }
        catch(Exception e) 
        {
            System.out.println("cannot create the file");
            e.printStackTrace();
        }
  }

  public Dimension getPreferredSize() {
    if (bImage == null) 
    {
      System.out.println("Default");
      return new Dimension(100, 100);
    } 
    else 
    {
      return new Dimension(bImage.getWidth(), bImage.getHeight());
    }
  }
}