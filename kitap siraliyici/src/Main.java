import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("A", 400, "1", "01/01/2023");
        Book book2 = new Book("B", 200, "2", "01/02/2023");
        Book book3 = new Book("C", 500, "3", "01/03/2023");
        Book book4 = new Book("D", 100, "4", "01/04/2023");
        Book book5 = new Book("E", 300, "5", "01/05/2023");

        Set<Book> nameSortedBooks = new TreeSet<>();
        nameSortedBooks.add(book1);
        nameSortedBooks.add(book2);
        nameSortedBooks.add(book3);
        nameSortedBooks.add(book4);
        nameSortedBooks.add(book5);

        Set<Book> pageCountSortedBooks = new TreeSet<>(new Comparator<Book>() {
            public int compare(Book book1, Book book2) {
                return book1.getPageCount() - book2.getPageCount();
            }
        });

        pageCountSortedBooks.add(book1);
        pageCountSortedBooks.add(book2);
        pageCountSortedBooks.add(book3);
        pageCountSortedBooks.add(book4);
        pageCountSortedBooks.add(book5);

        System.out.println("Kitapların İsme Göre Sırası :");
        for (Book book : nameSortedBooks) {
            System.out.println(book);
        }

        System.out.println("\nKitapların Sayfa Sayısına Göre Sırası :");
        for (Book book : pageCountSortedBooks) {
            System.out.println(book);
        }
    }
}