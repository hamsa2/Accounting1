import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ManagerTest {


    @Test
    public void testAdd() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Cosmos", 100, "Noname");
        Book book2 = new Book(2, "Animals", 100, "Noname");
        Smartphone phone1 = new Smartphone(3, "PocoPhone", 30000, "Siome");
        Smartphone phone2 = new Smartphone(4, "Lagaxy", 40000, "Gnusmas");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        Product[] expected = {book1, book2, phone1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Cosmos", 100, "Noname");
        Book book2 = new Book(2, "Animals", 100, "Noname");
        Smartphone phone1 = new Smartphone(3, "PocoPhone", 30000, "Siome");
        Smartphone phone2 = new Smartphone(4, "Lagaxy", 40000, "Gnusmas");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        manager.removeById(2);
        Product[] expected = {book1, phone1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Cosmos", 100, "Noname");
        Book book2 = new Book(2, "Animals", 100, "Noname");
        Smartphone phone1 = new Smartphone(3, "PocoPhone", 30000, "Siome");
        Smartphone phone2 = new Smartphone(4, "Lagaxy", 40000, "Gnusmas");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        manager.searchBy("Phone");
        Product[] expected = {book1, book2, phone1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testContains() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Cosmos", 100, "Noname");
        Book book2 = new Book(2, "Animals", 100, "Noname");
        Smartphone phone1 = new Smartphone(3, "PocoPhone", 30000, "Siome");
        Smartphone phone2 = new Smartphone(4, "Lagaxy", 40000, "Gnusmas");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        manager.matches(phone1, "Poco");
        boolean expected = true;
        boolean actual = phone1.getName().contains("Poco");

        Assertions.assertEquals(expected, actual);
    }

}
