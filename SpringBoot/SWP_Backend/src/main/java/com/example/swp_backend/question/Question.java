package com.example.swp_backend.question;

import com.example.swp_backend.answer.Answer;
import jakarta.persistence.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", sequenceName = "question_seq", allocationSize = 1)

    private Long id;
    private String question;
    private boolean IsAnswered;
    private boolean IsCorrect ;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Question() {
    }

    public Question(Long id, String question, boolean isAnswered, boolean isCorrect, List<Answer> answers) {
        this.id = id;
        this.question = question;
        IsAnswered = isAnswered;
        IsCorrect = isCorrect;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswered() {
        return IsAnswered;
    }

    public void setAnswered(boolean answered) {
        IsAnswered = answered;
    }

    public boolean isCorrect() {
        return IsCorrect;
    }

    public void setCorrect(boolean correct) {
        IsCorrect = correct;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
