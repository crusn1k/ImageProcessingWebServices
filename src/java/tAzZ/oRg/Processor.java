/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tAzZ.oRg;

import java.awt.image.BufferedImage;

/**
 *
 * @author n1sh1kanT
 */
public class Processor {
    public static int getBlue(int a)
    {
       // System.out.println("blue:"+" " + (a & 0xff));
        return a & 0xff;
    }
    public static int getred(int a)
    {
       // System.out.println("red:"+" " +(a>>16 & 0xff) );
        return a>>16 & 0xff;
    }
    public static int getgreen(int a)
    {
       // System.out.println("green:"+" " +(a>>8 & 0xff));
        return a>>8 & 0xff;
    }
public BufferedImage negetive(BufferedImage src) 
{
     BufferedImage dest=new BufferedImage(src.getWidth(),src.getHeight(),BufferedImage.TYPE_INT_RGB);

                for(int w=0;w<src.getWidth();w++){
                    for(int h=0;h<src.getHeight();h++) {
                        int temp=src.getRGB(w,h);
                        int red=255-(temp >> 16 & 0xff);
                        int green=255-(temp >> 8 & 0xff);
                        int blue=255-(temp & 0xff);
                        int alpha=temp>>24 & 0xff;
                        temp=alpha<<24|red<<16|green<<8|blue;
                        dest.setRGB(w,h,temp);
                    }

                }
                return dest;
}
public BufferedImage mirror(BufferedImage src) 
{
     BufferedImage dest=new BufferedImage(src.getWidth(),src.getHeight(),BufferedImage.TYPE_INT_RGB);

                int w1=src.getWidth()-1;
                for(int w=0;w<src.getWidth();w++){
                    for(int h=0;h<src.getHeight();h++) {
                        dest.setRGB(w1, h, src.getRGB(w, h));
                    }
                    w1--;
                }
                return dest;
}
/**
 * 
 * @param src
 * @return
 */
public BufferedImage aBlur(BufferedImage src) 
{
     BufferedImage dest=new BufferedImage(src.getWidth(),src.getHeight(),BufferedImage.TYPE_INT_RGB);

               for(int w=1;w<src.getWidth()-1;w++)
                    for(int h=1;h<src.getHeight()-1;h++) {
                        int red = getred(src.getRGB(w-1, h-1))*1+getred(src.getRGB(w-1, h))*1+getred(src.getRGB(w-1, h+1))*1+getred(src.getRGB(w, h-1))*1+getred(src.getRGB(w, h))*1+getred(src.getRGB(w,h+1))*1+getred(src.getRGB(w+1, h-1))*1+getred(src.getRGB(w+1, h))*1+getred(src.getRGB(w+1, h+1))*1;
                        int green = getgreen(src.getRGB(w-1, h-1))*1+getgreen(src.getRGB(w-1, h))*1+getgreen(src.getRGB(w-1, h+1))*1+getgreen(src.getRGB(w, h-1))*1+getgreen(src.getRGB(w, h))*1+getgreen(src.getRGB(w,h+1))*1+getgreen(src.getRGB(w+1, h-1))*1+getgreen(src.getRGB(w+1, h))*1+getgreen(src.getRGB(w+1, h+1))*1;
                        int blue = getBlue(src.getRGB(w-1, h-1))*1+getBlue(src.getRGB(w-1, h))*1+getBlue(src.getRGB(w-1, h+1))*1+getBlue(src.getRGB(w, h-1))*1+getBlue(src.getRGB(w, h))*1+getBlue(src.getRGB(w,h+1))*1+getBlue(src.getRGB(w+1, h-1))*1+getBlue(src.getRGB(w+1, h))*1+getBlue(src.getRGB(w+1, h+1))*1;
                        int alpha=src.getRGB(w,h)>>24 & 0xff;
                        red/=9;
                        blue/=9;
                        green/=9;
                        dest.setRGB(w, h,alpha<<24|red<<16|green<<8|blue );

                    }

                
                return dest;
}
public BufferedImage sobel(BufferedImage src) 
{
     BufferedImage dest=new BufferedImage(src.getWidth(),src.getHeight(),BufferedImage.TYPE_INT_RGB);
    int[][] jmage=new int[src.getWidth()][src.getHeight()];
    int red=0,green=0,blue=0,bluex=0,bluey=0,redx=0,redy=0,greenx=0,greeny=0;
                 for(int j=1;j<=src.getWidth()-2;j++)
                for(int k=1;k<=src.getHeight()-2;k++) {
                    int temps=0;
                    jmage[j][k]=src.getRGB(j, k);
                    bluex = (getBlue(jmage[j-1][k-1])*-1
                            +getBlue(jmage[j-1][k+1])*-1
                            +getBlue(jmage[j-1][k])*-2
                            +getBlue(jmage[j+1][k-1])*1
                            +getBlue(jmage[j+1][k+1])*1
                            +getBlue(jmage[j+1][k])*2
                            +getBlue(jmage[j][k-1])*0
                            +getBlue(jmage[j][k+1])*0
                            +0*getBlue(jmage[j][k]));

                    bluey = (getBlue(jmage[j-1][k-1])*-1
                            +getBlue(jmage[j-1][k+1])*1
                            +getBlue(jmage[j-1][k])*0
                            +getBlue(jmage[j+1][k-1])*-1
                            +getBlue(jmage[j+1][k+1])*1
                            +getBlue(jmage[j+1][k])*0
                            +getBlue(jmage[j][k-1])*-2
                            +getBlue(jmage[j][k+1])*2
                            +0*getBlue(jmage[j][k]));
                    blue=(int)Math.sqrt(bluex*bluex+bluey*bluey);

                    redx = (getred(jmage[j-1][k-1])*-1
                            +getred(jmage[j-1][k+1])*-1
                            +getred(jmage[j-1][k])*-2
                            +getred(jmage[j+1][k-1])*1
                            +getred(jmage[j+1][k+1])*1
                            +getred(jmage[j+1][k])*2
                            +getred(jmage[j][k-1])*0
                            +getred(jmage[j][k+1])*0
                            +0*getred(jmage[j][k]));

                    redy = (getred(jmage[j-1][k-1])*-1
                            +getred(jmage[j-1][k+1])*1
                            +getred(jmage[j-1][k])*0
                            +getred(jmage[j+1][k-1])*-1
                            +getred(jmage[j+1][k+1])*1
                            +getred(jmage[j+1][k])*0
                            +getred(jmage[j][k-1])*-2
                            +getred(jmage[j][k+1])*2
                            +0*getred(jmage[j][k]));
                    red=(int)Math.sqrt(redx*redx+redy*redy);
                    greenx = (getgreen(jmage[j-1][k-1])*-1
                            +getgreen(jmage[j-1][k+1])*-1
                            +getgreen(jmage[j-1][k])*-2
                            +getgreen(jmage[j+1][k-1])*1
                            +getgreen(jmage[j+1][k+1])*1
                            +getgreen(jmage[j+1][k])*2
                            +getgreen(jmage[j][k-1])*0
                            +getgreen(jmage[j][k+1])*0
                            +0*getgreen(jmage[j][k]));

                    greeny = (getgreen(jmage[j-1][k-1])*-1
                            +getgreen(jmage[j-1][k+1])*1
                            +getgreen(jmage[j-1][k])*0
                            +getgreen(jmage[j+1][k-1])*-1
                            +getgreen(jmage[j+1][k+1])*1
                            +getgreen(jmage[j+1][k])*0
                            +getgreen(jmage[j][k-1])*-2
                            +getgreen(jmage[j][k+1])*2
                            +0*getgreen(jmage[j][k]));

                    green=(int)Math.sqrt(greenx*greenx+greeny*greeny);
                    if(red>255)red=255;
                    if(red<0)red=0;
                    if(green>255)green=255;
                    if(green<0)green=0;
                    if(blue>255)blue=255;
                    if(blue<0)blue=0;


                    int alpha=src.getRGB(j,k)>>24 & 0xff;
                    int color=alpha << 24 | red << 16 | green << 8 | blue;
                    dest.setRGB(j,k,color);
                }
                return dest;
}
public BufferedImage shrink(BufferedImage src)
{
    int pass=0;
    BufferedImage dest =new BufferedImage(src.getWidth()/2,src.getHeight()/2,BufferedImage.TYPE_INT_RGB);
    for(int i=0;i<src.getHeight()/2;i++) {
                    for(int j=0;j<src.getWidth()/2;j++) {
                        dest.setRGB(j, i,src.getRGB(j*2,i*2));
                        pass++;
                    }

                }
    return dest;
}
public BufferedImage scale(BufferedImage src)
{
    BufferedImage dest =new BufferedImage(src.getWidth()/2,src.getHeight()/2,BufferedImage.TYPE_INT_RGB);
    int row=0,col=0;
                int pass=0;
                for(int i=0;i<src.getHeight();i++) {
                    for(int j=0;j<src.getWidth();j++) {
                        for(int count1=0;count1<2;count1++)
                            for(int count2=0;count2<2;count2++) {
                                dest.setRGB(row*2+count1,col*2+count2 , src.getRGB(j, i));
                                pass++;
                            }
                        row++;
                    }
                    row=0;
                    col++;
                }
    return dest;
}
public BufferedImage panorama(BufferedImage src1,BufferedImage src2)
    {
    BufferedImage dest=new BufferedImage(src1.getWidth()+src2.getWidth(),src1.getHeight(),BufferedImage.TYPE_INT_RGB);
    int w=src1.getWidth();
    int h=src1.getHeight();
     for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
            {
                dest.setRGB(j, i,src1.getRGB(j, i));

            }
         for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
            {
                dest.setRGB(w+j, i,src2.getRGB(j, i));
            }
    return dest;
}
}
