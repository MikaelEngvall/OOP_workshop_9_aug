package lexicon;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

public class PersonTest {
    @ParameterizedTest
    @CsvSource(value={
            "null, Loren, Pippi, Astrid",
            ", Loren, Pippi, Astrid",
            "Anders, null, Pippi, Astrid",
            "Anders, , Pippi, Astrid",
            "Anders, Loren, null, Astrid",
            "Anders, Loren, , Astrid",
            "Anders, Loren, Pippi, null",
            "Anders, Loren, Pippi,",
            },nullValues={"null"})
    public void loanBooksThrowsIfNullOrEmptyStringInBookOrPerson(String title, String author, String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        Book book = new Book(title, author);

        assertThrows(
                IllegalArgumentException.class,
                () -> person.loanBook(book, person)
        );
    }
    @ParameterizedTest
    @CsvSource({
            "Pippi, Astrid, Anders, Loren"
    })
    public void loanBooksAvailable(String title, String author, String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        Book book = new Book(title, author);

        Assertions.assertTrue(book.isAvailable());
    }

    @ParameterizedTest
    @CsvSource({
            "Pippi, Astrid, Anders, Loren"
    })
    public void loanBookAddsToBorrowedBooks(String title, String author, String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        Book book = new Book(title, author);

        person.loanBook(book, person);

        System.out.println(person.getBorrowedBooks()[0]);
    }

    @ParameterizedTest
    @CsvSource({
            "Pippi, Astrid, Anders, Loren"
    })
    public void loanBookAvailableFalseIfBookAlreadyLend(String title, String author, String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        Book book = new Book(title, author);

        person.loanBook(book, person);

        Assertions.assertFalse(book.isAvailable());
    }
}
