package lexicon;

import lexicon.model.Book;
import lexicon.model.Person;

/**
 * Mini Library Application
 *
 */
public class App
{
    public static void main( String[] args ) {
        // Create person object
        Person person = new Person("Anders", "Loren");
        Person mikael = new Person("Mikael", "Engvall");

        // Create book object
        Book book1 = new Book("Pippi", "Astrid");
        Book book2 = new Book("Millenium", "Stieg");
        Book book3 = new Book("Karlsson", "Lindgren");

        // person borrows the book
        System.out.println("loanBook method");
        person.loanBook(book1, person);
        person.loanBook(book2, person);
        mikael.loanBook(book2, mikael); //Mikael försöker låna Millenium men den är inte tillgänglig
        mikael.loanBook(book3, mikael); //Mikael lånar Karlsson

        System.out.println("\n");

        // display books
        System.out.println("displayBooks");
        person.displayBooks(person);
        mikael.displayBooks(mikael);

        System.out.println("\n");


        // show person
        System.out.println("showPerson");
        System.out.println(book1.getTitle() + " borrowed by " + book1.getBorrower().getFullName());
        System.out.println(book2.getTitle() + " borrowed by " + book2.getBorrower().getFullName());
        System.out.println(book3.getTitle() + " borrowed by " + book3.getBorrower().getFullName());

        System.out.println("\n");

        // remove books
        System.out.println("removeBooks");
        person.removeBook(book1, person);

        System.out.println("\n");

        // display books
        System.out.println("displayBooks");
        person.displayBooks(person);

        System.out.println("\n");
    }
}