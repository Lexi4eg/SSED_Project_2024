package com.example.swp_backend.book;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    public List<Book> getBooks() {
        return List.of(
                new Book(
                        "The Great Gatsby",
                        "F. Scott Fitzgerald",
                        "Novel",
                        1925,
                        "9780743273565",
                        "The Great Gatsby is a novel written by American author F. Scott Fitzgerald that follows a cast of characters living in the fictional towns of West Egg and East Egg on prosperous Long Island in the summer of 1922.",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Gatsby_1925_jacket.gif/220px-Gatsby_1925_jacket.gif"
                )
        );
    }
}
