package com.klef.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public int countBooks() {
        return bookList.size();
    }

    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookList;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookList.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Search result for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
