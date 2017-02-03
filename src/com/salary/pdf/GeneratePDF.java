/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salary.pdf;

/**
 *
 * @author Hari
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.salary.certificate.SalaryDto;


public class GeneratePDF {
	private static String FILE = "/Users/alinizam/Documents/GeneratePDF123.pdf";
        private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                        Font.BOLD);
        private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.NORMAL, BaseColor.RED);
        private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
                        Font.BOLD);
        private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.BOLD);

        public static void main(String[] args) {
                try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        document.open();
                        addTitlePage(document);
                        document.close();
                        System.out.println("Saved");
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

       
       
        private static void addTitlePage(Document document)
                        throws DocumentException, MalformedURLException, IOException {
            
              // adding header
        	Paragraph preface = new Paragraph();
                addEmptyLine(preface, 1);
                preface.setAlignment(Element.ALIGN_CENTER);
                preface.add(new Paragraph("SALARY CERTIFICATE", catFont));
                addEmptyLine(preface, 1);
                document.add(preface);
                
                // adding image
                Image image = Image.getInstance("/Users/alinizam/Documents/Nizam.jpeg");
                image.setAbsolutePosition(450f, 700f);
                image.scaleAbsolute(100, 100);
                document.add(image);
                java.util.List<SalaryDto> salDtoLst = new ArrayList<SalaryDto>();
                SalaryDto salDto= new SalaryDto();
                salDto.setName("Nizam");
                salDtoLst.add(salDto);
                
                SalaryDto salDto1= new SalaryDto();
                salDto1.setName("Hari");
                salDtoLst.add(salDto1);
                
                SalaryDto salDto2= new SalaryDto();
                salDto2.setName("Navas");
                salDtoLst.add(salDto2);
                
                SalaryDto salDto3= new SalaryDto();
                salDto3.setName("Ali");
                salDtoLst.add(salDto3);
                
              for(SalaryDto strSal : salDtoLst){
                 Paragraph name1 = new Paragraph();
                addEmptyLine(name1, 1);
                name1.setAlignment(Element.ALIGN_LEFT);
                name1.add(new Paragraph("NAME :      "+strSal.getName(),smallBold));
                document.add(name1); 
              }
                
                LineSeparator ls = new LineSeparator();
                document.add(new Chunk(ls));
                
                Paragraph name2 = new Paragraph();
                addEmptyLine(name2, 1);
                name2.setAlignment(Element.ALIGN_LEFT);
                name2.add(new Paragraph("NAME :     Jagan   "+"      NAME :     Shaik ",smallBold));
                document.add(name2);
                Paragraph name3 = new Paragraph();
                addEmptyLine(name3, 1);
                name3.setAlignment(Element.ALIGN_LEFT);
                name3.add(new Paragraph("NAME :     Jagan   "+"      NAME :     Shaik ",smallBold));
                document.add(name3);
                Paragraph name4 = new Paragraph();
                addEmptyLine(name4, 1);
                name4.setAlignment(Element.ALIGN_LEFT);
                name4.add(new Paragraph("NAME :     Jagan   "+"      NAME :     Shaik ",smallBold));
                document.add(name4);

        }
        private static void addEmptyLine(Paragraph paragraph, int number) {
                for (int i = 0; i < number; i++) {
                        paragraph.add(new Paragraph(" "));
                }
        }
}