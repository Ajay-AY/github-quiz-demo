package com.quiz.QuizApplication.Controller;

import com.quiz.QuizApplication.Entity.Question;
import com.quiz.QuizApplication.Entity.User;
import com.quiz.QuizApplication.Service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Controller
public class AdminController {

    private final QuestionService questionService;

    public AdminController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/admin_home")
    public String adminHome(User user) {
        return "admin_home_page";
    }

    @GetMapping("/add_question")
    public String addQuestion() {
        return "admin_home_page";
    }


    @GetMapping("/all_question")
    public String viewQuestion(Model model) {
        List<Question> questions = questionService.getAllQues();
        LocalDate currentDate = LocalDate.now();
        List<Question> filterQuestions= questionService.getAllQues().stream().filter(question -> question.getDiscontinueDate()==null
                || question.getDiscontinueDate().isAfter(currentDate)).toList();
        model.addAttribute("questions",filterQuestions);
        return "view_questions";
    }

}
