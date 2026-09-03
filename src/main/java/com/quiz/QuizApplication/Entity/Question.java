package com.quiz.QuizApplication.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String questionDesc;
    @Column
    private String rightAnswer;
    @Column
    private String option1;
    @Column
    private String option2;
    @Column
    private String option3;
    @Column
    private String option4;
    private LocalDate discontinueDate;

    public Integer getId() {
        return id;
    }

    public LocalDate getDiscontinueDate() {
        return discontinueDate;
    }

    public void setDiscontinueDate(LocalDate discontinueDate) {
        this.discontinueDate = discontinueDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionDesc='" + questionDesc + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                "discontinueDate=" + discontinueDate +
                '}';
    }
}
