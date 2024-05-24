package com.example.swp_backend.question;
import com.example.swp_backend.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
