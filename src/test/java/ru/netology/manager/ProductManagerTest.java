package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Queen of spades", 500, "Pushkin");
    Product second = new Book(2, "Dead souls", 650, "Gogol");
    Product third = new Book(3, "Master and Margarita", 730, "Bulgakov");
    Product fourth = new Smartphone(4, "Redmi", 15000, "Xiaomi");
    Product fifth = new Smartphone(5, "Iphone", 75000, "Apple");
    Product sixth = new Smartphone(6, "Galaxy", 27000, "Samsung");
    Product seven = new Smartphone( 7,"GalaxyA",25000,"Samsung");

    @BeforeEach
    void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seven);
    }

    @Test
    public void searchByNameBook() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Dead souls");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthor() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Pushkin");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacture() {
        Product[] expected = new Product[]{sixth};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNamePhone() {
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Redmi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy2Phone() {
        Product[] expected = new Product[]{sixth,seven};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }
}