package com.example.designPatterns.prototypePattern;

import java.io.*;

public class BookFacade implements Cloneable, Serializable{

    private static final long serialVersionUID = 1L;

    private int bookId;

    private String bookName;

    private BookMarks bookMarks;

    //浅复制
    public Object shallowClone(){
        BookFacade bf = null;
        try {
            bf = (BookFacade) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bf;
    }

    //深复制
    public Object deepClone(BookFacade bf) throws IOException, ClassNotFoundException{
        //写入当前对象二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(bf);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookMarks getBookMarks() {
        return bookMarks;
    }

    public void setBookMarks(BookMarks bookMarks) {
        this.bookMarks = bookMarks;
    }

    static class BookMarks implements Serializable{
        private static final long serialVersionUID = 2L;
        private String tagName;
        private Integer pageNumber;

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public Integer getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }
    }

}