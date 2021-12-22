package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) ;
        Book book = (Book) product;
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Book();
        Book book = (Book) product;
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();
        product.toString();
    }
    @Test
    public void shouldUseEquals() {
        Book first = new Book(1, "Book", 90, "Lermontov");
        Book second = new Book(1, "Book", 90,"Lermontov");
        assertEquals(first, second);
    }
}