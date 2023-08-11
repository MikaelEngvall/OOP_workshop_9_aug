package lexicon;

import lexicon.model.Book;
import lexicon.model.Person;
import org.junit.Test;

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
    @Test
    public void showPersonWhoBorrowedIsTheCorrectBorrower(){

        Person person = new Person("Anders", "Loren");
        Book book = new Book("Pippi", "Astrid");
        person.loanBook(book, person);

        assertEquals(book.getBorrower().getFullName(), person.getFullName());

    }
}
