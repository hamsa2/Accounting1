import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
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
        System.out.println(Arrays.toString(manager.searchBy("smos")));

    }
}
