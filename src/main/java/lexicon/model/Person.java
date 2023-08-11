package lexicon.model;

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
        // Avoid names without real first- or lastnames
        if (firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("You must give the person a firstname and a lastname");
        setFirstName(firstName);
        setLastName(lastName);
        borrowedBooks = new String[0]; // person gets empty list for borrowing books
    }

    // *******
    // Methods
    // *******

    public void loanBook(Book book, Person person) {
        // Avoid books without real titles or authors
        if (book.getAuthor() == null || book.getAuthor().isEmpty() ||
                book.getTitle() == null || book.getTitle().isEmpty())
            throw new IllegalArgumentException("You must declare a title and author for the book");
        // If book isn't already loaned out, it can be borrowed
        if (book.isAvailable()) {
            String[] tempArray = new String[borrowedBooks.length + 1];
            // Already borrowed books should be copied before new list of borrowed books is created
            if (borrowedBooks.length != 0) {
                for (int i = 0; i < borrowedBooks.length; i++) {
                    tempArray[i] = borrowedBooks[i];
                }
            }
            // Separate title and author with comma, so they can be easily split later
            tempArray[tempArray.length - 1] =  book.getTitle() + "," + book.getAuthor();
            person.setBorrowedBooks(tempArray); // tempArray copied over to new list of borrowed books
            book.setBorrower(person); // person can now be identified as borrower
        } else {
            System.out.println("That book is not available.");
        }
    }
    public String getFullName() {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("You must declare a first name and a last for the person"); }
        else {
            return firstName + " " + lastName;
        }
    }
    public void displayBooks(Person person) {
        for (String element : borrowedBooks) {
//            System.out.println(element);
            System.out.println("Title: " + element.substring(0, element.indexOf(",")) +
                    ", Author: " + element.substring(element.indexOf(",") + 1));
        }
        if (borrowedBooks.length > 0) {
            System.out.println("Borrowed by: " + person.getFullName());
        }
    }
    public void removeBook(Book book, Person person) {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (book.getTitle().equals(borrowedBooks[i].substring(0, borrowedBooks[i].indexOf(","))) &&
                    book.getAuthor().equals(borrowedBooks[i].substring(borrowedBooks[i].indexOf(",")+1))) {
                borrowedBooks[i] = null;
                person.renewBorrowedBooks(person);
                break;
            }
        }
    }
    private void renewBorrowedBooks(Person person) {
        int counter = 0;
        String[] tempArray = new String[borrowedBooks.length - 1];
        if (borrowedBooks.length > 1) {
            for (int i = 0; i < borrowedBooks.length; i++) {
                if (borrowedBooks[i] != null) {
                    tempArray[counter] = borrowedBooks[i];
                }
            }
            person.setBorrowedBooks(tempArray);
        }
    }
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

