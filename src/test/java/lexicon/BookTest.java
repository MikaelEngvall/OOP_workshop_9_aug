package lexicon;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized;

import java.util.UUID;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void setBookId() {
        Book book = new Book();
        System.out.println(book.getBookId());
    }

    @Test
    public void createBookObjectPrintOutWithoutErrors() {
        Person person = new Person("Anders", "Loren");
        Book book = new Book("Pippi", "Astrid");

        System.out.println("bookId: " + book.getBookId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                "; Borrower { " + person.getFirstName() + " " + person.getLastName() + " }");
    }

    @Test
    public void createBookObjectSetsAvailableForThatBookToFalse() {

        Person person = new Person("Anders", "Loren");
        Book book = new Book("Pippi", "Astrid");

        assertTrue(book.isAvailable());
    }
}
