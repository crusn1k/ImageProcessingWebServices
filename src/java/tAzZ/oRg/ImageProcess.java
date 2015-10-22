/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tAzZ.oRg;


import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author n1sh1kanT
 */
@WebService(serviceName="ImageProcess")
public class ImageProcess {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "gogogo")
    public byte[] gogogo(@WebParam(name = "image")
    String image, @WebParam(name = "effect")
    String effect)throws Exception {
        //System.out.print("Called");
        Processor p=new Processor();
        /*
         * Convert the received image which is
         * in string format into bufferedimage
         * so that it cant be processed by the
         * methods provided in the processor
         * class
         */
        byte[] asd=Base64.decode(image);
        BufferedImage src=null;
        ByteArrayInputStream bin=new ByteArrayInputStream(asd);
        src =ImageIO.read(bin);
        /*
         * create an image to save the processed image
         */
        BufferedImage dest=null;
        /*
         * find out the effect requested by the user
         * so that the image can be appropriately
         * processed
         */
        if(effect.equalsIgnoreCase("negative"))dest=p.negetive(src);
        if(effect.equalsIgnoreCase("sobel"))dest=p.sobel(src);
        if(effect.equalsIgnoreCase("blur"))dest=p.aBlur(src);
        if(effect.equalsIgnoreCase("mirror"))dest=p.mirror(src);
        if(effect.equalsIgnoreCase("shrink"))dest=p.shrink(src);
        if(effect.equalsIgnoreCase("scale"))dest=p.scale(src);
        byte[] data=new byte[image.length()];
        /*
         * the response of the processor's methods
         * is an image. it is then converter to a byte
         * array so that it can be returned
         */
        ByteArrayOutputStream bA=new ByteArrayOutputStream();
        ImageIO.write(dest, "jpg", bA);
        data=bA.toByteArray();
        String res=Base64.encode(data);
        //ImageIO.write(src, "jpg", new File("C:/asdf000.jpg"));
        return data;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "gogogo_1")
    @RequestWrapper(className = "tAzZ.gogogo_1")
    @ResponseWrapper(className = "tAzZ.gogogo_1Response")
    public byte[] gogogo(@WebParam(name = "image1")
    String image1, @WebParam(name = "image2")
    String image2, @WebParam(name = "effect")
    String effect) throws Exception{
        System.out.println("m called thsi time");
       Processor p=new Processor();
        byte[] bimage1=Base64.decode(image1);
        byte[] bimage2=Base64.decode(image2);
        BufferedImage src1=null,src2=null;
        ByteArrayInputStream bin=new ByteArrayInputStream(bimage1);
        src1 =ImageIO.read(bin);
        bin.close();
        bin=new ByteArrayInputStream(bimage2);
        src2=ImageIO.read(bin);
        BufferedImage dest=null;
        dest=p.panorama(src1,src2);
        byte[] data=new byte[image1.length()+image2.length()];
        ByteArrayOutputStream bA=new ByteArrayOutputStream();
        ImageIO.write(dest, "jpg", bA);
        data=bA.toByteArray();
        String res=Base64.encode(data);
        //ImageIO.write(src, "jpg", new File("C:/asdf000.jpg"));
        return data;
    }
}
