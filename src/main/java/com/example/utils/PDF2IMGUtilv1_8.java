package com.example.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PDF2IMGUtilv1_8 {

    public static void PDFToImg(String fileUrl ) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMDD");
        String format_today = formatter.format(new Date());
        System.out.println("----------------->"+format_today);
        File imageFile = new File("/home/payne/Documents/pdf2img/img");
        File imageFileParent = new File(imageFile.getParent());
        List<File> files = new ArrayList<>();
        OutputStream output = null;
        try {
            if(!imageFileParent.exists())  imageFileParent.mkdirs();

            PDDocument pdDocument = getPDDocument(fileUrl);
            List pages = pdDocument.getDocumentCatalog().getAllPages();
            for(int i = 0;i<pages.size(); i++){
                PDPage page = (PDPage)pages.get(i);
                BufferedImage image = page.convertToImage();
                Iterator iter = ImageIO.getImageWritersBySuffix("png");
                ImageWriter writer = (ImageWriter)iter.next();
                File tempFile = new File(imageFileParent.getPath(),i+imageFile.getName());
                files.add(tempFile);
                output = new FileOutputStream(tempFile);
                ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
                writer.setOutput(imageOut);
                writer.write(new IIOImage(image,null,null));
                output.close();
            }
            pdDocument.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static PDDocument getPDDocument(String fileUrl) throws IOException {
        File file = new File(fileUrl);
        FileInputStream inputStream = new FileInputStream(file);
        return PDDocument.load(inputStream);
    }

}
