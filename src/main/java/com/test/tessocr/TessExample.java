
package com.test.tessocr;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

/**
 * A Hello World of Tess4j Example
 * @author whuang022ai
 * 
 */

public class TessExample {
    public static void main(String[] args) throws Exception {
        File imageFile = new File("b.png");//開啟檔案
        BufferedImage image = ImageIO.read(imageFile);
        ITesseract instance = new Tesseract();//JNA Interface
        instance.setLanguage("eng");//使用英文字庫
        image = preProcess(image);
        String result = instance.doOCR(image); //辨識API
        System.out.println(result);//印出返回結果
    }
    public static BufferedImage preProcess(BufferedImage image) throws Exception {
        image = ImageHelper.convertImageToGrayscale(image);//灰化
        image = ImageHelper.getScaledInstance(image, image.getWidth() * 3, image.getHeight() * 3);//放大三倍
        return image;
    }
}
