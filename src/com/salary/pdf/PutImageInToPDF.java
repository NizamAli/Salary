/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salary.pdf;

/**
 *
 * @author Hari
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.net.URL;
import java.io.FileOutputStream;

public class PutImageInToPDF {
  public static void main(String[] args) {
    Document document = new Document();

    try {
        PdfWriter.getInstance(document,
                new FileOutputStream("/Users/alinizam/Documents/Image1.pdf"));
        document.open();

        Image image = Image.getInstance("/images/Nizam.jpeg");
        image.setAbsolutePosition(500f, 650f);
        document.add(image);
        document.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}