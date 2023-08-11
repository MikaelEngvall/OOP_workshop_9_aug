package lexicon;

import lexicon.model.Book;
import lexicon.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class PersonTest {
    @ParameterizedTest
    @DisplayName("Person(), Throws if any parameter of book is 'null or 'empty")
    @CsvSource(value = {
            "null, Loren",
            ", Loren",
            "Anders, null",
            "Anders, "
    }, nullValues = {"null"})
    public void personThrowsIfNullOrEmptyStringInPerson(String firstName, String lastName) {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Person(firstName, lastName));
    }

    @ParameterizedTest
    @DisplayName("Loan method: (1) Throws if any parameter of book is 'null or 'empty'")
    @CsvSource(value = {
            "Anders, Loren, null, Astrid",
            "Anders, Loren, , Astrid",
            "Anders, Loren, Pippi, null",
            "Anders, Loren, Pippi,"
    }, nullValues = {"null"})
    public void loanBooksThrowsIfNullOrEmptyStringInBook(String firstName, String lastName, String title, String author) {
        Person person = new Person(firstName, lastName);
        Book book = new Book(title, author);

        assertThrows(
                IllegalArgumentException.class,
                () -> person.loanBook(book, person)
        );
    }

    @ParameterizedTest
    @DisplayName("Loan method: (2) When a book is created, it is available")
    @CsvSource({
            "Pippi, Astrid"
    })
    public void loanBooksAvailable(String title, String author) {
        Book book = new Book(title, author);

        Assertions.assertTrue(book.isAvailable());
    }

    // TODO: When book is already borrowed, copy of test above should fail

    @ParameterizedTest
    @DisplayName("Loan method: (3) When book is borrowed, borrower becomes person")
    @CsvSource({
            "Pippi, Astrid, Anders, Loren"
    })
    public void loanBookAddsToBorrowedBooks(String title, String author, String firstname, String lastName) {
        Person person = new Person(firstname, lastName);
        Book book = new Book(title, author);

        person.loanBook(book, person);

        Assertions.assertEquals(book.getBorrower().getFullName(), person.getFullName());
    }

    @ParameterizedTest
    @DisplayName("When book is borrowed, it is not available")
    @CsvSource({
            "Pippi, Astrid, Anders, Loren"
    })
    public void loanBookAvailableFalseIfBookAlreadyLend(String title, String author, String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        Book book = new Book(title, author);

        person.loanBook(book, person);

        Assertions.assertFalse(book.isAvailable());
    }

    @ParameterizedTest
    @DisplayName("Displays books person has borrowed")
    @CsvSource({
            "Pippi,Astrid,Anders,Loren",
            "Millenium,Larsson,Anders,Loren"
    })
    public void displayBooksPrintsOutBooksPersonHasBorrowed(String title, String author, String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        Book book = new Book(title, author);

        person.loanBook(book, person);

        person.displayBooks(person);
    }

    @ParameterizedTest
    @DisplayName("Remove book from borrowed books, prints out list before and after")
    @CsvSource({
            "Anders, Loren, Pippi, Astrid, Millenium, Larsson"
    })
    public void removeBookShouldReturnNullOnRow1(String firstName, String lastName, String title1, String author1, String title2, String author2) {
        Person person = new Person(firstName, lastName);
        Book book1 = new Book(title1, author1);
        Book book2 = new Book(title2, author2);

        person.loanBook(book1, person);
        person.loanBook(book2, person);

        person.displayBooks(person);

        person.removeBook(book1, person);

        person.displayBooks(person);
    }
}