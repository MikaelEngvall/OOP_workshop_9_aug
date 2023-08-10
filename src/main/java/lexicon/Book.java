package lexicon;

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

    // TODO: showPerson
    // TODO: Remove

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
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
}
