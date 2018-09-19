package com.example.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PDF2ImgUtil {

    private static Logger logger = LoggerFactory.getLogger(PDF2ImgUtil.class);

    public static int getPDFNum(String fileUrl) throws IOException {
        PDDocument pdDocument = null;
        int pages = 0;
        try {
            pdDocument = getPDDocument(fileUrl);
            pages = pdDocument.getNumberOfPages();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        } finally {
            if (pdDocument != null) {
                pdDocument.close();
            }
        }
        return pages;
    }


    /**
     * PDF转图片 根据页码一页一页转
     * @throws IOException
     * imgType:转换后的图片类型 jpg,png
     */
    public static void PDFToImg(OutputStream sos, String fileUrl, int page, String imgType) throws IOException {
        PDDocument pdDocument = null;
        /* dpi越大转换后越清晰，相对转换速度越慢 */
        int dpi = 100;
        try {
            pdDocument = getPDDocument(fileUrl);
            //2.0.1适用
            //PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pages = pdDocument.getNumberOfPages();
            if (page <= pages && page > 0) {
                //2.0.1适用
                //BufferedImage image = renderer.renderImageWithDPI(page,dpi);
                //ImageIO.write(image, imgType, sos);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        } finally {
            if (pdDocument != null) {
                pdDocument.close();
            }
        }

    }


    private static PDDocument getPDDocument(String fileUrl) throws IOException {
        File file = new File(fileUrl);
        FileInputStream inputStream = new FileInputStream(file);
        return PDDocument.load(inputStream);
    }

}
