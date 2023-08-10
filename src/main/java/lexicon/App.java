package lexicon;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        // Create person object
        Person person = new Person("Anders", "Loren");

        // Create book object
        Book book = new Book("Pippi", "Astrid");
        person.loanBook(book, person);
//        System.out.println(book.getBorrower().getFullName());
        System.out.println(book.showPersonWhoBorrowed(book).getFullName());


    }
}
