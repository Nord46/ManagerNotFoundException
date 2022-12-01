package org.example.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositorysTest {
    Book book1 = new Book(67, "War and Peace", 1500, "Lev Tolstoy");
    Smartphone phone1 = new Smartphone(89, "Iphone", 9500, "Apple");
    Book book2 = new Book(24, "Big debt crises", 2800, "Ray Dalio");
    Smartphone phone2 = new Smartphone(99, "Honor", 8400, "HUAWEI");

    @Test
    public void addProducts() {
        Repository repo = new Repository();
        repo.addProduct(book1);
        repo.addProduct(phone1);
        repo.addProduct(book2);
        repo.addProduct(phone2);
        Product[] expected = {book1, phone1, book2, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchProductText() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("War and Peace");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById() {
        Repository repo = new Repository();
        repo.addProduct(book1);
        repo.addProduct(phone1);
        repo.addProduct(book2);
        repo.addProduct(phone2);
        repo.removeById(67);
        Product[] expected = {phone1, book2, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByMissingID() {
        Repository repo = new Repository();
        repo.addProduct(book1);
        repo.addProduct(phone1);
        repo.addProduct(book2);
        repo.addProduct(phone2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(70);
        });
    }

    @Test
    public void changeId() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(book1);
        book1.setId(23);

        int expected = 23;
        int actual = book1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchPrice() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(phone2);
        phone2.setPrice(8400);

        int expected = 8400;
        int actual = phone2.getPrice();

        Assertions.assertEquals(expected, actual);
    }
}