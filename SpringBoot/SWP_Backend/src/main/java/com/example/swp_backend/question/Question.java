package com.example.swp_backend.question;

import jakarta.persistence.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", sequenceName = "question_seq", allocationSize = 1)

    private Long id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private boolean correct1;
    private boolean correct2;
    private boolean correct3;
    private boolean correct4;



    public Question() {
    }

    public Question(Long id, String question, String answer1, String answer2, String answer3, String answer4, boolean correct1, boolean correct2, boolean correct3, boolean correct4) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correct1 = correct1;
        this.correct2 = correct2;
        this.correct3 = correct3;
        this.correct4 = correct4;
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

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public boolean isCorrect1() {
        return correct1;
    }

    public void setCorrect1(boolean correct1) {
        this.correct1 = correct1;
    }

    public boolean isCorrect2() {
        return correct2;
    }

    public void setCorrect2(boolean correct2) {
        this.correct2 = correct2;
    }

    public boolean isCorrect3() {
        return correct3;
    }

    public void setCorrect3(boolean correct3) {
        this.correct3 = correct3;
    }

    public boolean isCorrect4() {
        return correct4;
    }

    public void setCorrect4(boolean correct4) {
        this.correct4 = correct4;
    }
}
