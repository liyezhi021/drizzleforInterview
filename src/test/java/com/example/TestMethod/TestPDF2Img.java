package com.example.TestMethod;

import com.example.utils.PDF2ImgUtil;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TestPDF2Img {

    public static void main(String args[]){
        String fileUrl = "/home/payne/Documents/BLRZ.pdf";
        String needType = "png";
        int currentPage = 1;
        File f = new File("/home/payne/Documents/test1.png");
        try{
            int pages = PDF2ImgUtil.getPDFNum(fileUrl);
            OutputStream sos = null;
            sos = new FileOutputStream(f);
            PDF2ImgUtil.PDFToImg(sos,fileUrl,currentPage,needType);
            System.out.println("transfer ok!");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
