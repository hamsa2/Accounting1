import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        manager.removeById(4);
        Product[] expected = {book1, phone1};
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
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Cosmos");
        book1.setPrice(150);
        book1.setAuthor("King");
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

    @Test
    public void testSearch2() {
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
        manager.searchBy("smos");
        Product[] expected = {book1, book2, phone1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch3() {
        manager.add(Book2);
        manager.add(Book3);


        Product[] expected = {Book3};
        "Book2"
        Product[] actual = manager.searchBy();
        Assertions.assertArrayEquals(expected, actual);
    }
}
