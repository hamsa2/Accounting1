import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();

        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Cosmos");
        book1.setPrice(150);
        book1.setAuthor("King");

        Book book2 = new Book(2, "Animals", 100, "Noname");
        Smartphone phone1 = new Smartphone();
        phone1.setId(3);
        phone1.setName("PocoPhone");
        phone1.setPrice(30000);
        phone1.setManufacturer("Siome");
        Smartphone phone2 = new Smartphone(4, "Lagaxy", 40000, "Gnusmas");


        repo.add(book1);
        repo.add(book2);
        repo.add(phone1);
        repo.add(phone2);
        Product[] expected = {book1, book2, phone1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

        }
    @Test
    public void testRemove() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Cosmos", 100, "Noname");
        Book book2 = new Book(2, "Animals", 100, "Noname");
        Smartphone phone1 = new Smartphone(3, "PocoPhone", 30000, "Siome");
        Smartphone phone2 = new Smartphone(4, "Lagaxy", 40000, "Gnusmas");

        repo.add(book1);
        repo.add(book2);
        repo.add(phone1);
        repo.add(phone2);
        repo.removeById(2);
        repo.removeById(4);
        Product[] expected = {book1, phone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}


