package com.example.swp_backend.message;

import com.example.swp_backend.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
