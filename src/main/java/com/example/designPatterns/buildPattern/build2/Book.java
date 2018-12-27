package com.example.designPatterns.buildPattern.build2;

public class Book {

    private final int bookId;

    private final String bookName;

    private final String bookMark;

    public static class Builder{
        private final int bookId;
        private String bookName = "jane love";
        private String bookMark = "favorite";

        public Builder(int bookId){
            this.bookId = bookId;
        }

        public Builder buildBookName(String bookName){
            this.bookName = bookName; return this;
        }

        public Builder buildBookMark(String bookMark){
            this.bookMark = bookMark; return this;
        }

        public Book build(){
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookMark='" + bookMark + '\'' +
                '}';
    }

    private Book(Builder builder){
        bookId = builder.bookId;
        bookName = builder.bookName;
        bookMark = builder.bookMark;
    }

}
