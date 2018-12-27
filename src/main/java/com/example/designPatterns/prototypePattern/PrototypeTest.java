package com.example.designPatterns.prototypePattern;

import com.example.entity.Address;

import java.io.IOException;

public class PrototypeTest {

    public static void main(String[] args){

        BookFacade bf = new BookFacade();
        bf.setBookId(1);
        bf.setBookName("book_1");
        BookFacade.BookMarks bm = new BookFacade.BookMarks();
        bm.setTagName("mark_1");
        bm.setPageNumber(355);
        bf.setBookMarks(bm);
        BookFacade bf_shallow = (BookFacade) bf.shallowClone();
        BookFacade bf_deep = null;
        BookFacade clo = bf.clone();
        try {
            bf_deep = (BookFacade) bf.deepClone(bf);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println((bf_shallow==bf)); //false
        System.out.println((bf_shallow.getClass()==bf.getClass())); //true
        System.out.println((bf_deep==bf));//false
        System.out.println((bf_deep.getClass()==bf.getClass()));//true
        System.out.println("bf...bookMakes pre-->"+ bf.getBookMarks().getTagName());
        System.out.println("bf_shallow...bookMakes pre-->"+ bf_shallow.getBookMarks().getTagName());
        System.out.println("bf_deep...book name pre-->"+ bf_deep.getBookMarks().getTagName());
        System.out.println("clone...book name pre-->"+ clo.getBookMarks().getTagName());
        bm.setTagName("make_2");
        System.out.println("bf...bookMakes after-->"+ bf.getBookMarks().getTagName());
        System.out.println("bf_shallow...bookMakes after-->"+ bf_shallow.getBookMarks().getTagName());
        System.out.println("bf_deep...book name after-->"+ bf_deep.getBookMarks().getTagName());
        System.out.println("clone...book name after-->"+ clo.getBookMarks().getTagName());
    }

}
