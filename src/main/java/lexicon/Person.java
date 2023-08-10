package lexicon;

import java.sql.SQLOutput;

public class Person {
    // ***************
    // Instance Fields
    // ***************

    private String firstName;
    private String lastName;
    private Integer personId;
    private String[] borrowedBooks;

    // **************
    // Constructor(s)
    // **************

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        borrowedBooks = new String[0];
    }

    // *******
    // Methods
    // *******

    // TODO: loanBook

    public void loanBook(Book book, Person person) {
        // Throw exception if null
        if (book.getAuthor() == null || book.getAuthor().equals("") ||
            book.getTitle() == null || book.getTitle().equals(""))
            throw new IllegalArgumentException("You must declare a title and author for the book");
        else if
            (person.getFirstName() == null || person.getFirstName().equals("") ||
            person.getLastName() == null || person.getLastName().equals(""))
            throw new IllegalArgumentException("You must declare a first name and a last name for the borrower");
//         Print out if available == false
        if (book.isAvailable()) {
            String[] tempArray = new String[borrowedBooks.length + 1];
            tempArray[tempArray.length - 1] = "Author: " + book.getAuthor() + ", Title: " + book.getTitle();
            person.setBorrowedBooks(tempArray);
            book.setBorrower(person);
        } else {
            System.out.println("That book is not available.");
        }
    }

    // TODO: displayBooks

    // *****************
    // Getters & Setters
    // *****************


    public String[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(String[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


