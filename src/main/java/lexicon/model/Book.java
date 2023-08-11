package lexicon.model;

import java.util.UUID;

public class Book {

    // ***************
    // Instance Fields
    // ***************

    private String title;
    private String author;
    private String bookId;
    private boolean available = true;
    private Person borrower;

    // **************
    // Constructor(s)
    // **************

    public Book() {
        setBookId();
        this.available = true;
    }

    public Book(String title, String author) {
        this();
        setTitle(title);
        setAuthor(author);
    }

    // *******
    // Methods
    // *******

    public Person showPerson(Book book){ // Seems to be redundant, we can just use book.getBorrower()
        return book.getBorrower();
    }

    // *****************
    // Getters & Setters
    // *****************

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        if (borrower != null) {
            this.available = false;
        }
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId() {
        this.bookId = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }
}