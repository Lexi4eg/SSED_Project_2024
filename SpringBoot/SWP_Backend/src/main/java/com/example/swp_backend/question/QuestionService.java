package com.example.swp_backend.question;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question questionDetails) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question"));

        question.setQuestion(questionDetails.getQuestion());
        question.setAnswer1(questionDetails.getAnswer1());
        question.setAnswer2(questionDetails.getAnswer2());
        question.setAnswer3(questionDetails.getAnswer3());
        question.setAnswer4(questionDetails.getAnswer4());
        question.setCorrect1(questionDetails.isCorrect1());
        question.setCorrect2(questionDetails.isCorrect2());
        question.setCorrect3(questionDetails.isCorrect3());
        question.setCorrect4(questionDetails.isCorrect4());


        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question"));

        questionRepository.delete(question);
    }

}
