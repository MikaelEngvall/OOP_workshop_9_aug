package lexicon;

import lexicon.model.Book;
import lexicon.model.Person;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class BookTest {

    @Test
    @DisplayName("When new book is created, it gets a random book Id")
    public void setBookId() {
        Book book = new Book();
        System.out.println(book.getBookId());
    }

    @Test
    @DisplayName("Prints out all 'book' and 'person' constructor values")
    public void createBookObjectPrintOutWithoutErrors() {
        Person person = new Person("Anders", "Loren");
        Book book = new Book("Pippi", "Astrid");

        System.out.println("bookId: " + book.getBookId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                "; Borrower { " + person.getFirstName() + " " + person.getLastName() + " }");
    }

    @Test
    @DisplayName("New book sets it's availability to true")
    public void createBookObjectSetsAvailableForThatBookToTrue() {

        Person person = new Person("Anders", "Loren");
        Book book = new Book("Pippi", "Astrid");

        Assertions.assertTrue(book.isAvailable());
    }
}