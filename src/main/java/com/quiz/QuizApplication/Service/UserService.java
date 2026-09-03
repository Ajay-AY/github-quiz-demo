package com.quiz.QuizApplication.Service;

import com.quiz.QuizApplication.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User doRegister(User user);
    public User getUserByUsernameAndPassword(String username, String password);
}
