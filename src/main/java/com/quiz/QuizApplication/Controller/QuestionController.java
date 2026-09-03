package com.quiz.QuizApplication.Controller;

import com.quiz.QuizApplication.Entity.Question;
import com.quiz.QuizApplication.Service.QuestionService;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {


    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question")
    public String questionPage(){
        return "question";
    }


    @GetMapping("/")
    public String homePage(){
return "homepage";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
       LocalDate currentDate = LocalDate.now();
        return questionService.getAllQues().stream().filter(question -> question.getDiscontinueDate()==null
        || question.getDiscontinueDate().isAfter(currentDate)).toList();
    }

    @GetMapping("questions")
    public List<Question> getQuestion(){
        return null;
    }

    @PostMapping("/addQuestion")
    public String addQuestion( Question question){
        questionService.save(question);
        return "redirect:/admin_home";
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable  int id){
        Optional<Question> question = questionService.getQuestionById(id);
        question.ifPresent(value -> value.setDiscontinueDate(LocalDate.now()));
        question.ifPresent(questionService::save);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/updateQuestion/{id}")
    public String  updateQuestion(Model model, @PathVariable Integer id){
        Optional<Question> question = questionService.getQuestionById(id);
        model.addAttribute("question",question);
        return "update_question";
    }

    @PostMapping("/updateQuestion")
    public String  updateQuestion(Question question){
        questionService.save(question);
        return "redirect:/all_question";
    }
}
