package com.example.entity;

public class Book {

    private int bookId;

    private String bookName;

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

    public String getBookMark() {
        return bookMark;
    }

    public void setBookMark(String bookMark) {
        this.bookMark = bookMark;
    }

    private String bookMark;

    public void myInit(){
        System.out.println("调用Book.class的 init方法");
    }

    public void myDestroy(){
        System.out.println("调用Book.class 的 destroy方法");
    }

}
