/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tAzZ.oRg;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 *
 * @author n1sh1kanT
 */
public class Disp extends javax.swing.JFrame {
BufferedImage src;
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2=(Graphics2D) src.getGraphics();
        //g.drawString(Integer.toString(src.getWidth()), 100, 100);
        Image image=Toolkit.getDefaultToolkit().createImage(src.getSource());
        g.drawImage(image,0,0,null);
    }
}
