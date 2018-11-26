package com.example.TestMethod;

import com.example.utils.PDF2IMGUtilv1_8;

public class TestPDF2IMG1_8 {

    public static void main(String[] args) {
        String fileUrl = "/home/payne/Documents/BLRZ.pdf";
        try {
            System.out.println(">>>>>>>Transfer Start");
            PDF2IMGUtilv1_8.PDFToImg(fileUrl);
            System.out.println(">>>>>>>Transfer End!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
