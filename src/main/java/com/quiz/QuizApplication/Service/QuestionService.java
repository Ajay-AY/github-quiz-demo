package com.quiz.QuizApplication.Service;

import com.quiz.QuizApplication.Entity.Question;
import com.quiz.QuizApplication.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    public List<Question> getAllQues() {
        return questionRepo.findAll();
    }

    public Question save(Question question) {
        return questionRepo.save(question);
    }

    public void deleteById(int id) {
        questionRepo.deleteById(id);
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionRepo.findById(id);
    }
}
