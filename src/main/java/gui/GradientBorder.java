package com.dnavault;

import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.GridBagConstraints;
import javax.swing.border.*;
import javax.swing.BorderFactory;

public class GradientBorder implements Border
{
    private Insets margin;

    public GradientBorder ( int top, int left, int bottom, int right )
    {
        super ();
        margin = new Insets ( top, left, bottom, right );
    }

    public void paintBorder (Component c, Graphics g, int x, int y, int width, int height )
    {
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setPaint ( new GradientPaint ( x, y, Color.gray, x + width, y, Color.black ) );

        Area border = new Area ( new Rectangle ( x, y, width, height ) );
        border.subtract ( new Area ( new Rectangle ( x + margin.left, y + margin.top,
                width - margin.left - margin.right, height - margin.top - margin.bottom ) ) );
        g2d.fill ( border );
    }

    public Insets getBorderInsets ( Component c )
    {
        return margin;
    }

    public boolean isBorderOpaque ()
    {
        return true;
    }
}