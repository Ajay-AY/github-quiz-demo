package com.quiz.QuizApplication.Repository;

import com.quiz.QuizApplication.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

}
