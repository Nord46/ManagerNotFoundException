package org.example.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositorysTest {
    org.example.Products.Book book1 = new org.example.Products.Book(67, "War and Peace", 1500, "Lev Tolstoy");
    org.example.Products.Smartphone phone1 = new org.example.Products.Smartphone(89, "Iphone", 9500, "Apple");
    org.example.Products.Book book2 = new org.example.Products.Book(24, "Big debt crises", 2800, "Ray Dalio");
    org.example.Products.Smartphone phone2 = new org.example.Products.Smartphone(99, "Honor", 8400, "HUAWEI");

    @Test
    public void addProducts() {
        org.example.Products.Repository repo = new org.example.Products.Repository();
        repo.addProduct(book1);
        repo.addProduct(phone1);
        repo.addProduct(book2);
        repo.addProduct(phone2);
        org.example.Products.Product[] expected = {book1, phone1, book2, phone2};
        org.example.Products.Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchProductText() {
        org.example.Products.Repository repo = new org.example.Products.Repository();
        org.example.Products.Manager manager = new org.example.Products.Manager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        org.example.Products.Product[] expected = {book1};
        org.example.Products.Product[] actual = manager.searchBy("War and Peace");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById() {
        org.example.Products.Repository repo = new org.example.Products.Repository();
        repo.addProduct(book1);
        repo.addProduct(phone1);
        repo.addProduct(book2);
        repo.addProduct(phone2);
        repo.removeById(67);
        org.example.Products.Product[] expected = {phone1, book2, phone2};
        org.example.Products.Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByMissingID() {
        org.example.Products.Repository repo = new org.example.Products.Repository();
        repo.addProduct(book1);
        repo.addProduct(phone1);
        repo.addProduct(book2);
        repo.addProduct(phone2);

        Assertions.assertThrows(org.example.Products.NotFoundException.class, () -> {
            repo.removeById(70);
        });
    }

    @Test
    public void changeId() {
        org.example.Products.Repository repo = new org.example.Products.Repository();
        org.example.Products.Manager manager = new org.example.Products.Manager(repo);

        manager.add(book1);
        book1.setId(23);

        int expected = 23;
        int actual = book1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchPrice() {
        org.example.Products.Repository repo = new org.example.Products.Repository();
        org.example.Products.Manager manager = new org.example.Products.Manager(repo);

        manager.add(phone2);
        phone2.setPrice(8400);

        int expected = 8400;
        int actual = phone2.getPrice();

        Assertions.assertEquals(expected, actual);
    }
}